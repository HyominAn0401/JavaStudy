package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_1325 {
    static int N, M;
    static boolean [] visited;
    static ArrayList<Integer>[] computers;
    static int [] hackingCount;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            computers = new ArrayList[N+1];
            hackingCount = new int[N+1];

            for(int i=1; i<=N; i++){
                computers[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                computers[e].add(s);
            }

//            for(int i=1; i<=N; i++){
//                visited = new boolean[N+1];
//                hackingCount[i] = dfs(i);
//            }

//            for(int i=1; i<=N; i++){
//                bfs(i);
//            }

            int maxCount = 0;
            for(int i=1; i<=N; i++) {
                visited = new boolean[N + 1];
                hackingCount[i] = dfs(i);
                maxCount = Math.max(maxCount, hackingCount[i]);
            }

//            int maxValue = Integer.MIN_VALUE;
//
//            for(int i=1; i<=N; i++){
//                maxValue = Math.max(maxValue, hackingCount[i]);
//            }
//
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<=N; i++) {
                if (hackingCount[i] == maxCount) {
                    sb.append(i + " ");
                }
            }


            System.out.println(sb);
        }
    }

    public static int dfs(int current){
        visited[current] = true;
        int count = 1;

        for(int num : computers[current]){
            if(!visited[num]){
                count += dfs(num);
            }
        }

        return count;
    }

//    public static void bfs(int n){
//        Queue<Integer> queue = new LinkedList<>();
//        visited = new boolean[N+1];
//        queue.add(n);
//        visited[n] = true;
//        int count = 0;
//
//        while(!queue.isEmpty()){
//            int current = queue.poll();
//            count++;
//            for(int num : computers[current]){
//                if(!visited[num]){
//                    visited[num] = true;
//                    queue.add(num);
//                }
//            }
//        }
//
//        hackingCount[n] = count;
//    }
}
