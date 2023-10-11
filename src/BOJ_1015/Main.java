package BOJ_1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int N;
    private static Integer[] A, P;

    private static Block[] B;

    public static void main(String[] args) throws IOException {
        read();
        sol();
    }

    private static void sol() {
        Arrays.sort(B);

        for(int i = 0; i < N; i++) {
            P[B[i].idx] = i;
        }

        for(int i = 0; i < N; i++) {
            System.out.print(P[i]+ " ");
        }
    }

    private static void read() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            String[] tokens = br.readLine().split(" ");
            A = new Integer[N];
            B = new Block[N];
            P = new Integer[N];

            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(tokens[i]);
                B[i] = new Block(A[i], i);
            }
        }
    }

    private static class Block implements Comparable<Block>{
        int num;
        int idx;

        public Block(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        // 앞에 위치 해야하면 음수
        // 뒤에 위치 해야하면 양수
        @Override
        public int compareTo(Block o) {
            //두 수 중에서 더 큰 값이 뒤로가야함
            //같으면 냅두자
            return this.num - o.num;
        }
    }
}
