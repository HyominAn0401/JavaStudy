package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_14494 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : DP로 이차원 배열에서 오른쪽 맨 끝까지 도착하는 경우의 수 구하기
        // 로직 설계
        // 1. n, m 입력받고 해당 크기의 이차원 배열 생성
        // 2. [0][0] 값 1로 초기화
        // 3. [0][j], [i][0] 값들 1로 초기화
        // 4. 오른쪽, 아래, 대각선 아래 방향으로 이동하는 경우의 수를 구해 배열에 저장한다.
        // 5. 마지막 칸의 값을 1000000007으로 나눈 값을 출력한다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // n, m 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // n, m 크기의 배열 생성
            long [][] dp = new long[n][m];
            // 초기값 초기화
            dp[0][0] = 1;
            // 1로 초기화
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    dp[0][j] = 1;
                    dp[i][0] = 1;
                }
            }

            // 각 위치별 경우의 수 구해 저장하기
            for(int i=1; i<n; i++){
                for(int j=1; j<m; j++){
                    //dp[i][j] = (dp[i-1][j-1]%1000000007)+ (dp[i-1][j]%1000000007) + (dp[i][j-1]%1000000007);
                    // 1000000007으로 나눈 값 저장
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j] +dp[i][j-1])%1000000007;
                }
            }
            // 결과값 출력
            System.out.println(dp[n-1][m-1]);
        }
    }
}
