package BOJ_1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[] plan;

    public static void main(String[] args) throws IOException{
        read();
        String result = sol() ? "YES" : "NO";
        System.out.println(result);
    }

    public static boolean sol() {
        for(int i = 0; i < M; i++) {
            int current = plan[i];
            int next;

            if(!(i == M - 1)) {
                next = plan[i + 1];
            }
            else {
                continue;
            }

            if(!dfs(current, next)) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(int start, int target) {
        if(start == target) return true;
        int current = 0;
        boolean[] visited = new boolean[N];

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()) {
            current = stack.pop();

            for(int i = 0; i < N; i++) {
                if(map[current - 1][i] == 1) {
                    if(i == target - 1) {
                        stack.clear();
                        return true;
                    }

                    if(map[current - 1][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        stack.push(i + 1);
                    }
                }
            }
        }

        return false;
    }

    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            map = new int[N][N];
            plan = new int[M];

            StringTokenizer st;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
