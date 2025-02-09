package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver1_18230 {
    public static void main(String[] args) throws Exception {
        // 구현 및 해야할 것 : 2xN 크기 격자에 예쁨을 최대화하는 타일을 붙이고 최댓값 출력하기
        // 로직 설계
        // 1. 값 입력받고 내림차순 정렬하기
        // 2. N이 홀수인 경우 가장 큰 예쁨의 2x1 먼저 선택
        // 3. 2x1 2개, 2x2 타일 중 예쁨이 더 큰 타일 선택
        // 4. 남은 타일 전부 사용하기
        // 5. 결과값 출력

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // N, A, B 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 배열 초기화
            Integer[] arrayA = new Integer[A];
            Integer[] arrayB = new Integer[B];

            // 배열에 값 저장
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A; i++) {
                arrayA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B; i++) {
                arrayB[i] = Integer.parseInt(st.nextToken());
            }

            // 내림차순 정렬
            Arrays.sort(arrayA, Collections.reverseOrder());
            Arrays.sort(arrayB, Collections.reverseOrder());

            // 각 타일 인덱스 설정
            int index_1=0;
            int index_2=0;
            int sum =0;

            // 홀수인 경우 A에서 하나 선택하기
            if(N % 2 == 1){
                // 2x1 타일이 남아 있는 경우
                if(index_1 < A){
                    sum+=arrayA[index_1];
                    index_1++;
                    N--;
                }
            }

            // 짝수를 맞춘 경우
            while(N >0){
                // 2x1 타일이 부족한 경우 2x2 타일만 사용
                if(index_1 + 1 >= A){
                    while (N > 0 && index_2 < B) {
                        sum+=arrayB[index_2];
                        index_2++;
                        N-=2;
                    }
                    // 종료
                    break;
                }

                // 2x2 타일이 부족한 경우 2x1 타일만 사용한다.
                if (index_2>= B) {
                    while (N > 0&& index_1 + 1 < A) {
                        sum+=arrayA[index_1] + arrayA[index_1 + 1];
                        index_1+=2;
                        N-=2;
                    }
                    break;
                }

                // 비교해 더 큰 값 선택
                if(arrayA[index_1] + arrayA[index_1 + 1] <= arrayB[index_2]) {
                    // 누적합
                    sum += arrayB[index_2];
                    // 인덱스 증가
                    index_2++;
                }
                else{
                    // 누적합
                    sum += arrayA[index_1] + arrayA[index_1 + 1];
                    // 인덱스 증가
                    index_1 += 2;
                }
                // 2x2 타일을 사용했으므로 2 감소
                N -= 2;
            }

            // 결과값 출력
            System.out.println(sum);
        }
    }
}
