package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver1_1389_BFS {
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static int N, M;
    static int [][] depth;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];
            visited = new boolean[N+1];
            depth = new int[N+1][N+1];

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

//            for(int i=1; i<=N; i++){
//                Collections.sort(graph[i]);
//            }

            for(int i=1; i<=N; i++){
                BFS(i);

            }
//            BFS(1);
//            int number = Integer.MAX_VALUE;
//            for(int i=N; i>=1; i--){
//                for(int j=N; j>=1; j--){
//                    depth[i][0] += depth[i][j];
//                }
//                //System.out.println(depth[i][0]);
//                number = Math.min(number, depth[i][0]);
//
//            }
            int number = Integer.MAX_VALUE;
            int result = 0;
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    depth[i][0] += depth[i][j];
                }
                if(number > depth[i][0]){
                    number = depth[i][0];
                    result = i;
                }
            }
            System.out.print(result);
        }
    }

    public static void BFS(int v){
        visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int x : graph[num]){
                if(!visited[x]) {
                    queue.add(x);
                    visited[x] = true;
                    depth[v][x] = depth[v][num]+1;
                }
                //System.out.println("x: "+x+", num : "+num+" depth[v][x]: "+depth[v][x]+" depth[v][num]: "+depth[v][num]);
            }
        }
    }
}
