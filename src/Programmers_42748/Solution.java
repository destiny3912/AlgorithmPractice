package Programmers_42748;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int idx = 0;

        int[] answer = new int[commands.length];

        for(int[] command : commands){
            int[] targetArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);

            Arrays.sort(targetArray);

            answer[idx] = targetArray[command[2] - 1];

            idx++;
        }


        return answer;
    }
}
