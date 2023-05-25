package Beakjoon_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/2805
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String token = br.readLine();

        int N = Integer.parseInt(token.split(" ")[0]);
        int M = Integer.parseInt(token.split(" ")[1]);

        token = br.readLine();
        String[] tokens = token.split(" ");

        long[] treeArr = new long[N];

        for(int idx = 0; idx < N; idx++){
            treeArr[idx] = Long.parseLong(tokens[idx]);
        }

        Arrays.sort(treeArr);

        long start = 0;
        long end = treeArr[N - 1];
        long result = 0;

        while(start <= end){
            // 자르는 기준 -> 매개변수
            long mid = (start + end) / 2;

            // 잘라낸 나무 길이의 합
            long cutLength = 0;

            for(int idx = 0; idx < N; idx++){
                long cut = treeArr[idx] - mid;
                if(cut > 0){
                    cutLength += cut;
                }
            }

            if(cutLength >= M){
                result = Math.max(result, mid);
                //이것보다 더 높이서 잘라도 될까?
                start = mid + 1;
            }
            else{
                //이것 보다 더 낮은 높이에서 잘라야 한다.
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
