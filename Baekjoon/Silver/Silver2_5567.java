package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_5567 {
    static ArrayList<Integer> [] friends;
    static int n, m;
    static int [] distance;
    static boolean [] visited;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());

            friends = new ArrayList[n+1];
            distance = new int[n+1];

            for(int i=1; i<=n; i++){
                friends[i] = new ArrayList<>();
            }

            for(int i=0; i<m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                friends[s].add(e);
                friends[e].add(s);
            }

            BFS(1);
            int cnt = 0;
            for(int i=2; i<n+1; i++){
                if(distance[i]==1 || distance[i]==2){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    public static void BFS(int num){
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n+1];

        queue.add(num);

        while(!queue.isEmpty()){
            int number = queue.poll();
            visited[number] = true;

            for(int x : friends[number]){
                if(!visited[x]){
                    visited[x] = true;
                    queue.add(x);
                    distance[x] = distance[number]+1;
                }
            }
        }
    }
}
