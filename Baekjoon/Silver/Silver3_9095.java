package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver3_9095 {
    static int [] dp;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : dp로 n을 1, 2, 3의 합으로 나타내는 방법의 개수 저장 후 출력
        // 로직 설계
        // 1. 11 크기의 dp 배열 생성 -> i를 1, 2, 3 합으로 나타내는 방법의 수
        // 2. 1부터 10까지 방법의 수 배열에 저장
        // 3. 테스트 케이스 별 방법의 수 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스트 케이스 수 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과를 저장할 StringBuilder
            StringBuilder sb = new StringBuilder();
            // n은 11보다 작음 -> 11로 초기화
            dp = new int[11];

            // 1, 2, 3 초기화
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            // dp 배열에 값 저장
            // n-1을 만드는 방법에 +1
            // n-2를 만드는 방법에 +2
            // n-3을 만드는 방법에 +3
            for(int i=4; i<11; i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

            // 테스트 케이스 별 결과값 저장
            for(int i=0; i<testCase; i++){
                int n = Integer.parseInt(br.readLine());
                sb.append(dp[n]+"\n");
            }

            // 결과 출력
            System.out.print(sb);
        }
    }
}
