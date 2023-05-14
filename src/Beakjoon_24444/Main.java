package Beakjoon_24444;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        //문제 조건 숫자들
        int N = Integer.parseInt(line.split(" ")[0]); // 정점 갯수
        int M = Integer.parseInt(line.split(" ")[1]); // 간선 갯수
        int R = Integer.parseInt(line.split(" ")[2]); // 시작 정점

        //그래프 인접 리스트
        List<List<Integer>> graph = new ArrayList<>(new ArrayList<>());

        //인접 리스트 초기화
        for(int idx = 0; idx < N + 1; idx++){
            graph.add(new ArrayList<>());
        }

        //그래프 만들기
        for(int idx = 0; idx < M; idx++){
            String temp = br.readLine();
            int i = Integer.parseInt(temp.split(" ")[0]);
            int j = Integer.parseInt(temp.split(" ")[1]);

            //양방향 그래프 이므로
            graph.get(i).add(j);
            graph.get(j).add(i);
        }

        //각 정점의 방문은 오름차순이어야 하므로 각 인접 리스트 정렬
        for(List<Integer> adjList : graph){
            Collections.sort(adjList);
        }

        //방문 여부
        boolean[] visited = new boolean[N + 1];
        //각 정점의 방문 순서
        int[] visitList = new int[N + 1];

        //BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();

        //첫 정점 큐에 넣기
        queue.offer(R);
        //방문처리
        visited[R] = true;

        // 방문 순서 유지위한 변수
        int visitOrder = 1;

        while (!queue.isEmpty()){
            //큐에서 꺼내기
            int idx = queue.poll();

            //방문 순서
            visitList[idx] = visitOrder;
            visitOrder++;

            for(int child : graph.get(idx)){
                if(!visited[child]){
                    //방문 처리
                    visited[child] = true;
                    //큐에 추가
                    queue.offer(child);
                }
            }

        }

        //순서 출력
        for(int idx = 1; idx < N + 1; idx++){
            System.out.println(visitList[idx]);
        }
    }
}
