package BOJ_8980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, C, M, currentLoad = 0, count = 0;
    private static List<Request> requests = new ArrayList<>();
    private static int[] loads;
    public static void main(String[] args) throws IOException {
        read();
        sol();
        System.out.println(count);
    }

    private static void sol() {
        // i는 현재 위치한 마을 번호
        for(int i = 1; i <= N; i++) {
            // 배송
            if(i != 1) {
                currentLoad -= loads[i];
                count += loads[i];
                loads[i] = 0;
            }

            //싣기
            for(int j = 0; j < requests.size(); j++) {
                System.out.println(count);
                Request current = requests.get(0);

                if(current.from != i) {
                    
                    break;
                }
                if (currentLoad == C) break;

                // 그냥 다 넣을 수 있을때
                if(currentLoad + current.boxNum <= C) {
                    loads[current.to] += current.boxNum;
                    currentLoad += current.boxNum;
                }
                // 일부만 넣을 때
                else{
                    loads[current.to] += C - currentLoad;
                    currentLoad = C;
                }
                requests.remove(0);
                System.out.println(Arrays.toString(loads));
            }
            System.out.println("================================");
        }
    }

    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(br.readLine());
            loads = new int[N + 1];

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                requests.add(new Request(st.nextToken(), st.nextToken(), st.nextToken()));
            }

            Collections.sort(requests);
        }
    }

    private static class Request implements Comparable<Request> {
        int from;
        int to;
        int boxNum;

        public Request(String from, String to, String boxNum) {
            this.from = Integer.parseInt(from);
            this.to = Integer.parseInt(to);
            this.boxNum = Integer.parseInt(boxNum);
        }

        @Override
        public int compareTo(Request target) {
            return this.to - target.to;
        }

        @Override
        public String toString() {
            return "Request{" +
                    "from=" + from +
                    ", to=" + to +
                    ", boxNum=" + boxNum +
                    '}';
        }
    }
}
