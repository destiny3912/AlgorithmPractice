package SL_Week4_Lab3;

import java.io.*;
import java.util.*;

/**
 * 1. 입력은 처음 문제 조건으로 진행하였습니다.
 * 2. 리스트에 대해서 처음부터 올라가면서 새로 깔리는 선이 겹친다면 그 선을 자름
 * 3. 다시 리스트에 대해서 끝에서부터 내려오면서 새로 깔리는 선이 겹친다면 그 선을 자름
 * 4. 2번과 3번의 경우에서 더 적게 잘리는 것을 프린트
 * */
public class Sol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int pillNum = Integer.parseInt(st.nextToken());

        int[] numbers = new int[pillNum];

        st = new StringTokenizer(br.readLine());

        for(int index = 0; index < pillNum; index++){
            numbers[index] = Integer.parseInt(st.nextToken());
        }

        int cutFlag = 0; // 자르는 기준 플래그
        int cutCount = 0; // 정방향에서 자르는 갯수
        int reverseCutCount = 0; // 역방향에서 자르는 갯수

        //0번 인덱스부터 끝번까지 올라가면서 겹친다면 그때의 간선을 자르기
        for (int number : numbers) {
            if (cutFlag > number) {
                cutCount++;
            } else {
                cutFlag = number;
            }
        }

        cutFlag = numbers.length;
        //끝번 인덱스부터 0번까지 내려가면서 겹친다면 그때의 간선을 자르기
        for(int index = numbers.length - 1; index >= 0; index--){
            if (cutFlag > numbers[index]) {
                cutFlag = numbers[index];
            } else {
                reverseCutCount++;
            }
        }


        System.out.println(Math.min(cutCount, reverseCutCount));
    }
}
