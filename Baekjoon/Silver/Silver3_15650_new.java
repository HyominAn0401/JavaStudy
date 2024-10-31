package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_15650_new {
    static int N, M;
    static int [] selected;
    static boolean [] used;
    static StringBuilder sb = new StringBuilder();
    static int start = 1;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            selected = new int[M];
            used = new boolean[N+1];

            generateSeq(start, 0);
            System.out.print(sb);
        }
    }

    public static void generateSeq(int start, int depth){
        if(depth==M){
            for(int num : selected){
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++){
            selected[depth] = i;
            generateSeq(start+1, depth+1);
            start = i+1;
        }

//        for(int i=1; i<=N; i++){
//            if(!used[i]){
//                used[i] = true;
//                selected[depth] = i;
//                generateSeq(depth+1);
//                used[i] = false;
//            }
//        }
    }
}
