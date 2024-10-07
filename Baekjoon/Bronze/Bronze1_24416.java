package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze1_24416 {
    static int [] dp;
    static long dpCount = 0;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());
            dp = new int[n+1];

            System.out.println(fibo(n)+" "+dpFibo(n));
        }
    }

    public static long fibo(int n){
        if(n==1 || n==2){
            return 1;
        }
        else{
            return fibo(n-1)+fibo(n-2);
        }
    }

    // 비정적 메서드를 정적 메서드에서 호출하려고 해서 문제 발생
    public static long dpFibo(int n){
        if(n==1 || n==2){
            return dpCount = 1;
        }
        else{
            for(int i=3; i<=n; i++){
                dp[i] = dp[i-1]+dp[i-2];
                dpCount += 1;
            }
            return dpCount;
        }
    }
}
