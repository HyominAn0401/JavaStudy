package D2;

import java.util.Scanner;

public class D2_1984 {

    public static void main(String[] args) {

        // 구현 및 해야할 것 :
        // 로직 설계
        // 1. testCase를 입력받고 해당 크기의 배열을 생성한다
        // 2. testCase 만큼 반복한다
        // 3. 입력받은 수를 배열에 넣고 max와 min 값을 구한다
        // 4. max, min을 뺀 나머지 수의 평균을 구해 배열에 저장하고 출력한다

        Scanner scanner = new Scanner(System.in);
        // 테스트 케이스 값 입력받기
        int testCase = scanner.nextInt();
        // 평균값을 저장할 테스트 케이스 값 크기의 배열
        int [] results = new int[testCase];

        // 테스트 케이스만큼 반복하는 for문
        for(int i = 0; i<testCase; i++){
            // 10개의 숫자를 입력받을 배열
            int [] num = new int[10];
            //int max = -999;
            //int min = 999;
            // 최대값과 최솟값을 저장할 변수
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            // 평균을 위한 전체합 변수
            int sum = 0;

            // 10개의 숫자 입력받고 min, max, 합을 구하는 for문
            for(int j=0; j<10; j++) {
                num[j] = scanner.nextInt();
                sum += num[j];

                if (num[j] > max) max = num[j];
                if (num[j] < min) min = num[j];
            }

            // 평균값을 배열에 저장
            // 소수점 첫째자리에서 반올림
            results[i] = Math.round((float)(sum-max-min)/8);
        }

        // 평균값 출력 
        for(int i = 0; i<testCase; i++){
            System.out.println("#"+(i+1)+" "+ results[i]);
        }

        scanner.close();
    }
}
