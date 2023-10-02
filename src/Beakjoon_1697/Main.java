package Beakjoon_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static class Node{
        public int position;
        public int cost;

        public Node(int position, int cost) {
            this.position = position;
            this.cost = cost;
        }
    }

    private static boolean checkPosition(int pos){
        return pos >= 0 && pos <= 100000 && !visited[pos];
    }

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int N = Integer.parseInt(line.split(" ")[0]);

        int K = Integer.parseInt(line.split(" ")[1]);

        visited= new boolean[1000001];

        Queue<Node> graph = new LinkedList<>();

        graph.add(new Node(N, 0));

        while(!graph.isEmpty()){
            Node current = graph.poll();

            int pos = current.position;
            int cost = current.cost;

            if(pos == K){
                System.out.println(cost);
                break;
            }

            if(checkPosition(pos - 1)){
                visited[pos - 1] = true;
                graph.add(new Node(pos - 1, cost + 1));
            }

            if(checkPosition(pos + 1)){
                visited[pos + 1] = true;
                graph.add(new Node(pos + 1, cost + 1));
            }

            if(checkPosition(pos * 2)){
                visited[pos * 2] = true;
                graph.add(new Node(pos * 2, cost + 1));
            }
        }
    }
}
