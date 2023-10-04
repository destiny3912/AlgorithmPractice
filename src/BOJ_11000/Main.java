package BOJ_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static int N;
    private static PriorityQueue<Lecture> lectures = new PriorityQueue<>();

    private static PriorityQueue<Integer> classRooms = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        read();
        sol();
        System.out.println(classRooms.size());
    }

    private static void sol() {
        while (!lectures.isEmpty()) {
            Lecture lecture = lectures.poll();

            // 만약 classRooms 큐가 비어있지 않고 큐의 맨 위를 봤을때 숫자가 방금 뽑은 강의의 시작시간 보다 작다면 교체
            // 아니라면 교체하지 않고 그냥 추가
            if(!classRooms.isEmpty() && (lecture.S >= classRooms.peek())) {
                classRooms.poll();
            }

            classRooms.add(lecture.T);
        }
    }

    private static class Lecture implements Comparable<Lecture> {
        int S, T;

        public Lecture(int s, int t) {
            S = s;
            T = t;
        }

        //내가 쟤보다 앞이면 음수
        //내가 쟤보다 뒤이면 양수
        @Override
        public int compareTo(Lecture target) {
            return this.S - target.S;
        }
    }

    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());


            for(int i = 0; i < N; i++) {
                String line = br.readLine();
                lectures.add(new Lecture(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1])));
            }
        }
    }
}
