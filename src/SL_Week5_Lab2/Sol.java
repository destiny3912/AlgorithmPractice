package SL_Week5_Lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int change = Integer.parseInt(br.readLine());

        //5달러 먼저 계산 -> 큰걸 많이줘야 최소이기 때문
        int five = change / 5;

        change -= five * 5;

        //2달러로 거슬러주지 못할때
        if(change % 2 != 0) System.out.println(-1);
        else{
            //갯수 출력
            System.out.println(five + change/2);
        }

    }
}
