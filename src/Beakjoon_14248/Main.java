package Beakjoon_14248;

import java.io.*;
import java.util.*;

public class Main {

    private static int visitNumber = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> stoneBridge = new ArrayList<>();
        stoneBridge.add(-1);

        for(String element : br.readLine().split(" ")){
            stoneBridge.add(Integer.parseInt(element));
        }

        int start = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N + 1];

        jump(stoneBridge, start, visited);

        System.out.println(visitNumber);
    }

    private static void jump(List<Integer> bridge, int currentPos, boolean[] visited){
        visitNumber++;
        visited[currentPos] = true;

        int rightTarget = currentPos + bridge.get(currentPos);
        int leftTarget = currentPos - bridge.get(currentPos);

        boolean jumpRight = rightTarget < bridge.size();
        if(jumpRight) jumpRight = !visited[rightTarget];

        boolean jumpLeft = leftTarget > 0;
        if(jumpLeft) jumpLeft = !visited[leftTarget];

        if(!jumpLeft && !jumpRight) return;

        if(jumpLeft) {
            jump(bridge, leftTarget, visited);
        }

        if(jumpRight) {
            jump(bridge, rightTarget, visited);
        }
    }
}
