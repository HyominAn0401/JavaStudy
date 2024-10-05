package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_11052 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int [] prices = new int[N+1];
            int [] dp = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                prices[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++){
                for(int j=1; j<=i; j++){
                    dp[i] = Math.max((prices[j] + dp[i-j]), dp[i]);
                }
            }

            System.out.println(dp[N]);
        }
    }
}
