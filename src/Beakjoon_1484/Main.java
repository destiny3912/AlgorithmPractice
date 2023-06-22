package Beakjoon_1484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());

        int memory = 1;
        List<Integer> answer = new ArrayList<>();

        //current^2 - memory^2 = G
        //current^2 = G + memory^2
        //current = sqrt(G + memory^2)

        while(true){
            if(memory > G) break;

            //현제 메모리값에서 방정식의 값 구하기
            double target = Math.sqrt((G + Math.pow(memory, 2)));

            //방정식의 해가 자연수라면 더하기
            if(Math.floor(target) == target) answer.add((int)target);

            //기억하고 있는 값 ++
            memory++;
        }

        if(answer.isEmpty()){
            System.out.println(-1);
        }
        else {
            for(int element : answer){
                System.out.println(element);
            }
        }

    }
}
