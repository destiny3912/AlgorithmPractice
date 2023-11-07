package BOJ_2248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, L;
    private static long I;
    private static long[][] dp;


    public static void main(String[] args) throws IOException{
        read();
        sol();
    }

    private static void sol() {
        dp[0][0] = 1;

        for(int i = 1; i < N + 1; i++) {
            //i자리의 숫자 전부 0인경우
            dp[i][0] = 1;
            //1이 1개부터 L개 까지
            for(int j = 1; j < L + 1; j++) {
                // 이항계수
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = N; i >= 1; i--) {
            long sum = 0;

            for(int j = 0; j < L + 1; j++) {
                sum += dp[i - 1][j];
            }

            if(sum >= I) sb.append("0");
            else {
                sb.append("1");
                //1을 사용했음
                L--;
                I = I - sum;
            }
        }

        System.out.println(sb);
    }

    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            I = Long.parseLong(st.nextToken());

            dp = new long[N + 1][L + 1];
        }
    }
}
