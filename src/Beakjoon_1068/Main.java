package Beakjoon_1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //트리 만들기 - 사작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        String[] token = line.split(" ");

        int target = Integer.parseInt(br.readLine());
        int targetRoot = Integer.parseInt(token[target]);

        List<List<Integer>> tree = new ArrayList<>();

        int root = 0;

        for(int i = 0; i < N; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++){

            int number = Integer.parseInt(token[i]);

            if(number != -1) {
                tree.get(number).add(i);
            }
            else
                root = i;
        }
        //트리 만들기 - 끝

        //트리에서 지정된 노드 제거하기 - 시작

        //만약 제거 대상의 부모가 없다면 부모를 자기 자신으로 초기화 (루트를 의미)
        if(targetRoot == -1) targetRoot = target;

        //지울 노드의 부모의 인접 리스트를 가져옴
        List<Integer> deleteTargetRoot = tree.get(targetRoot);

        //만약 인접 리스트에 하나밖에 없다면(지울 노드밖에 없다면)
        if(deleteTargetRoot.size() == 1) {
            //클리어
            deleteTargetRoot.clear();
        }
        //만약 루트를 지운다면
        else if (target == root) {
            //트리를 클리어
            tree.clear();
        }
        //그 이외에
        else{
            //임시 리스트 (지우지 않을 애들 저장)
            List<Integer> temp = new ArrayList<>();

            //루트를 돌면서 지우지 않을 애들만 저장
            for(int number : deleteTargetRoot){
                if(number != target) temp.add(number);
            }

            //지우고
            deleteTargetRoot.clear();

            //다시 초기화
            deleteTargetRoot.addAll(temp);
        }
        //트리에서 지정된 노드 제거하기 - 끝

        int leafCount = 0;
        //트리 탐색해서 리프노드 갯수 새기 - 시작 (DFS)
        if(!tree.isEmpty()) {
            Stack<Integer> stack = new Stack<>();

            boolean[] visited = new boolean[N];

            stack.push(root);
            visited[root] = true;

            while (!stack.isEmpty()) {
                int currentNode = stack.pop();

                List<Integer> childList = tree.get(currentNode);

                if (childList.isEmpty()) {
                    leafCount++;
                } else {
                    for (int child : childList) {
                        if (!visited[child]) {
                            stack.push(child);
                            visited[child] = true;
                        }
                    }
                }
            }
            //트리 탐색해서 리프노드 갯수 새기 - 끝
        }

        System.out.println(leafCount);
    }
}
