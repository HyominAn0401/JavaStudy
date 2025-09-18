package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver3_2548 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 완전탐색으로 값의 차이의 합이 가장 작은 대표 자연수를 출력
        // 로직 설계
        // 1. N개 숫자를 입력받아 배열에 저장
        // 2. 배열의 모든 값에 대해 차이의 합을 계산
        // 3. 각 반복에서 가장 작은 차이의 합이 나오는 대표 자연수 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값과 해당 크기의 배열 초기화
            int N = Integer.parseInt(br.readLine());
            int [] numArray = new int[N];

            // 배열에 값 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numArray[i] = Integer.parseInt(st.nextToken());
            }

            // 배열 오름차순 정렬
            Arrays.sort(numArray);

            // 대표 자연수 배열 첫 값으로 초기화
            int representNum = numArray[0];
            // 최종 결과 차이의 합 가장 큰 수로 초기화
            int resultSum = Integer.MAX_VALUE;

            // 배열의 모든 값에 대해 반복
            for(int i=0; i<N; i++){
                // 차이의 합을 저장할 변수
                int sum = 0;
                // 배열값 반복
                for(int j=0; j<N; j++){
                    // 값의 차이 계산
                    sum += Math.abs(numArray[j] - numArray[i]);
                }
                // 기존 차이의 합보다 작으면
                if(resultSum > sum) {
                    // 값 업데이트
                    representNum = numArray[i];
                    resultSum = sum;
                }
            }

            // 출력
            System.out.println(representNum);
        }
    }
}
