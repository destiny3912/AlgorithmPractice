package Beakjoon_2776;

import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer> book1List = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int testIdx = 0; testIdx < T; testIdx++){
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;

            int N1 = Integer.parseInt(br.readLine());

            st = new StringTokenizer((br.readLine()));
            for(int index = 0; index < N1; index++){
                book1List.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(book1List);

            int N2 = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int index = 0; index < N2; index++){
                boolean result = search(Integer.parseInt(st.nextToken()), book1List.size() - 1);

                if(result) {
                    sb.append("1");
                }
                else {
                    sb.append("0");
                }

                sb.append("\n");
            }


            bw.write(sb.toString());
            bw.flush();

            book1List.clear();
        }
    }

    private static boolean search(int target, int endIdx){
        int mid;

        int startIdx = 0;

        while(startIdx <= endIdx){
            mid = (startIdx + endIdx) / 2;

            if(book1List.get(mid) > target){
                endIdx = mid - 1;
            }
            else if(book1List.get(mid) < target){
                startIdx = mid + 1;
            } else{
                return true;
            }
        }

        return false;
    }
}