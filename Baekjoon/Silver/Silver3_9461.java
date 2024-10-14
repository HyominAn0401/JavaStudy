package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver3_9461 {
    static long [] dp = new long[101];
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            for(int i=4; i<=100; i++){
                dp[i] = dp[i-2] + dp[i-3];
            }

            for(int i=0; i<testCase; i++){
                int n = Integer.parseInt(br.readLine());
                sb.append(dp[n]+"\n");
            }
            System.out.print(sb);
        }
    }
}
