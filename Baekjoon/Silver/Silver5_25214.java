package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_25214 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            long [] A = new long[N];
            StringBuilder sb = new StringBuilder();

            long min = Long.MAX_VALUE;
            long maxDiff = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                long num = Long.parseLong(st.nextToken());

                if(i==0)    min = num;
                else{
                    maxDiff = Math.max(maxDiff, num-min);
                    min = Math.min(min, num);
                }
                sb.append(maxDiff+" ");
            }

            System.out.println(sb.toString());
        }
    }
}
