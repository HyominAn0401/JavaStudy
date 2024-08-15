package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_2559 {
    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 주어진 수열에서 K 구간 합의 최대값 구하기
        // 로직 설계
        // 1. N, K를 입력받고 N 크기의 배열을 생성하고 숫자를 저장한다.
        // 2. 초기 윈도우에서 합을 계산한다.
        // 3. 윈도우를 슬라이딩 하면서 최대값을 구하고 출력한다.

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, K 값 구하기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 숫자를 저장할 N 크기의 배열 생성
            int [] temp = new int[N];

            // 배열에 숫자 저장하기
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                temp[i] = Integer.parseInt(st.nextToken());
            }

            // 구간의 합과 최대값을 저장할 변수
            int sum = 0;
            int maxValue = 0;

            // 초기 윈도우 세팅
            for(int i=0; i<K; i++){
                sum += temp[i];
            }
            maxValue = sum;

            // 슬라이딩 윈도우
            for(int i=K; i<N; i++){
                sum += temp[i];
                sum -= temp[i-K];
                // 최대값 업데이트
                if(maxValue < sum)
                    maxValue = sum;
            }

            // 결과 출력
            System.out.println(maxValue);
        }
    }
}
