package Beakjoon_15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/15900
 * 결국은 리프 노드의 레벨의 합을 구하면 되는 문제
 * 해당 합이 홀수면 승리 짝수면 패배
 * */
public class Main {

    private static final List<List<Integer>> tree = new ArrayList<>();

    private static boolean[] visited;

    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //그냥 정점 번호를 그대로 쓰고 싶어
        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i++){
            String line = br.readLine();

            int left = Integer.parseInt(line.split(" ")[0]);
            int right = Integer.parseInt(line.split(" ")[1]);

            tree.get(left).add(right);
            tree.get(right).add(left);
        }

        visited = new boolean[N+1];

        visited[1] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        int[] level = new int[N+1];

        while (!stack.isEmpty()){
            int current = stack.pop();
            boolean isLeaf = true;

            for(int child : tree.get(current)){
                if(!visited[child]) {
                    isLeaf = false;
                    level[child] = level[current] + 1;
                    visited[child] = true;
                    stack.push(child);
                }
            }

            if(isLeaf)
                count += level[current];
        }

        if(count % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
    }
}
