package D2;

import java.util.Scanner;

public class D2_1959 {

    public static void main(String[] args) {

        // 구현 및 해야할 것 : 두 개의 정수 배열의 크기와 원소값을 입력받고 원소값을 곱한 값의 최댓값을 찾는다
        // 로직 설계 :
        // 1. 테스트 케이스 수를 입력받는다
        // 2. 각 테스트 케이스 별 배열의 크기와 숫자를 입력받는다
        // 3. 두 개의 배열 중 크기가 작은 배열을 슬라이딩 해 최대값을 구한다
        // 4. 결과값 배열에 저장하고 출력한다

        Scanner scanner = new Scanner(System.in);

        // 테스트 케이스 수 입력받기(변수명 수정)
        int testCase = scanner.nextInt();
        // 이전 변수명
        // int T = scanner.nextInt();

        // 테스트 케이스 결과값을 저장할 배열
        int results [] = new int [testCase];

        //테스트 케이스 반복
        for(int t=0; t<testCase; t++) {
            // 두 배열의 크기값 입력받기(변수명 수정)
            int arraySizeN = scanner.nextInt();
            int arraySizeM = scanner.nextInt();
            // 이전 변수명
            // int N = scanner.nextInt();
            // int M = scanner.nextInt();

            // 입력받은 크기값에 따라 배열 생성(변수명 수정)
            int arrayA[] = new int[arraySizeN];
            int arrayB[] = new int[arraySizeM];
            // 이전 변수명
            // int A[] = new int[N];
            // int B[] = new int[M];

            // 슬라이딩 윈도우 크기값
            // int s = Math.abs(N - M) + 1;

            //첫 번째 배열에 원소값 입력(변수명 수정)
            for(int i =0; i<arraySizeN; i++){
                arrayA[i] = scanner.nextInt();
            }
            // 이전 변수명
            //for (int a = 0; a < N; a++) {
            //    A[a] = scanner.nextInt();
            //}

            // 두 번째 배열에 원소값 입력(변수명 수정)
            for(int j=0; j<arraySizeM; j++){
                arrayB[j] = scanner.nextInt();
            }
            // 이전 변수명
            //for (int b = 0; b < M; b++) {
            //    B[b] = scanner.nextInt();
            //}

            // 최대 곱의 합을 저장할 변수 초기화(변수명 수정)
            int maxProductSum = 0;
            // 이전 변수명
            // int result = 0;

            // 첫 번째 배열이 더 작거나 같은 경우
            if (arraySizeN <= arraySizeM) {
                // 슬라이딩 윈도우로 곱의 합 계산
                for(int i = 0; i<Math.abs(arraySizeN-arraySizeM)+1;i++){
                    int currentSum = 0;
                    for (int j = 0; j < arraySizeN; j++) {
                        currentSum += arrayA[j] * arrayB[i + j];
                    }
                    if (currentSum > maxProductSum) maxProductSum = currentSum;
                }
            }
            // 두 번째 배열이 더 작은 경우
            else {
                for (int i = 0; i < Math.abs(arraySizeN-arraySizeM)+1; i++) {
                    int currentSum = 0;
                    for (int j = 0; j < arraySizeM; j++) {
                        currentSum += arrayA[i + j] * arrayB[j];
                    }
                    if (currentSum > maxProductSum) maxProductSum = currentSum;
                }
            }
            // 결과값 저장
            results[t] = maxProductSum;
        }

        // 결과 출력
        for(int i=0; i<results.length;i++){
            System.out.println("#"+(i+1)+" "+results[i]);
        }

        scanner.close();
    }
}
