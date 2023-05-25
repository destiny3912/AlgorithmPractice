package Beakjoon_2110;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String token = br.readLine();

        int N = Integer.parseInt(token.split(" ")[0]);
        int C = Integer.parseInt(token.split(" ")[1]);

        int[] houseArr = new int[N];

        for(int idx = 0; idx < N; idx++){
            houseArr[idx] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houseArr);

        int start = 1;
        int end = houseArr[N - 1] - houseArr[0];
        int result = 0;

        while(start <= end){
            int mid = (start + end) / 2;

            //이전에 설치한 집 좌표
            int prevInstalled = houseArr[0];
            //설치한 카운트 -> 첫 집에는 무조건 설치하므로
            int count = 1;

            for(int idx = 1; idx < N; idx++){
                if(houseArr[idx] - prevInstalled >= mid){
                    count++;
                    prevInstalled = houseArr[idx];
                }
            }

            // 설치한 갯수를 비교
            if(count >= C){
                result = Math.max(result, mid);
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
