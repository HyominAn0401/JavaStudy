package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D2_2005 {
    static int [][] dp;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase= Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int t=1; t<=testCase; t++){
                int N = Integer.parseInt(br.readLine());
                dp = new int[N][N];

                for(int i=0; i<N; i++){
                    dp[i][0] = 1;
                    dp[i][i] = 1;
                }

                for(int i=2; i<N; i++){
                    for(int j=1; j<N-1; j++){
                        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    }
                }

                sb.append("#"+t+"\n");

                for(int i=0; i<N; i++){
                    for(int j=0; j<=i; j++){
                        //System.out.print(dp[i][j]+" ");
                        sb.append(dp[i][j]+" ");
                    }
                    //System.out.println();
                    sb.append("\n");
                }

            }

            System.out.print(sb);
        }
    }
}
