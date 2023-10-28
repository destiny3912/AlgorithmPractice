package BOJ_1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int N, count = 0;
    private static Stack<Point> skylines = new Stack<>();

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                Point skyline = new Point(st.nextToken(), st.nextToken());

                while(!skylines.isEmpty() && skylines.peek().y > skyline.y) {
                    Point current = skylines.pop();

                    if(!skylines.isEmpty() && skylines.peek().y == current.y) continue;
                    if(current.y == 0) continue;

                    count++;
                }

                skylines.add(skyline);
            }

            while (!skylines.isEmpty()) {
                Point current = skylines.pop();
                if(!skylines.isEmpty() && skylines.peek().y == current.y) continue;
                if(current.y == 0) continue;

                count++;
            }
        }

        System.out.println(count);
    }
    private static class Point {
        int x;
        int y;

        public Point(String x, String y) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }
    }
}
