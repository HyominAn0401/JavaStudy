package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_16395 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int [][] dp = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    dp[i][0] = 1;
                    dp[i][i] = 1;
                }
            }

            for(int i=1; i<n; i++){
                for(int j=1; j<i; j++){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }

            System.out.println(dp[n-1][k-1]);
        }
    }
}
