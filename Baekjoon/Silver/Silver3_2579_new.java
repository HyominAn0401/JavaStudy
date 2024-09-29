package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_2579_new {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : dp로 정수 삼각형에서 위층부터 최대합이 되는 숫자 출력하기
        // 로직 설계
        // 1. N값을 입력받아 dp 배열과 삼각형 배열 생성
        // 2. 삼각형 배열에 숫자 입력받기
        // 3. dp로 삼각형 배열을 윗층부터 내려가며 최대합이 되는 값 dp 배열에 저장하기
        // 4. dp 배열 마지막 행에서 가장 큰 값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값 입력받고 삼각형 배열, dp 배열 초기화
            int N = Integer.parseInt(br.readLine());
            int [][] triangle = new int[N][N];
            int [][] dp = new int[N][N];

            // 삼각형 배열에 숫자값 저장
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<=i; j++){
                    triangle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dp 배열 [0][0]에 첫 숫자 저장
            dp[0][0] = triangle[0][0];

            // dp로 최대값 저장해나가기
            for(int i=1; i<N; i++){
                for(int j=0; j<=i; j++){
                    // 왼쪽 맨 끝인 경우
                    if(j==0)
                        dp[i][j] = dp[i-1][j] + triangle[i][j];
                    // 맨 오른쪽인 경우
                    else if(j==i)
                        dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                    // 그 외
                    // 값이 겹쳐 더 큰값을 저장하는 비교 필요
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }

            // 최대값을 저장할 변수
            int maxValue = Integer.MIN_VALUE;
            // dp 배열 마지막 행에서 가장 큰 값 저장
            for(int i=0; i<N; i++){
                maxValue = Math.max(maxValue, dp[N-1][i]);
            }
            // 결과값 출력
            System.out.println(maxValue);
        }
    }
}
