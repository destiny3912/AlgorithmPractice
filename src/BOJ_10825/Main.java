package BOJ_10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static Score[] arr;
    private static int N;

    public static void main(String[] args) throws IOException {
        read();
        Arrays.sort(arr);
        for (Score score : arr) {
            System.out.println(score.name);
        }
    }

    private static class Score implements Comparable<Score>{
        public String name;
        public int korean, english, math;

        public Score(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        //내가 target 보다 앞인 경우 음수
        //내가 target 보다 뒤인 경우 양수
        //(정렬 후를 기준으로) 나를 기준으로 해서 내 인덱스에서 저놈의 인덱스를 뺀 값이다
        //그래도 생각하기 어렵다면 내 위치가 저놈보다 앞이면 음수 뒤면 양수로 외워라
        @Override
        public int compareTo(Score target) {
            // 국어 점수 내림차순 (크면 앞이다)
            // 내 국어 점수가 target의 국어 점수보다 낮은 경우 (내가 뒤에 온다)
            if(this.korean < target.korean){
                return 1;
            }
            // 내 국어 점수가 target의 국어 점수보다 큰 경우 (내가 앞에 온다)
            else if (this.korean > target.korean) {
                return -1;
            }

            // 영어 점수 오름차순 (작으면 앞이다)
            // 내 영어 점수가 target의 영어 점수보다 낮은경우 (내가 앞에 온다)
            if(this.english < target.english){
                return -1;
            }
            // 내 영어 점수가 target의 영어 점수보다 큰 경우 (내가 뒤에 온다)
            else if (this.english > target.english) {
                return 1;
            }

            // 수학 점수 내림차순 (크면 앞이다)
            // 내 수학 점수가 target의 수학 점수보다 작은 경우 (내가 뒤에 온다)
            if(this.math < target.math){
                return 1;
            }
            //내 수학 점수가 target의 수학 점수보다 큰 경우 (내가 앞에 온다)
            else if (this.math > target.math) {
                return -1;
            }

            // 이름 사전순 오름차순
            // 내 이름이 사전순으로 target의 이름보다 작을 경우 (내가 앞에 온다)
            if(this.name.compareTo(target.name) < 0) {
                return -1;
            }
            // 내 이름이 사전순으로 target의 이름보다 클 경우 (내가 뒤에 온다)
            else if (this.name.compareTo(target.name) > 0) {
                return 1;
            }
            //같은 경우
            else return 0;
        }
    }

    private static void read() throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            arr = new Score[N];

            String line;

            for(int i = 0; i < N; i++){
                line = br.readLine();

                String[] token = line.split(" ");

                arr[i] = new Score(token[0], Integer.parseInt(token[1]), Integer.parseInt(token[2]), Integer.parseInt(token[3]));
            }
        }
    }
}
