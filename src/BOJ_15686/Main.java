package BOJ_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int min = Integer.MAX_VALUE;
    private static int N, M;
    //인덱스는 1부터 시작
    private static int[][] map;

    private static List<Block> houses = new ArrayList<>(), chickens = new ArrayList<>(), pickChickens = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        read();
        sol(0,-1);
        System.out.println(min);
    }

    private static void sol(int pickNum, int prevIdx) {
        //치킨집을 고르자 M개 만큼
        //다 골랐을때
        if(pickNum == M){
            min = Math.min(min, distanceSum());
        }
        else {
            for(int i = prevIdx + 1; i < chickens.size(); i++){
                Block current = chickens.get(i);
                pickChickens.add(current);
                sol(pickNum + 1, i);
                pickChickens.remove(pickChickens.size() - 1);
            }
        }

    }

    private static int distanceSum() {
        int result = 0;

        for (Block house : houses) {
            int subMin = Integer.MAX_VALUE;
            for (Block pickChicken : pickChickens) {
                subMin = Math.min(subMin, distance(house.posR, house.posC, pickChicken.posR, pickChicken.posC));
            }
            result += subMin;
        }

        return result;
    }

    private static int distance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        N = Integer.parseInt(line.split(" ")[0]);
        M = Integer.parseInt(line.split(" ")[1]);

        map = new int[N + 1][N + 1];

        for(int i = 0; i < N; i++){
            line = br.readLine();
            String[] tokens = line.split(" ");

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                if(map[i][j] == 1){
                    houses.add(new Block(i + 1, j + 1));
                }
                else if (map[i][j] == 2){
                    chickens.add(new Block(i + 1, j + 1));
                }
            }
        }
    }

    private static class Block {
        public int posR;
        public int posC;

        public Block(int posR, int posC) {
            this.posR = posR;
            this.posC = posC;
        }
    }
}
