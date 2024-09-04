package Silver.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver_1003 {
    public static void main(String[] args) throws Exception{

        // 구현 및 해야할 것 : 테스트 케이스 별 피보나치 함수에서 0과 1이 출력되는 횟수 출력하기
        // 로직 설계
        // 1. 테스트 케이스 입력받기
        // 2. 각 테스트 케이스 별 N 입력받고 0과 1의 출력 횟수를 저장할 DP 배열 생성
        // 3. 0인 경우 초기화, N이 0보다 큰 경우 1초기화 및 점화식
        // 4. N일때 출력 횟수 출력

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스트 케이스 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과를 저장할 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // 테스트 케이스 별 반복
            for(int t=0; t<testCase; t++){
                // N값 입력받기
                int N = Integer.parseInt(br.readLine());
                // 각각 0과 1의 출력 횟수를 저장할 DP 배열
                int [] cntZero = new int[N+1];
                int [] cntOne = new int[N+1];

                // 0일 때 초기화
                cntZero[0] = 1;
                cntOne[0] = 0;

                // N이 0보다 큰 경우
                if(N>0){
                    // 1일때 초기화
                    cntZero[1] = 0;
                    cntOne[1] = 1;

                    // 2 이상인 경우 점화식
                    for(int i=2; i<=N; i++){
                        cntZero[i] = cntZero[i-2] + cntZero[i-1];
                        cntOne[i] = cntOne[i-2] + cntOne[i-1];
                    }
                }
                // 결과 sb 객체에 저장
                sb.append(cntZero[N]+" "+cntOne[N]+"\n");
            }
            // 출력
            System.out.print(sb);
        }
    }
}
