package BOJ_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    private static int[] nums, operators = new int[4], sequence;
    public static void main(String[] args) throws IOException {
        input();
        solution(0);
        System.out.println(max + "\n" + min);
    }

    private static void solution(int k){
        //연산자를 다 고른 경우
        if(k == N - 1){
            //연산을 하고
            int result = cal();
            //최대최소 업데이트
            min = Math.min(min, result);
            max = Math.max(max, result);
        }
        //연산자를 다 고르지 못한 경우
        else {
            //연산자 고르기
            //4방향 서치
            for(int oper = 0; oper < 4; oper++){
                if(operators[oper] >= 1){
                    operators[oper]--;
                    sequence[k] = oper;
                    solution(k + 1);
                    //연산후 해당 내용을 취소 (완탐을 위해)
                    operators[oper]++;
                    sequence[k] = 0;
                }
            }
        }
    }

    private static int cal(){
        int result = nums[0];
        for(int i = 0; i < N - 1; i++){
            if(sequence[i] == 0) result = result + nums[i + 1];
            else if (sequence[i] == 1) result = result - nums[i + 1];
            else if (sequence[i] == 2) result = result * nums[i + 1];
            else result = result / nums[i + 1];
        }

        return result;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        nums = new int[N];
        sequence = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(line[i]);
        }

        line = br.readLine().split(" ");

        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(line[i]);
        }
    }
}
