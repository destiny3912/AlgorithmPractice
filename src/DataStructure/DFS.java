package DataStructure;

import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[9];

        //시작 노드를 스택에 넣고
        stack.push(1);
        //방문처리
        visited[1] = true;

        //Stack이 빌때까지
        while(!stack.isEmpty()){
            //Stack 꺼내기
            int idx = stack.pop();

            // 순서 출력
            System.out.print(idx + " -> ");

            //방금 꺼낸 노드의 인접 노드 방문처리
            for(int node : graph[idx]){
                if(!visited[node]) {
                    stack.push(node);
                    visited[node] = true;
                }
            }
        }

    }
}
