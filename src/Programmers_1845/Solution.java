package Programmers_1845;

/**
 구하는 것: 배열에서 서로 다른 숫자의 갯수 다만 최대로 고를 수 있는 갯수는 N/2에 한한다.
 https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int N = nums.length;

        Map<Integer, Integer> targetCount = new HashMap<>();

        for(int num : nums){
            if(targetCount.containsKey(num)){
                int targetNum = targetCount.get(num);
                targetCount.put(num, targetNum + 1);
            }
            else{
                targetCount.put(num, 1);
            }
        }

        int answerCount = targetCount.size();

        if(answerCount > N/2) answer = N/2;
        else answer = answerCount;

        return answer;
    }
}
