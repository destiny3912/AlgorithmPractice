package BOJ_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int N = Integer.parseInt(line.split(" ")[0]);
        int maxWeight = Integer.parseInt(line.split(" ")[1]);

        int[] weightArr = new int[N + 1];
        int[] valueArr = new int[N + 1];

        for(int i = 1; i <= N; i++){
            line = br.readLine();

            weightArr[i] = Integer.parseInt(line.split(" ")[0]);
            valueArr[i] = Integer.parseInt(line.split(" ")[1]);
        }

        int[][] dp = new int[N + 1][maxWeight + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= maxWeight; j++){

                dp[i][j] = dp[i-1][j];

                if(j - weightArr[i] >=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weightArr[i]] + valueArr[i]);
                }
            }
        }

        System.out.println(dp[N][maxWeight]);
    }
}
