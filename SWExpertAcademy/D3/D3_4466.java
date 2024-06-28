package D3;

import java.util.Arrays;
import java.util.Scanner;

public class D3_4466 {
    public static void main(String[] args) {

        // 구현 및 해야할 것 : 테스트 케이스만큼 N과 K, 점수를 입력받아 K개 총점 최대값을 출력한다
        // 로직 설계
        // 1. 테스트 케이스를 입력받고 해당 크기의 배열을 생성한다
        // 2. 각 테스트 케이스별 N, K, 점수를 입력받는다
        // 3. 점수를 배열에 저장하고 오름차순으로 정렬한다
        // 4. K개 만큼 최대값부터 차례로 sum에 누적 합한다
        // 5. 각 테스트 케이스 별 총점의 최댓값을 출력한다

        // try-with-resources로 Scanner 자원 관리
        try(Scanner scanner = new Scanner(System.in)) {
            // 테스트 케이스 입력받기
            int testCase = scanner.nextInt();
            // 각 테스트 케이스별 총점 최댓값을 저장할 배열
            int[] sumScores = new int[testCase];

            // 테스트 케이스만큼 반복할 for문
            for (int i = 0; i < testCase; i++) {
                // N, K값 입력받기
                int N = scanner.nextInt();
                int K = scanner.nextInt();
                // N개의 점수를 저장할 배열
                int[] scores = new int[N];
                // 총점의 최댓값을 저장할 변수
                int sum = 0;

                // 점수를 입력받아 배열에 저장하는 for문
                for (int j = 0; j < N; j++) {
                    scores[j] = scanner.nextInt();
                }
                // 배열 오름차순으로 정렬
                Arrays.sort(scores);

                // 배열 끝 원소부터 차례로 K개 점수의 합 저장하는 for문
                for(int j=N-1; j>N-1-K; j--){
                    // 변수에 K개의 최대값 저장
                    sum += scores[j];
                }

                // 배열에 최대값 저장
                sumScores[i] = sum;
            }

            // 각 테스트 케이스 별 총점 최대값 출력
            for(int i=0; i<testCase; i++){
                System.out.println("#"+(i+1)+" "+sumScores[i]);
            }
        }
    }
}
