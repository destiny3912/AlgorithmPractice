package BOJ_2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int[][] map, maxDp, minDp;

    public static void main(String[] args) throws IOException {
        read();
        sol(1);
        int max = maxThree(maxDp[N - 1][0], maxDp[N - 1][1], maxDp[N - 1][2]);
        int min = minThree(minDp[N - 1][0], minDp[N - 1][1], minDp[N - 1][2]);

        System.out.println(max + " " + min);
    }

    private static void sol(int level) {

        while(level < N) {

            //첫번째 칸
            maxDp[level][0] = Math.max(map[level][0] + maxDp[level - 1][0], map[level][0] + maxDp[level - 1][1]);
            minDp[level][0] = Math.min(map[level][0] + minDp[level - 1][0], map[level][0] + minDp[level - 1][1]);
            //두번째 칸
            maxDp[level][1] = maxThree(map[level][1] + maxDp[level - 1][0], map[level][1] + maxDp[level - 1][1], map[level][1] + maxDp[level - 1][2]);
            minDp[level][1] = minThree(map[level][1] + minDp[level - 1][0], map[level][1] + minDp[level - 1][1], map[level][1] + minDp[level - 1][2]);
            //세번째 칸
            maxDp[level][2] = Math.max(map[level][2] + maxDp[level - 1][1], map[level][2] + maxDp[level - 1][2]);
            minDp[level][2] = Math.min(map[level][2] + minDp[level - 1][1], map[level][2] + minDp[level - 1][2]);

            level++;
        }
    }

    private static int maxThree(int n1, int n2, int n3) {
        return Math.max(Math.max(n1, n2), n3);
    }

    private static int minThree(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }

    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][3];
            maxDp = new int[N][3];
            minDp = new int[N][3];

            String line;
            String[] tokens;

            for(int i = 0; i < N; i++) {
                line = br.readLine();
                tokens = line.split(" ");

                for(int j = 0; j < 3; j++) {
                    map[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            maxDp[0] = map[0].clone();
            minDp[0] = map[0].clone();
        }
    }
}
