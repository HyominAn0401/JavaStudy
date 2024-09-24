package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver4_9372 {
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static int N, M;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];
            visited = new boolean[N+1];

            for(int i=1; i<=N; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }

            int minValue = Integer.MAX_VALUE;
            for(int i=1; i<=N; i++){
                minValue = Math.min(DFS(i), minValue);
            }
            System.out.println(minValue);
        }
    }

    public static int DFS(int v){
        if(visited[v])  return 0;
        visited[v] = true;

        int cnt = 1;
        for(int x : graph[v]){
            if(!visited[x]){
                cnt += DFS(x);
            }
        }
        return cnt;
    }
}
