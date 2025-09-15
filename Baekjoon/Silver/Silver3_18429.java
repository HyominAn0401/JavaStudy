package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver3_18429 {
    static int [] weights;
    static int N, K;
    static int cnt = 0;
    static boolean [] visited;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int weight = 500;
            weights = new int[N+1];
            visited = new boolean[N+1];
            List<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                weights[i] = Integer.parseInt(st.nextToken());
            }

            permute(list, 0);
            System.out.println(cnt);

        }
    }

    public static void permute(List<Integer> list, int length){
        if(length == N){
            int weight = 500;
            for(int i=0; i<N; i++){
                int idx = list.get(i);
                weight = weight + weights[idx] - K;
                if(weight<500)  return;
            }
            cnt++;
            return;
        }
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(i);
                permute(list, length+1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
