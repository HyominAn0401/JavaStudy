package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_1010 {
    public static void main(String[] args) throws Exception{
        // Used Combination
        // Failed
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int t=0; t<testCase; t++){
                StringTokenizer st = new StringTokenizer(br.readLine());
//                long N = Long.parseLong(st.nextToken());
//                long M = Long.parseLong(st.nextToken());

                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                long upper = 1;
                long lower = 1;

                for(int i=M; i>=M-N+1; i--){
                    upper *= i;
                }
                for(int i=1; i<=N; i++){
                    lower *= i;
                }
                sb.append((upper/lower)+"\n");
            }
            System.out.print(sb);
        }
    }
}
