package BOJ_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static int L, C;
    private static String[] list;
    private static final String[] vowels = {"a", "e", "i", "o", "u"};
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        read();
        Arrays.sort(list);
        sol(0, new ArrayList<>(), -1);
        System.out.println(sb.toString());
    }

    private static void sol(int selectNum, List<String> selected, int lastIdx) {
        //다 골랐을때
        if(selectNum == L){
            //유효 확인
            if(isValid(selected)) {
                for (String s : selected) {
                    sb.append(s);
                }
                sb.append("\n");
            }
        }
        else {
            for(int i = 1; i < list.length - lastIdx; i++){
                //고른다
                selected.add(list[lastIdx + i]);
                sol(selectNum + 1, new ArrayList<>(selected), lastIdx + i);
                selected.remove(list[lastIdx + i]);
            }
        }
    }

    private static boolean isValid(List<String> target) {
        int vCount = 0;
        List<String> vList = Arrays.asList(vowels);

        for (String s : target) {
            if(vList.contains(s)) vCount++;
        }

        if(vCount > 0 && target.size() - vCount >= 2) return true;
        else return false;
    }

    private static void read() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = br.readLine();

            L = Integer.parseInt(line.split(" ")[0]);
            C = Integer.parseInt(line.split(" ")[1]);

            line = br.readLine();
            list = line.split(" ");
        }
    }
}
