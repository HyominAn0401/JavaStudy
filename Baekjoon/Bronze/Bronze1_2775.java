package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1_2775 {
    public static void main(String[] args) throws IOException {
        // 구현 및 해야할 것 : 층수와 호수를 입력받아 아래층 1-b호까지 사람들의 수의 합을 출력한다.
        // 로직 설계
        // 1. 층수와 호수를 입력받아 층수+1, 호수+1 크기의 DP 테이블을 생성
        // 2. 0층을 초기화
        // 3. 누적 합으로 DP 테이블에 저장 후 각 케이스 별 k,n 위치의 사람 수 출력

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            // 테스트 케이스 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과를 저장할 StringBuilder 인스턴스
            StringBuilder sb = new StringBuilder();

            // 테스트 케이스만큼 반복
            for(int t=0; t<testCase; t++) {

                // k, n 입력받기
                int k = Integer.parseInt(br.readLine());
                int n = Integer.parseInt(br.readLine());

                // k+1, n+1 크기의 DP 테이블 생성
                int[][] apartment = new int[k + 1][n + 1];

                // 0층 초기화
                for (int i = 1; i <= n; i++) {
                    apartment[0][i] = i;
                }

                // top-down 형식으로 DP 테이블에 값 저장
                for (int i = 1; i <= k; i++) {
                    for (int j = 1; j <= n; j++) {
                        apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
                    }
                }

                // sb 객체에 추가
                sb.append(apartment[k][n]+"\n");
            }

            // 결과 출력
            System.out.println(sb);

        }
    }
}
