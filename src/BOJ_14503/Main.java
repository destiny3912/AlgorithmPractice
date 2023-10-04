package BOJ_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N, M, count = 0;
    private static int[][] map;
    private static Robot robot;

    public static void main(String[] args) throws IOException{
        read();
        sol();
        System.out.println(count);
    }

    private static void sol() {
        while (robot.isWork) {
//            System.out.println(robot.toString());
            // 현제 칸 청소 가능하면 청소 (1번)
            if(robot.cleanable()) {
                robot.clean();
            }
            //청소되지 않은 빈칸이 없는 경우 (2번)
            if(!robot.lookAround()) {
                //뒤에가 벽인지 확인
                if(robot.backIsWall()) {
                    //벽이다
                    //일을 멈추어라
                    robot.stopWork();
                    return;
                }
                else {
                    //벽이 아니다
                    robot.backward();
                }
            }
            //빈칸이 있는 경우 (3번)
            else {
                //회전한다
                robot.rotate();
                // 앞쪽 칸이 청소 가능하니?
                if(robot.forwardCleanable()) {
                    //전진 하라
                    robot.forward();
                }
                //아니라면 가만히
            }
        }
    }

    private static class Robot {
        int curX;
        int curY;
        int direction;
        boolean isWork = true;

        public Robot(int curX, int curY, int direction) {
            this.curX = curX;
            this.curY = curY;
            this.direction = direction;
        }

        public boolean lookAround() {
            //동서남북을 봐라
            boolean isExist = false;
            //0인 칸이 있니?
            //북
            if(map[curX - 1][curY] == 0) {
                isExist = true;
            }
            //동
            if(map[curX][curY + 1] == 0) {
                isExist = true;
            }
            //남
            if(map[curX + 1][curY] == 0) {
                isExist = true;
            }
            //서
            if(map[curX][curY - 1] == 0) {
                isExist = true;
            }
            return isExist;

        }
        public void forward () {
            if(direction == 0) curX--;
            else if (direction == 1) curY++;
            else if (direction == 2) curX++;
            else curY--;
        }

        public boolean backIsWall(){
            //북
            if(direction == 0) {
               //남쪽 방향이 1이니?
                return map[curX + 1][curY] == 1;
            }
            //동
            else if(direction == 1) {
                //서쪽 방향이 1이니?
                return map[curX][curY - 1] == 1;
            }
            //남
            else if(direction == 2) {
                //북쪽 방향이 1이니?
                return map[curX - 1][curY] == 1;
            }
            //서
            else {
                //동쪽 방향이 1이니?
                return map[curX][curY + 1] == 1;
            }
        }
        public void backward() {
            if(direction == 0) curX++;
            else if (direction == 1) curY--;
            else if (direction == 2) curX--;
            else curY++;
        }

        public void rotate() {
            direction--;
            if(direction == -1) direction = 3;
        }

        public void clean() {
            map[curX][curY] = -1;
            count++;
        }

        public boolean cleanable() {
            return map[curX][curY] == 0;
        }

        public boolean forwardCleanable() {
            //북
            if(direction == 0) {
                if(map[curX - 1][curY] == 0) return true;
            }
            //동
            else if(direction == 1) {
                if(map[curX][curY + 1] == 0) return true;
            }
            //남
            else if(direction == 2) {
                if(map[curX + 1][curY] == 0) return true;
            }
            //서
            else {
                if(map[curX][curY - 1] == 0) return true;
            }
            return false;
        }

        public void stopWork() {
            isWork = false;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "curX=" + curX +
                    ", curY=" + curY +
                    ", direction=" + direction +
                    ", isWork=" + isWork +
                    '}';
        }
    }

    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] token = br.readLine().split(" ");
            N = Integer.parseInt(token[0]);
            M = Integer.parseInt(token[1]);

            map = new int[N][M];

            token = br.readLine().split(" ");

            robot = new Robot(Integer.parseInt(token[0]), Integer.parseInt(token[1]), Integer.parseInt(token[2]));

            for(int i = 0; i < N; i++) {
                token = br.readLine().split(" ");
                for(int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(token[j]);
                }
            }
        }
    }
}
