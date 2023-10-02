package BOJ_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int S;
    private static int[] numbers;

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        read();
        //부분수열 1개부터 N개 까지
        for(int i = 1; i <= N; i++) {
            sol(i, 0, 0, -1);
        }
        System.out.println(count);
    }

    private static void sol(int pickNum, int stage, int sum, int prevIdx) {
        // 원하는 갯수를 골랐을때
        if(pickNum == stage) {
            //합이 맞나 체크
            if(sum == S){
                count++;
            }
        }
        else{
            int tempSum = sum;

            for(int i = prevIdx + 1; i < N; i++){
                tempSum += numbers[i];
                sol(pickNum, stage + 1, tempSum, i);
                tempSum = sum;
            }
        }
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        N = Integer.parseInt(line.split(" ")[0]);
        S = Integer.parseInt(line.split(" ")[1]);

        line = br.readLine();
        String[] tokens = line.split(" ");
        numbers = new int[N];

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(tokens[i]);
        }

        br.close();
    }
}
