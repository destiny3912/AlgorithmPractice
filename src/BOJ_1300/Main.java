package BOJ_1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static long N, K;
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(sol());
    }

    public static long sol(){
        long left = 0, right = N * N, result = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            // 각 행에서 기준값 보다 작은 값 갯수 카운트
            for(int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            // 카운트가 적다면 기준 값을 올려보자
            if(count < K) left = mid + 1;
            // 카운트가 크거나 같다면 정답일 가능성잉 있으므로 임시로 저장하고 기준값을 조금 더 줄여보자
            else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }
    public static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Long.parseLong(br.readLine());
            K = Long.parseLong(br.readLine());
        }
    }
}
