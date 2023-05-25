package Beakjoon_1967;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 트리의 지름은 한 리프노드에서 다른 리프노드까지의 거리 중 최대이다
 * 따라서 리프노드에서 시작하는 dfs를 모든 리프 노드에 대하여 시행한다.
 * */

public class Main {

    static class Node{
        int edge;
        int dist;

        Node(int edge, int dist){
            this.edge = edge;
            this.dist = dist;
        }
    }

    private static ArrayList<Node>[] tree;
    private static int maxDist = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];

        for(int idx = 1; idx <= N; idx++){
            tree[idx] = new ArrayList<>();
        }

        for(int idx = 1; idx < N; idx++){
            String token = br.readLine();

            int i = Integer.parseInt(token.split(" ")[0]);
            int j = Integer.parseInt(token.split(" ")[1]);
            int dis = Integer.parseInt(token.split(" ")[2]);

            tree[idx].add(new Node(j, dis));
            tree[idx].add(new Node(i, dis));
        }

        List<Integer> leafList = new ArrayList<>();

        for(int idx = 2; idx <= N; idx++){
           if(tree[idx] != null && tree[idx].size() < 2){
               leafList.add(idx);
           }
        }

        boolean[] visited;

        for (Integer integer : leafList) {
            visited = new boolean[N + 1];
            visited[integer] = true;
            dfs(integer, 0, integer, visited);
        }

        System.out.println(maxDist);
    }

    private static void dfs(int nodeIdx, int distSum, int startNode, boolean[] visited){
        if(tree[nodeIdx].size() < 2 && nodeIdx != startNode){
            maxDist = Math.max(maxDist, distSum);
            System.out.println(maxDist);
            return;
        }

        for(int idx = 0; idx < tree[idx].size(); idx++){
            int nextNode = tree[nodeIdx].get(idx).edge;

            if(!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode, distSum + tree[nodeIdx].get(idx).dist, startNode, visited);
            }
        }
    }
}
