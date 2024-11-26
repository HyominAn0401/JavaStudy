package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver3_1788 {
    static int [] dp;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            dp = new int[Math.abs(N)+1];

            if(Math.abs(N)>0){
                if(Math.abs(N)==1){
                    dp[Math.abs(N)]=1;
                }
                else{
                    dp[1] = 1;
                    for(int i=2; i<=Math.abs(N); i++){
                        dp[i] = (dp[i-1]+dp[i-2])%1000000000;
                    }
                }

                if(N<0){
                    if(Math.abs(N)%2==0){
                        sb.append(-1+"\n").append(dp[Math.abs(N)]);
                    }
                    else{
                        sb.append(1+"\n").append(dp[Math.abs(N)]);
                    }
                }
                else{
                    sb.append(1+"\n"+dp[N]);
                }

            }
            else{ //0
                sb.append(0+"\n").append(Math.abs(dp[N]));
            }

            System.out.println(sb);
        }
    }
}
