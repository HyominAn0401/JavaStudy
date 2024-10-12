package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver3_1904 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : dp로 N자리수 2진수열의 개수를 15746으로 나눈 나머지 출력
        // 로직 설계
        // 1. N+1 크기의 DP 배열 생성
        // 2. N이 3이상일 때 15746으로 나눈 나머지 계산 후 저장

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            //int N = Integer.parseInt(br.readLine());
            // N값 입력받기
            long N = Long.parseLong(br.readLine());

            // dp 배열 생성
            long [] dp = new long[(int)(N+1)];
            //int [] remainder = new int[(int)(N+1)];
            //long [] remainder = new long[(int)(N+1)];

            // N이 1일때
            if(N==1){
                System.out.println(1);
            }
            // N이 2일때
            else if(N==2){
                System.out.println(2);
            }
            // N이 3 이상일 때
            else{
                dp[1] = 1;
                dp[2] = 2;

                // 3부터 N까지 반복
                for(int i=3; i<=N; i++){
                    //dp[i] = dp[i-1]+dp[i-2];
                    // i번째 값을 15746으로 나눈 나머지 저장
                    dp[i] = (dp[i-1]+dp[i-2])%15746;
                    //remainder[i] = dp[i]%15746;
                    //System.out.println("dp["+i+"] = "+dp[i]+", remainder["+i+"] = "+remainder[i]);
                }

                // 결과값 출력
                System.out.println(dp[(int)N]);
            }
        }
    }
}
