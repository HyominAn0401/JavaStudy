package D2;

import java.util.Scanner;

public class D2_1966 {

    public static void main(String[] args) {

        // 구현 및 해야할 것 : 테스트 케이스만큼의 숫자열을 오름차순으로 정렬하고 출력하기
        // 로직 설계
        // 1. 테스트 케이스 입력받고 같은 크기의 행을 가진 이차원 배열 생성하기
        // 2. 테스트 케이스만큼 반복문 수행하기
        // 3. 숫자열 길이와 숫자 입력받기
        // 4. 버블 정렬로 오름차순으로 정렬하고 결과값 배열에 저장하기
        // 5. 숫자 출력하기

        Scanner scanner = new Scanner(System.in);
        // 테스트 케이스 값 입력받기
        int testCase = scanner.nextInt();
        // 오름차순 정렬 숫자열을 저장 후 출력할 이차원 배열
        int [][] results = new int[testCase][];

        // 테스트 케이스만큼 반복하는 for문
        for(int count = 0; count<results.length; count++) {
            // 숫자열 길이 입력받기
            int N = scanner.nextInt();
            // 오름차순을 저장할 배열
            int[] number = new int[N];
            // 배열의 길이를 저장하는 변수
            int length = number.length;

            // 숫자열을 입력받아 배열에 저장하는 반복문
            for (int i = 0; i < length; i++) {
                number[i] = scanner.nextInt();
            }


            // 버블 정렬
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - 1 - i; j++) {
                    if (number[j + 1] < number[j]) {
                        int tmp = number[j];
                        number[j] = number[j + 1];
                        number[j + 1] = tmp;
                    }
                }
            }
            // results 배열에 정렬된 배열 저장
            results[count] = number;

        }

        // 오름차순 정렬 숫자열 출력
        for(int i=0; i< results.length; i++){
            System.out.print("#"+ (i+1)+ " ");
            for(int j=0; j<results[i].length;j++){
                System.out.print(results[i][j]+" ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
