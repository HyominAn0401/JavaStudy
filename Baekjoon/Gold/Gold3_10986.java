package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold3_10986 {
    public static void main(String[] args) throws IOException {
        // 구현 및 해야할 것 : 수열에서 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 수 출력하기
        // 로직 설계
        // 1. N, M 입력받고 숫자 배열에 저장하기
        // 2. 누적합 배열을 생성하고 M으로 나누어 떨어지는 횟수 저장하고 출력하기

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 숫자를 저장할 배열 초기화
            int [] numbersArray = new int[N+1];

            // 배열에 숫자 저장
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                numbersArray[i] = Integer.parseInt(st.nextToken());
            }

            // 결과값을 저장할 cnt 변수 초기화
            int cnt = 0;

            // 누적합 배열에 값을 저장하고 M으로 나누어 떨어지는 지 확인
            for(int i=0; i<N+1; i++){
                // 누적 합을 저장할 배열
                int [] prefixSum = new int[N+1-i];
                // pt 값 초기화
                int pt = i+1;
                // 누적 합 계산
                for(int j=1; j<N+1-i; j++){
                    prefixSum[j] = prefixSum[j-1] + numbersArray[pt];
                    pt++;
                    // M으로 나누어 떨어지면 cnt값 증가
                    if(prefixSum[j]%M==0)   {
                        cnt++;
                    }
                }
            }

            // 출력 
            System.out.println(cnt);
        }
    }
}
