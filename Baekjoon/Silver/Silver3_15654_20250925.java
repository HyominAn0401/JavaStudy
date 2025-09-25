package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Silver3_15654_20250925 {
    static int N, M;
    static List<Integer> list = new ArrayList<>();
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st=new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            //recur(0);
            //recur2(0, 0);
            recur3(0);
            System.out.print(sb);
        }
    }

    // 15654
    public static void recur(int depth){
        if(depth==M){
            for(int n : list){
                sb.append(n+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(list.contains(arr[i]))   continue;
            list.add(arr[i]);
            recur(depth+1);
            list.remove(list.size()-1);
        }
    }

    // 15655
    public static void recur2(int depth, int start){
        if(depth == M){
            for(int n : list){
                sb.append(n+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<N; i++){
            if(list.contains(arr[i]))   continue;
            list.add(arr[i]);
            recur2(depth+1, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void recur3(int depth){
        if(depth == M){
            for(int n : list){
                sb.append(n+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            list.add(arr[i]);
            recur3(depth+1);
            list.remove(list.size()-1);
        }
    }
}
