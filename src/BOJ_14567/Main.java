package BOJ_14567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int N = Integer.parseInt(line.split(" ")[0]);
        int M = Integer.parseInt(line.split(" ")[1]);

        boolean[][] condition = new boolean[N + 1][N + 1];
        int[] in = new int[N + 1];
        int[] dp = new int[N + 1];

        for(int idx = 0; idx < M; idx++){
            line = br.readLine();

            int i = Integer.parseInt(line.split(" ")[0]);
            int j = Integer.parseInt(line.split(" ")[1]);

            condition[i][j] = true;
            in[j]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(in[i] == 0){
                queue.offer(i);
            }
        }

        int semesterNum = 1;

        while(!queue.isEmpty()){
            int queueSize = queue.size();

            for(int i = 0; i < queueSize; i++){
                int current = queue.poll();

                dp[current] = semesterNum;

                for(int j = current + 1; j <= N; j++){
                    if(condition[current][j]){
                        in[j]--;
                        if(in[j] == 0){
                            queue.offer(j);
                        }
                    }
                }
            }

            semesterNum++;
        }

        for(int i = 1; i <= N; i++){
            System.out.print(dp[i] + " ");
        }
    }
}
