package BOJ_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int M;

    private static final StringBuilder sb = new StringBuilder();

    private static int[] selected;

    public static void main(String[] args) throws IOException {
        reader();

        sol(1);

        System.out.println(sb);
    }

    private static void sol(int k) {
        // 전부 다 골랐을때
        if(k == M + 1){
            for(int i = 1; i <= M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append("\n");
        }
        //다 고르지 못했을때
        else {
            for(int target = selected[k-1] + 1; target <= N; target++){
                //k번째에 target이 올 수 있으면 다음을 실행
                selected[k] = target;
                sol(k + 1);
                //전부 붙였으므로 초기화
                selected[k] = 0;
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
