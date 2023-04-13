package Programmers_42577;
//https://school.programmers.co.kr/learn/courses/30/lessons/42577#
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        int index = 0;

        for(String phone : phone_book){
            if(index == phone_book.length - 1) break;

            if(phone_book[index + 1].matches(phone + ".*")) return false;
            index ++;
        }
        return answer;
    }
}
