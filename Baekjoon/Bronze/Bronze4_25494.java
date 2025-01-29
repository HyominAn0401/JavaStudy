package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze4_25494 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 조건을 만족하는 정수 쌍의 개수 출력하기
        // 로직 설계
        // 1. 테스트 케이스 별 a, b, c값을 입력받는다
        // 2. 브루트포스 -> 모든 경우의 수를 돌려 조건에 만족하는 i, j, k가 존재할 때 result 값을 증가시킨다.
        // 3. 테스트 케이스 별 result 값을 출력한다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스트 케이스 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과값을 저장할 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // 테스트 케이스만큼 반복
            for(int t=0; t<testCase; t++){
                // 결과를 저장할 변수 초기화
                int result = 0;

                // a, b, c 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                // 모든 경우의 수를 돌려 조건에 만족하는 정수 쌍의 개수 구하기
                for(int i=1; i<=a; i++){
                    for(int j=1; j<=b; j++){
                        for(int k=1; k<=c; k++){
                            // 조건
                            if(i%j==j%k && j%k==k%i && k%i==i%j){
                                result++;
                            }
                        }
                    }
                }
                // result 저장
                sb.append(result+"\n");
            }
            // 결과 출력
            System.out.println(sb);
        }
    }
}
