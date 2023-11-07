package SEA_15612;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    private static int N;
    private static int[][] map;
    private static boolean[] row, col;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception
    {
        N = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= N; test_case++)
        {
            read();
            boolean result = sol();

            if (result) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        br.close();
    }

    public static boolean sol() {
        int count = 0;
        // 돌다가 가지치기를 해보자
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                //있니 없니
                if(map[i][j] == 1) {
                    //있다
                    //충돌하니
                    if(row[i] || col[j]) return false;
                    //일단 유효
                    count++;
                    row[i] = true;
                    col[j] = true;
                    // 갯수가 8개보다 많니?
                    if(count > 8) return false;
                }
            }
        }

        return count == 8;
    }

    public static void read() throws IOException {
        map = new int[8][8];
        row = new boolean[8];
        col = new boolean[8];

        for(int i = 0; i < 8; i++) {
            String[] tokens = br.readLine().split("");

            for(int j = 0; j < 8; j++) {
                if(tokens[j].equals("O")) {
                    map[i][j] = 1;
                }
                else {
                    map[i][j] = 0;
                }
            }
        }
    }
}
