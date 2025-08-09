package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver3_2606_20250809 {
    static ArrayList<Integer> [] computers;
    static boolean [] visited;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int com = Integer.parseInt(br.readLine());
            int network = Integer.parseInt(br.readLine());

            computers = new ArrayList[com+1];
            visited = new boolean[com+1];

            for(int i=1; i<=com; i++){
                computers[i] = new ArrayList<>();
            }

            for(int i=0; i<network; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                computers[s].add(e);
                computers[e].add(s);
            }

            dfs(1);

            System.out.println(count);
        }
    }

    public static void dfs(int num){
        visited[num] = true;
        for(int n : computers[num]){
            if(!visited[n]){
                count++;
                dfs(n);
            }
        }
    }
}
