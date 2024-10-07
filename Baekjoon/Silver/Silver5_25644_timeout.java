package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_25644_timeout {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            long [] dp = new long[N+1];
            long [] a = new long[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                a[i] = Long.parseLong(st.nextToken());
            }

            long maxValue = Integer.MIN_VALUE;

            for(int i=1; i<=N; i++){
                for(int j=i; j<=N; j++){
                    dp[i] = Math.max(dp[i], a[j]-a[i]);
                }
                maxValue = Math.max(dp[i], maxValue);
            }

            System.out.println(maxValue);
        }
    }
}
