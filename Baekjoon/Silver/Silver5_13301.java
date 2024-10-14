package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver5_13301 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : dp로 타일 둘레 구하기
        // 로직 설계
        // 1. N값 입력받아 dp 배열 초기화
        // 2. dp 배열에 값 저장
        // 3. N번째 직사각형 둘레 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값 입력받기
            int N = Integer.parseInt(br.readLine());
            // dp 배열 초기화
            long [] dp = new long[N+1];
            // 1일때 초기화
            dp[1] = 4;
            // N이 2보다 클 때
            if(N>=2)
                dp[2] = 6;
            // N이 3 이상인 경우 배열에 저장
            for(int i=3; i<=N; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            // 결과값 출력
            System.out.println(dp[N]);
        }
    }
}
