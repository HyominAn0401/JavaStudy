package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_15652 {
    static int N, M;
    static int [] selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            selected = new int[M];

            generateSeq(1, 0);
            System.out.print(sb);
        }
    }

    public static void generateSeq(int start, int depth){
        if(depth==M){
            for(int num : selected){
                sb.append(num+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++){
            selected[depth] = i;
            generateSeq(start, depth+1);
            start = i+1;
        }
    }
}
