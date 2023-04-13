package Programmers_42862;

import java.util.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args){
        int[] reserve = {1, 2, 3};
        int[] lost = {2, 4};

        System.out.println(solution(5, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int cannotBorrow = 0;
        List<Integer> already = new ArrayList<>();

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int student : lost){
            if(!canBorrow(student, reserve, lost, already)){
                cannotBorrow++;
            }
        }

        return n - cannotBorrow;
    }

    private static boolean canBorrow(int student, int[] reserve, int[] lost, List<Integer> already){
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());

        //잃어 버렸으나 여벌이 있네?
        if(reserveList.contains(student)){
            already.add(student);
            return true;
        }
        //앞의 학생에게 먼저 빌리기
        if(reserveList.contains(student - 1) && !already.contains(student - 1) && !lostList.contains(student - 1)){
            already.add(student - 1);
            return true;
        }
        //앞의 학생이 없다면 뒤의 학생에게 빌리기
        if(reserveList.contains(student + 1) && !already.contains(student + 1) && !lostList.contains(student + 1)){
            already.add(student + 1);
            return true;
        }

        //빌릴 수 없다면
        return false;
    }
}