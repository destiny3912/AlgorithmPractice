package Beakjoon_14501;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int day = Integer.parseInt(br.readLine());

        int[] T = new int[day + 15];
        int[] P = new int[day + 15];
        int[] dp = new int[day + 15];
        int max = 0;

        for(int idx = 0; idx < day; idx++){
            String[] temp = br.readLine().split(" ");

            T[idx] = Integer.parseInt(temp[0]);
            P[idx] = Integer.parseInt(temp[1]);
        }

        for(int idx = 0; idx <= day; idx++){
            dp[idx] = Math.max(dp[idx], max);

            //점화식
            dp[T[idx] + idx] = Math.max(dp[T[idx] + idx], P[idx] + dp[idx]);

            max = Math.max(max, dp[idx]);
        }

        System.out.println(max);
    }
}
