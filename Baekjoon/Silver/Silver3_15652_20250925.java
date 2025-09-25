package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver3_15652_20250925 {
    static int N, M;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            recur(0, 1);
            System.out.print(sb);
        }
    }

    public static void recur(int depth, int start){
        if(depth == M){
            for(int n : list){
                sb.append(n+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<N+1; i++){
            list.add(i);
            recur(depth+1, i);
            list.remove(list.size()-1);
        }
    }
}
