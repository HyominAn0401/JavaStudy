package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_1260_new {
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static StringBuilder dfsSb = new StringBuilder();
    static StringBuilder bfsSb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];


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

            for(int i=1;i<=N; i++){
                Collections.sort(graph[i]);
            }

            visited = new boolean[N+1];
            dfs(V);

            visited = new boolean[N+1];
            bfs(V);

            System.out.println(dfsSb);
            System.out.println(bfsSb);
        }
    }

    public static void dfs(int node){
        visited[node]= true;
        dfsSb.append(node+" ");
        for(int num : graph[node]){
            if(!visited[num]){
                visited[num] = true;
                dfs(num);
            }
        }
    }

    public static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int number = queue.poll();

            bfsSb.append(number+" ");
            for(int num : graph[number]){
                if(!visited[num]){
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }
}
