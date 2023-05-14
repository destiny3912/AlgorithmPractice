package Programmers_43165;
/*
0을 루트로하고 좌측으로 가면 숫자를 빼고 우측으로 가면 숫자를 더하는 트리를 만들어
리프 노드만 탐색을 하면 끝
*/

class Solution {
    private int answer = 0;

    public int solution(int[] numbers, int target) {
        pushNum(0, numbers[0], 0, numbers, target);

        return answer;
    }

    public void pushNum(int parentNum, int targetNum, int index, int[] numbers, int target){
        int left = parentNum - targetNum;
        int right = parentNum + targetNum;

        if(index == numbers.length - 1){
            if(left == target) answer++;
            if(right == target) answer++;
        }

        index++;

        if(index == numbers.length) return;

        pushNum(left, numbers[index], index, numbers, target);
        pushNum(right, numbers[index], index, numbers, target);
    }
}
