package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        boolean[] visited = new boolean[9];

        System.out.println(bfs(1, graph, visited));
    }

    private static String bfs(int start, int[][] graph, boolean[] visited){
        StringBuilder sb = new StringBuilder();

        //방문할 노드를 저장할 Queue
        Queue<Integer> queue = new LinkedList<>();

        //초기값 offer
        queue.offer(start);

        //root 방문처리
        visited[start] = true;

        //큐가 빌때까지
        while(!queue.isEmpty()){
            //방문할 노드의 인덱스
            int idx = queue.poll();
            sb.append(idx + " -> ");

            //방문한 노드의 자식을 서칭해 큐에 저장
            for(int i = 0; i < graph[idx].length; i++){
                int child = graph[idx][i];

                if(!visited[child]){
                    //방문 처리
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }

        return sb.toString();
    }
}
