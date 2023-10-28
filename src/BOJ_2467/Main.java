package BOJ_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static long[] solutions;

    private static long min = Long.MAX_VALUE;
    private static int maxLeft, maxRight;

    public static void main(String[] args) throws IOException {
        read();
        sol();
    }

    public static void sol() {
        int left = 0, right = N - 1;

        while(left < right) {
            long current = solutions[left] + solutions[right];

            if(Math.abs(current) <= Math.abs(min)) {
                min = current;
                maxLeft = left;
                maxRight = right;
            }

            if (current > 0) {
                right--;
            }
            else if(current < 0) {
                left++;
            }
            else break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(solutions[maxLeft]);
        sb.append(" ");
        sb.append(solutions[maxRight]);

        System.out.println(sb);
    }

    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            solutions = new long[N];
            String[] tokens = br.readLine().split(" ");

            for(int i = 0; i < N; i++) {
                solutions[i] = Long.parseLong(tokens[i]);
            }
        }
    }
}
