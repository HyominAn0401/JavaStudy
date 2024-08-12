package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_12847 {
    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : N, M, N개만큼의 숫자를 입력받아 슬라이딩 윈도우를 사용해 최대값을 출력한다.
        // 로직 설계
        // 1. N, M을 입력받고 N+1 크기의 숫자를 저장할 배열과 누적합을 저장할 배열을 생성한다.
        // 2. N만큼 숫자를 입력받으면서 배열에 저장하고 누적 합을 계산한다.
        // 3. start, end를 초기화하고 end값이 N보다 작거나 같을 때까지 반복한다.
        // 3-1. start-1과 end 인덱스의 누적 합을 계산한다.
        // 3-2. 해당 누적 합 값이 maxValue보다 크면 maxValue를 업데이트한다.
        // 4. maxValue 값을 출력한다.

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 숫자를 저장할 배열과 누적합을 저장할 배열 생성
            long [] salary = new long[N+1];
            long [] prefixSum = new long[N+1];

            // 숫자 입력받아 salary 배열에 저장하고 누적 합 계산하기
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                salary[i] = Integer.parseInt(st.nextToken());
                prefixSum[i] = prefixSum[i-1] + salary[i];
            }

            // start, end 포인터 초기화
            int start=1, end=start+(M-1);
            // 최대값을 저장할 maxValue 초기화
            long maxValue = Long.MIN_VALUE;

            // end값이 N보다 작거나 같으면 반복
            while(end<=N){
                // 누적 합 계산
                long result = prefixSum[end] - prefixSum[start-1];
                // 누적 합보다 maxValue값이 더 크면 업데이트
                if(result > maxValue)
                    maxValue = result;
                // 포인터 값 증가
                start++;
                end++;
            }

            // 결과 출력
            System.out.println(maxValue);
        }
    }
}
