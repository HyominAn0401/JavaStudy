package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Failed
public class Silver2_15998_Failed {
    static int [] dp;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            //long [] nCount = new long[testCase];
            int [] nCount = new int[testCase];

            for(int i=0; i<testCase; i++){
                nCount[i] = Integer.parseInt(br.readLine());
            }

//            Arrays.sort(nCount);
//            int maxN = nCount[testCase-1];
            //int maxN = Integer.MIN_VALUE;
            long maxN = Long.MIN_VALUE;
            for(int i=0; i<testCase;i++){
                if(nCount[i] > maxN){
                    maxN = nCount[i];
                }
            }

            dp = new int[(int)maxN+1];

            dp[1] = 1;
            if(maxN >= 2)
                dp[2] = 2;
            if(maxN >= 3)
                dp[3] = 4;
            for(int i=4; i<=maxN; i++){
                dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1000000009;
            }

            for(int i=0; i<testCase; i++){
                sb.append(dp[nCount[i]]+"\n");
            }

            System.out.print(sb);

        }
    }
}
