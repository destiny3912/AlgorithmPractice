package BOJ_9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String[] s1, s2;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        read();
        sol();
    }

    private static void sol() {
        for(int i = 1; i < s1.length + 1; i++) {
            for(int j = 1; j < s2.length + 1; j++) {
                if(s1[i - 1].equals(s2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[s1.length][s2.length]);
    }
    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            s1 = br.readLine().split("");
            s2 = br.readLine().split("");

            dp = new int[s1.length + 1][s2.length + 1];
        }
    }
}
