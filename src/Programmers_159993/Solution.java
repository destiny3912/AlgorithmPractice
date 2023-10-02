package Programmers_159993;

import java.util.*;

class Solution {


    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};

    private static class Cell {
        private int x;
        private int y;

        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(String[] maps) {
        int answer = 0;

        char[][] mapList = new char[maps.length][maps[0].length()];

        Cell start;
        Cell end;

        for(int i = 0; i < mapList.length; i++){
            for(int j = 0; j < mapList[0].length; j++){
                mapList[i][j] = maps[i].charAt(j);

                if(mapList[i][j] == 'S'){
                    start = new Cell(i, j);
                }
                else if(mapList[i][j] == 'E'){
                    end = new Cell(i, j);
                }
            }
        }


        Queue<Cell> queue = new LinkedList<>();

        int[][] visited = new int[mapList.length][mapList[0].length];

        int posX = -1, posY = -1, cost = -1;

        while(!queue.isEmpty()){
            Cell current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y = dy[i];

                //맵 밖이거나 이미 방문했을경우
                if(mapList[nextX][nextY] == 'X' || visited[nextX][nextY] > 0 || nextX < 0 || nextY < 0 || nextX > mapList.length || nextY > mapList[0].length){
                    continue;
                }

                queue.add(new Cell(nextX, nextY));
                visited[nextX][nextY] = visited[current.x][current.y] + 1;

                if(mapList[nextX][nextY] == 'L'){
                    posX = nextX;
                    posY = nextY;
                    cost = visited[nextX][nextY];
                    break;
                }
            }
        }

        if(posX == -1 || posY == -1 || cost == -1){
            return -1;
        }

        queue.clear();

        return answer;
    }
}
