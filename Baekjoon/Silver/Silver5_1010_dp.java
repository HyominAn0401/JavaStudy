package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_1010_dp {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : DP로 파스칼의 삼각형을 이용해 만들 수 있는 다리의 모든 경우의 수 구하기
        // 로직 설계
        // 1. 30 크기의 2차원 배열 생성
        // 2. 테스트 케이스를 입력받고 결과를 저장할 StringBuilder 객체 생성
        // 3. nC0, nCn을 초기화하고 dp 배열에 파스칼의 삼각형 이용해 값 저장
        // 4. 각 테스트 케이스 별 결과 저장 및 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스크 케이스 수 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과를 저장할 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // dp 2차원 배열 생성
            int [][] dp = new int[30][30];

            // nC0, nCn 초기화
            for(int i=0; i<30; i++){
                for(int j=0; j<30; j++){
                    dp[i][0] = 1; // nC0 = 1
                    dp[i][i] = 1; // nCn = 1
                }
            }

            // DP로 파스칼의 삼각형으로 구한 값 저장
            for(int i=1; i<30; i++){
                for(int j=1; j<i; j++){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }

            // 테스크 케이스 별 값 저장 및 출력
            for(int t=0; t<testCase; t++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                sb.append(dp[M][N]+"\n");
            }
            System.out.print(sb);

        }
    }
}
