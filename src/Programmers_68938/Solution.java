package Programmers_68938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Link: https://school.programmers.co.kr/learn/courses/30/lessons/68938
public class Solution {

    private static long[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        System.out.println(s.length());
        long temp = solution(s);

        for(long[] row : result){
            for(long element: row){
                System.out.print(element + " ");
            }
            System.out.println(" ");
        }
    }

    public static long solution(String s) {

        result = new long[s.length()][s.length()];

        long subScore = subString(s, 0, s.length() - 1);

        result[0][s.length() - 1] = subScore;

        long sum = 0;

        for(long[] row : result){
            for(long element: row){
                sum += element;
            }
        }

        return sum;
    }

    private static long subString(String target, int leftIndex, int rightIndex){
        long subResult;

        if(leftIndex == rightIndex - 1){
            if(target.charAt(leftIndex) == target.charAt(rightIndex)){
                //양 끝을 제외한 중간 Substring의 최대값이 최대이므로 최대값 연산
                subResult = 0;
            }
            //양 끝 문자가 다른 경우
            else{
                //양 끝의 인덱스를 뺸 값이 최대이므로 인덱스 차 연산
                subResult = 1;
            }

            result[leftIndex][rightIndex] = subResult;
            return subResult;
        }

        long leftSubScore = subString(target, leftIndex, rightIndex - 1);
        long rightSubScore = subString(target, leftIndex + 1, rightIndex);

        //양 끝 문자가 같은 경우
        if(target.charAt(leftIndex) == target.charAt(rightIndex)){
            //양 끝을 제외한 중간 Substring의 최대값이 최대이므로 최대값 연산
            subResult = Math.max(leftSubScore, rightSubScore);
        }
        //양 끝 문자가 다른 경우
        else{
            //양 끝의 인덱스를 뺸 값이 최대이므로 인덱스 차 연산
            subResult = rightIndex - leftIndex;
        }

        result[leftIndex][rightIndex] = subResult;
        return subResult;
    }
}
