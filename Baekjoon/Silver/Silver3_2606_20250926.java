package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver3_2606_20250926 {
    static ArrayList<Integer>[] computers;
    static boolean [] visited;
    static int count = 0;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            computers = new ArrayList[N+1];
            visited = new boolean[N+1];

            for(int i=1; i<=N; i++){
                computers[i] = new ArrayList<>();
            }
            for(int i=0; i<M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                computers[s].add(e);
                computers[e].add(s);
            }

            //dfs(1);
            //bfs(1);
            System.out.print(bfs(1));
            //System.out.print(count);
        }
    }

    public static void dfs(int n){
        if(visited[n])
            return;

        visited[n] = true;

        for(int node : computers[n]){
            if(!visited[node]){
                //visited[node] = true;
                count++;
                dfs(node);
            }
        }
    }

    public static int dfs2(int n){
        int cnt = 0;
        visited[n] = true;

        for(int node : computers[n]){
            if(visited[node])   continue;
            cnt++;
            cnt += dfs2(node);
        }

        return cnt;
    }

    public static int bfs(int n){
        int cnt=0;
        queue.add(n);
        visited[n] = true;
        while(!queue.isEmpty()){
            int num = queue.poll();
            //visited[num] = true;

            for(int node : computers[num]){
                if(!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    cnt++;
                }
            }
//            Collections.addAll(computers[num]);
        }
        return cnt;
    }
}
