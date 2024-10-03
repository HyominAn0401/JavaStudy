package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver3_2193_new {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            long [] dp = new long[N+1];

            dp[1] = 1;
            dp[2] = 1;

            if(N>=1){
                dp[1]=1;
            }
            if(N>=2){
                dp[2] =1;
            }

            for(int i=3; i<=N; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }

            System.out.println(dp[N]);
        }
    }
}
