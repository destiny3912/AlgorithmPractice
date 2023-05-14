package SL_Week5_Lab1;

/**
 * 1. 우선 입력을 받고
 * 2. 최소값을 구하기 위해 오름차순으로 정렬
 * 3. 2중 for loop을 돌면서 시간의 합을 구한다.
 * */
import java.io.*;
import java.util.*;

public class Sol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();

        List<Integer> numberArr = new ArrayList<>();

        for(String number : numbers.split(" ")){
            numberArr.add(Integer.parseInt(number));
        }

        Collections.sort(numberArr);

        int accSum = 0;

        for(int outerIdx = 0; outerIdx < numberArr.size(); outerIdx++){
            int tempSum = 0;
            for(int innerIdx = 0; innerIdx < outerIdx + 1; innerIdx++){
                tempSum += numberArr.get(innerIdx);
            }

            accSum += tempSum;
        }

        System.out.println(accSum);
    }
}
