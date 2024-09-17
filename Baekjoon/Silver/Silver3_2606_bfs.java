package Silver;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Silver3_2606_bfs{
    static ArrayList<Integer> [] graph;
    static boolean [] visited;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            // 인접 리스트, 방문배열 초기화
            graph = new ArrayList[N+1];
            visited = new boolean[N+1];

            for(int i=1; i<=N; i++){
                graph[i] = new ArrayList<Integer>();
            }

            for(int i=0; i<M; i++){
                StringTokenizer st  = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }

            System.out.println(bfs(1)-1);
        }
    }

    static int bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        int cnt = 0;
        while(!queue.isEmpty()){
            int n = queue.poll();
            cnt++;
            for(int x : graph[n]){
                if(!visited[x]){
                    queue.add(x);
                    visited[x] = true;
                }
            }
        }
        return cnt;
    }
}