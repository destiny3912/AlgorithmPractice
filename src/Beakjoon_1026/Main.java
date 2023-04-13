package Beakjoon_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Link: https://www.acmicpc.net/problem/1026
public class Main {
    private static int S = 0;
    static List<Integer> A = new ArrayList<>();
    static List<Integer> B = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //Reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Read Test Case
        int T = Integer.parseInt(br.readLine());

        String[] lineA = br.readLine().split(" ");
        for(String number : lineA ){
            A.add(Integer.parseInt(number));
        }

        String[] lineB = br.readLine().split(" ");
        for(String number : lineB){
            B.add(Integer.parseInt(number));
        }

        //sort A
        Collections.sort(A);

        //Compute min S
        for(int index = 0; index < T; index++){
            int bIndex = 0;
            int maxB = 0;

            //Find max element of List B
            for(int innerIndex = 0; innerIndex < B.size(); innerIndex++){
                if(B.get(innerIndex) > maxB){
                    maxB = B.get(innerIndex);
                    bIndex = innerIndex;
                }
            }

            S += maxB * A.get(index);
            B.remove(bIndex);
        }

        //Print
        System.out.println(S);
    }
}
