package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver3_15649_20250925 {
    static ArrayList<Integer> arr = new ArrayList<>();
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            recur(0);
            //recur2(0, 1);
            System.out.print(sb.toString());
        }
    }

    public static void recur(int number){
        if(number == M){
            for(int n : arr){
                //System.out.print(n+" ");
                sb.append(n+ " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<N+1; i++){
//            if(arr.contains(i)) continue;
            //if(arr.contains(i) || !arr.isEmpty()&&arr.get(arr.size()-1) >= i) continue;
            arr.add(i);
            recur(number+1);
            arr.remove(arr.size()-1);
        }
    }

    public static void recur2(int depth, int start){
        if(depth==M){
            for(int n : arr){
                System.out.print(n+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<N+1; i++){
            if(arr.contains(i)) continue;
            arr.add(i);
            recur2(depth+1, i+1);
            arr.remove(arr.size()-1);
        }
    }
}
