package Programmers_42578;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothCount = new HashMap<>();
        //카운트
        for(String[] cloth : clothes){
            if(!clothCount.containsKey(cloth[1])){
                clothCount.put(cloth[1], 1);
                continue;
            }

            int tempCount = clothCount.get(cloth[1]);
            clothCount.put(cloth[1], tempCount + 1);
        }

        List<Integer> countList = new ArrayList<>();
        //List에다가 넣기
        for(String key : clothCount.keySet()){
            countList.add(clothCount.get(key));
        }

        //합 구하기
        for(int num : countList){
            answer = answer * (num + 1);
        }
        return answer - 1;
    }
}
