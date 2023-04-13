package Beakhoon_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
    static List<Integer> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String testCase = br.readLine();
        int N = Integer.parseInt(testCase.split(" ")[0]);
        int K = Integer.parseInt(testCase.split(" ")[1]);
        long max = 0;

        for(int index = 0; index < N; index++){
            int temp = Integer.parseInt(br.readLine());
            lines.add(temp);
            if(temp > max) max = temp;
        }

        max++;

        long mid = 0;
        long min = 0;

        while(min < max){
            mid = (min + max) / 2;
            long result = 0;

            for(int line : lines){
                result = result + line / mid;
            }

            if(result < K){
                max = mid;
            }
            else{
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
