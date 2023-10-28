package BOJ_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static int N;
    private static String[][] map;
    private static int[][] visited;

    private static int count = 0;
    // 상 우 하 좌
    private static final int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        read();
        sol();
    }

    private static void sol() {
        StringBuilder sb = new StringBuilder();
        // 적록 색약은 어떻게 볼까 -> 빨강과 초록을 같은 색으로 본다.
        // 구역의 갯수를 2번 세라 다만 각각의 조건을 달리한다
        // 구역의 갯수를 어떻게 세나? -> DFS?
        // 노드를 전부 순회 하면서
        // 연결되어있는 모든 노드 (색이 같은 노드)를 전부 방문처리
        // 만약 방문 처리되어있다면 패스 아니라면 위 방식을 적용
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] == 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        sb.append(count);
        sb.append(" ");

        count = 0;
        visited = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j].equals("G")) map[i][j] = "R";
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] == 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        sb.append(count);

        System.out.println(sb);
    }

    private static void dfs(int i, int j) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(i, j));
        visited[i][j] = 1;

        while(!stack.isEmpty()) {
            Node current = stack.pop();
            String color = map[current.i][current.j];

            for(int k = 0; k < 4; k++) {
                int movI = current.i + dx[k], movJ = current.j + dy[k];

                if(movI < 0 || movI >= N || movJ < 0 || movJ >= N) continue;
                if(visited[movI][movJ] == 1) continue;
                if(map[movI][movJ].equals(color)) {
                    stack.push(new Node(movI, movJ));
                    visited[movI][movJ] = 1;
                }
            }
        }
    }

    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            map = new String[N][N];
            visited = new int[N][N];

            for(int i = 0; i < N; i++) {
                String[] tokens = br.readLine().split("");
                for(int j = 0; j < N; j++) {
                    map[i][j] = tokens[j];
                }
            }
        }
    }

    private static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
