package SL_Week5_Lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String size = br.readLine();

        int i = Integer.parseInt(size.split(" ")[0]);
        int j = Integer.parseInt(size.split(" ")[1]);

        int[][] map = new int[i][j];

        for(int idx = 0; idx < i; idx++){
            String numbers = br.readLine();

            String[] numberArr = numbers.split(" ");

            for(int inner = 0; inner < i; inner++){
                map[idx][inner] = Integer.parseInt(numberArr[inner]);
            }
        }

        int regionCount = 0;
    }
}
