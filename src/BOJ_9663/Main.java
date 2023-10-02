package BOJ_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int[] map;
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        read();
        sol(1);
        System.out.println(count);
    }

    private static void sol(int k){
        //퀸을 전부 놨을때
        if(k == N + 1){
            count++;
        }
        //퀸을 전부 못놨을때
        else{
            boolean possible = true;

            //각 행마다 모든 열에 놓는 걸 기본으로
            for(int i = 1; i <= N; i++){
                //유효 체크
                for(int temp = 1; temp < k; temp++){
                    if(attackable(k, i, temp, map[temp])){
                        possible = false;
                        break;
                    }
                }

                if (possible){
                    map[k] = i;
                    sol(k + 1);
                    map[k] = 0;
                }

                possible = true;
            }
        }
    }

    //i는 target의 row 위치, target은 공격 받는 대상의 col j는 attacker의 row  attacker은 공격자의 col
    private static boolean attackable(int i, int target, int j, int attacker) {
        //공격을 당한다 -> attacker의 가로세로 양쪽 대각의 연장선 안에 있다
        //가로는 애초에 배제 했음 따라서 세로만 체크
        if(target == attacker) return true;
        //대각에 있다는것은 row가 절댓값 N 만큼 차이가나면 col이 +- N 에 있다면 공격당함
        //우하향 대각 체크
        if(i - target == j - attacker) return true;
        //우상향 대각 체크
        if(i + target == j + attacker) return true;

        return false;
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1];
    }
}
