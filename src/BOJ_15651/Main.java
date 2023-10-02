package BOJ_15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();

    private static int[] selected;
    public static void main(String[] args) throws IOException {
        reader();

        sol(1);

        System.out.println(sb.toString());
    }

    private static void sol(int k) {
        if(k == M + 1) { // 하나의 라인을 다 골랐을때
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append("\n");

        }else { // 아직 다 못 골랐을때
            for(int target = 1; target <= N; target++) {
                selected[k] = target;
                sol(k + 1);
                selected[k] = 0;
            }
        }


    }
    private static void reader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        N = Integer.parseInt(line.split(" ")[0]);
        M = Integer.parseInt(line.split(" ")[1]);

        selected = new int[M + 1];
    }
}
