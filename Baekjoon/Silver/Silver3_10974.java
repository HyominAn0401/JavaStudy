package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver3_10974 {
    static int [] selected;
    static boolean [] used;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            N = Integer.parseInt(br.readLine());
            selected = new int[N];
            used = new boolean[N+1];

            generateSeq(0);
            System.out.print(sb);
        }
    }

    public static void generateSeq(int depth){
        if(depth==N){
            for(int num : selected){
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(!used[i]){
                used[i] = true;
                selected[depth] = i;
                generateSeq(depth+1);
                used[i] = false;
            }
        }
    }
}
