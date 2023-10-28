package BOJ_15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, H, count = 0;

    private static int[][] map;
    private static boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        read();
        sol();
    }

    private static void sol() {
        for(int i = 0; i <= 3; i++) {
            count = i;
            dfs(1, 1, 0);
            if(isEnd) break;
        }

        if(isEnd)
            System.out.println(count);
        else
            System.out.println(-1);
    }

    private static void dfs(int x, int y, int addCount) {
        if(isEnd) return;
        if(count == addCount) {
            if(check()) isEnd = true;
            return;
        }

        for(int i = y; i < H + 1; i++) {
            for(int j = x; j < N; j++) {
                if(map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;

                    dfs(1, 1, addCount + 1);

                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean check() {
        for(int i = 1; i < N + 1; i++) {
            int x = i;
            int y = 1;

            while(y < H + 1) {
                if(map[y][x] == 1) x++;
                else if(map[y][x] == 2) x--;
                y++;
            }

            if(x != i) return false;
        }

        return true;
    }
    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H + 1][N + 1];

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
                map[x][y + 1] = 2;
            }
        }
    }
}
