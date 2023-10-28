package BOJ_14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static int N, max;
    private static int[] numbers;
    private static int[] dp;


    public static void main(String[] args) throws IOException {
        read();
        sol();
    }

    private static void sol() {
        dp[0] = 1;
        max = dp[0];

        for(int i = 0; i < N; i++) {
            int flag = 0;

            for(int j = i - 1; j >= 0; j--) {
                if(numbers[j] < numbers[i] && dp[j] > flag) {
                    flag = dp[j];
                }
            }

            dp[i] = flag + 1;
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

        Stack<Integer> stack = new Stack<>();

        for(int i = N - 1; i >= 0; i--) {
            if(dp[i] == max) {
                stack.push(numbers[i]);
                max--;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append(" ");
        }

        System.out.println(sb);
    }


    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            numbers = new int[N];
            dp = new int[N];


            for(int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
