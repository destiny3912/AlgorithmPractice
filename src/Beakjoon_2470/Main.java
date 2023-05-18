package Beakjoon_2470;

import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String sols = br.readLine();

        List<Integer> solutionList = new ArrayList<>();

        for(String sol : sols.split(" ")){
            solutionList.add(Integer.parseInt(sol));
        }

        //Sort
        Collections.sort(solutionList);

        /**
         * 기본 : 투포인터
         * */

        int minIdx = 0;
        int maxIdx = N - 1;
        int maxVal = solutionList.get(N - 1), minVal = solutionList.get(0);
        int currentSum = Integer.MAX_VALUE;
        boolean flag;

        while(minIdx < maxIdx){

            //이번 pass의 합을 보자
            int tempSum = solutionList.get(minIdx) + solutionList.get(maxIdx);

            //만약에 절대값이 더 작다면 업데이트
            if(Math.abs(currentSum) > Math.abs(tempSum)) {
                minVal = solutionList.get(minIdx);
                maxVal = solutionList.get(maxIdx);
                currentSum = tempSum;

                if(currentSum == 0) break;
            }

            //합이 0보다 크나요 작나요 크면 T 작으면 F
            flag = tempSum > 0;
            //0보다 작다면 절대값을 작게할라면 두 수의 합이 커져야 한다 minIdx++
            if(!flag) minIdx++;
            //0보다 크다면 절대값을 작게 할라면 두 수의 합이 작아져야 한다 maxIdx++
            else maxIdx--;
        }

        System.out.println(minVal + " " + maxVal);
    }
}
