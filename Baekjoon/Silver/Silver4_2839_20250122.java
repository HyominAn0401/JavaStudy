package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver4_2839_20250122 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int [] dp = new int[5001];

            for(int i=0; i<=5000; i++){
                dp[i] = Integer.MAX_VALUE;
            }
            dp[0] = 0;

            for(int i=3; i<=5000; i++){
                if(i>=3 && dp[i-3]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-3]+1);
                }
                if(i>=5 && dp[i-5]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-5]+1);
                }
            }

            System.out.println(dp[N]==Integer.MAX_VALUE ? -1 : dp[N]);
        }
    }
}
