package SL_Week6_Lab1;

import java.util.*;
import java.io.*;

public class Sol {

    private static int drugNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String token = br.readLine();

        drugNum = Integer.parseInt(token.split(" ")[0]);
        int related = Integer.parseInt(token.split(" ")[1]);

        //Tree 인접행렬
        boolean[][] tree = new boolean[drugNum][drugNum];
        //Tree node 방문여부 : 초기화 false
        boolean[] visited = new boolean[drugNum];

        //트리 구성
        for(int idx = 0; idx < related; idx++){
            token = br.readLine();
            int i = Integer.parseInt(token.split(" ")[0]);
            int j = Integer.parseInt(token.split(" ")[1]);

            tree[i][j] = true;
            tree[j][i] = true;
        }

        //트리 탐색
        dfs(0, visited, tree);

        //연결되어있지 않은 노드가 없는지 여부
        boolean flag = true;

        //모든 노드 연결 여부 체크
        for(boolean isVisited : visited){
            if (!isVisited) {
                flag = false;
                break;
            }
        }

        //조건에 따라 프린트
        if(flag) System.out.println(1);
        else System.out.println(0);
    }

    private static void dfs(int node, boolean[] visited, boolean[][] tree){
        //이미 방문한 노드라면 return
        if(visited[node]) {
            return;
        }

        //노드 방문 처리 및 DFS 내려보내기
        for(int idx = 0; idx < drugNum; idx++){
            if(tree[node][idx]){
                visited[node] = true;
                dfs(idx, visited, tree);
            }
        }
    }
}
