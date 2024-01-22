//https://www.acmicpc.net/problem/2257
package BOJ_2257;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int H = 1;
    private static final int C = 12;
    private static final int O = 16;

    private static Queue<Character> chemQueue;

    public static void main(String[] args) throws IOException {
        read();
        sol();
    }

    private static void sol() {
        int sum = 0;
        int part = 0;
        boolean isLock = false;

        while (!chemQueue.isEmpty()) {
            char token = chemQueue.poll();

            // 파트 값이 0 이상이고 락이 풀려있니? (한 파트 연산이 끝남)
            if(part > 0 && !isLock) {
                // 만약 현 토큰이 숫자니?
                if(isNumber(token)) {
                    int mul = numToInt(token);
                    sum += (part * mul);
                }
                // 현 토큰이 숫자가 아닐때
                else {
                    sum += part;
                }

                part = 0;
            }

            // 현제 토큰이 괄호니?
            if(token == '(') {
                isLock = true;
                continue;
            }
            else if (token == ')') {
                isLock = false;
                continue;
            }

            // 괄호로 묶이지 않은 원소기호
            if(isChem(token) && !isLock) {
                sum += getWeight(token);
                continue;
            }
            // 괄호로 묶인 원소기호
            if(isLock) {
                part += getWeight(token);
            }
        }

        if(part > 0) sum += part;

        System.out.println(sum);
    }

    private static boolean isChem(char token) {
        return token == 'H' || token == 'C' || token == 'O';
    }

    private static boolean isNumber(char token) {
        return token >= 50 && token <= 57;
    }

    private static int numToInt(char token) {
        return token - 48;
    }
    private static int getWeight(char token) {
        if(token == 'H') {
            return 1;
        }
        else if(token == 'C') {
            return 12;
        }
        else {
            return 16;
        }
    }
    private static void read() throws IOException {
       try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
           String line = br.readLine();
           chemQueue = new LinkedList<>();

           for(Character token : line.toCharArray()){
               chemQueue.add(token);
           }
       }
    }
}
