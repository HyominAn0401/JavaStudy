package Silver;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver4_9372 {
    static ArrayList<Integer> [] airplane;
    static int N, M;
    static boolean [] visited;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int t=0; t<testCase; t++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());

                airplane = new ArrayList[N+1];

                for(int i=1; i<=N; i++){
                    airplane[i] = new ArrayList<>();
                }

                for(int i=0; i<M; i++){
                    st = new StringTokenizer(br.readLine());
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());
                    airplane[s].add(e);
                    airplane[e].add(s);
                }

                visited = new boolean[N+1];
                sb.append((N-1)+"\n");
            }
            System.out.print(sb);
        }
    }

//    public static int dfs(int n){
//        int count = 1;
//        for(int num : airplane[n]){
//            if(!visited[num]){
//                visited[num] = true;
//                count += dfs(num);
//            }
//        }
//        return count;
//    }
}
