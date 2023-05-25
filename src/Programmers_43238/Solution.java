package Programmers_43238;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long min = 0;
        long max = Long.MAX_VALUE;

        while(min <= max){
            long mid = (min + max) / 2;

            //해당 시간안에 각 심사관이 몇명을 심사하는지 체크
            long temp = 0;

            for(int time : times){
                long canProcess = mid / time;
                temp += canProcess;
                //최적화를 위해 n 이상 가는 애들은 더 볼 필요 없으므로 컷
                if(temp > n) break;
            }

            //해당 시간안에 해치우는 대상자 수를 전부 합해서
            //해당 값이 목표하는 대상자 보다 작다면 시간을 늘린다 -> min = mid + 1
            if(temp < n){
                min = mid + 1;
            }
            //반대로 해당 값이 목표하는 대상자보다 크다면 시간을 줄인다.
            else if(temp >= n){
                max = mid - 1;
            }
        }
        return min;
    }
}
