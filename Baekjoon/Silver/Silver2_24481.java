package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver2_24481 {
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    static int [] dep;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];
            visited = new boolean[N+1];
            dep = new int[N+1];

            for(int i=1; i<=N; i++){
                dep[i] = -1;
            }

            dep[R] = 0;

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

            for(int i=1; i<=N; i++){
                Collections.sort(graph[i]);
            }

            dfs(R, 0);
            for(int i=1; i<=N; i++){
                sb.append(dep[i]+"\n");
            }
            System.out.print(sb);

        }
    }
    static void dfs(int start, int depth){
        visited[start] = true;
        dep[start] = depth;
        for(int x : graph[start]){
            if(!visited[x])
                dfs(x, depth+1);
        }
    }
}
