package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver2_11724 {

    static ArrayList<Integer>[] arrayList;
    static boolean[] visited;

    static void DFS(int k){
        Stack<Integer> stack = new Stack<Integer>();
        visited[k] = true;
        stack.push(k);



//        if(arrayList[k].size()>0) {
//            for (int j = 0; j < arrayList[k].size(); j++) {
//                stack.push(arrayList[k].get(j));
//                visited[arrayList[k].get(j)] = true;
//            }
//        }
//        else{
//            return;
//        }

        // 방문하지 않았을 때를 전제로
        while(!stack.isEmpty()){

//            if(!visited[k]){
//                visited[k] = true;
//                stack.push(k);
//            }
//            else{
//                stack.pop();
//                continue;
//            }

            int x = stack.pop();
            for(int list : arrayList[x]){
                if(!visited[list]){
                    visited[list] = true;
                    stack.push(list);
                }
            }
        }

    }

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 인접 리스트
            arrayList = new ArrayList[N+1];
            // 방문 배열
            visited = new boolean[N+1];

            // 방문 배열 초기화 -> false로 초기화됨

            // 인접 리스트 초기화
            for(int i=1; i<=N; i++){
                arrayList[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                // 양방향
                arrayList[c].add(d);
                arrayList[d].add(c);
            }

            int cnt = 0;

            for(int i=1; i<N+1; i++){
                if(!visited[i]){//false인 경우

                    DFS(i);
                    cnt++;
                }
            }

            System.out.println(cnt);

//            for(int i=1; i<N+1; i++){
//                System.out.println(arrayList[i]);
//            }


        } catch (IOException e){
            e.printStackTrace();
        }


    }

}
