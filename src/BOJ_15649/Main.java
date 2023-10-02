package BOJ_15649;

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

                boolean isUsed = false;

                for(int i = 0; i <= N; i++) {
                    if (target == selected[i]) {
                        isUsed = true;
                        break;
                    }
                }

                //그 자리에 올 수 있으면
                if (!isUsed)
                {
                    selected[k] = target;
                    sol(k + 1);
                    selected[k] = 0;
                }
            }
        }
    }

    private static void reader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        N = Integer.parseInt(line.split(" ")[0]);
        M = Integer.parseInt(line.split(" ")[1]);

        selected = new int[N + 1];
    }
}
