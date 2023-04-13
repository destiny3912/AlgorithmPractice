package SL_Week4_Lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sol {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int allDay = Integer.parseInt(st.nextToken());
        int partDay = Integer.parseInt(st.nextToken());

        List<Integer> visitorList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int index = 0; index < allDay; index++){
            visitorList.add(Integer.parseInt(st.nextToken()));
        }

        int left = 0;
        int right = partDay - 1;

        int maxDayCount = 0;
        int max = 0;

        while(right < visitorList.size()){
            int tempSum = 0;
            for(int index = left; index <= right; index++){
                tempSum = tempSum + visitorList.get(index);
            }

            if(tempSum > max){
                maxDayCount = 1;
                max = tempSum;
            }
            else if(tempSum == max){
                maxDayCount++;
            }

            left++;
            right++;
        }

        System.out.println(max);
        System.out.println(maxDayCount);
    }
}
