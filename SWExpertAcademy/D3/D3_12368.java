package D3;

import java.util.Scanner;

public class D3_12368 {
    public static void main(String[] args) {

        // 구현 및 해야할 것 : A에서 B 시간이 흘렀을 때 24시간제에 맞게 현재 시간 출력하기
        // 로직 설계
        // 1. 테스트 케이스 입력받아 반복하고 시간 저장할 배열을 생성한다
        // 2. 각 케이스 별 A와 B를 입력받고 24시간제에 맞는 현재 시간을 구한다
        // 3. 배열에 저장하고 출력한다.

        // try-with-resources로 Scanner
        try(Scanner scanner = new Scanner(System.in)){

            // 테스트 케이스 입력받기
            int testCase = scanner.nextInt();
            // 각 테스트 케이스별 현재 시간을 저장할 배열
            int [] timeCase = new int[testCase];

            // 테스트 케이스만큼 반복하는 for문
            for(int i=0; i<testCase; i++){
                // A와 B 시간 입력받기 (0<=A, B<=23)
                int A = scanner.nextInt();
                int B = scanner.nextInt();

                // 현재 시간
                int time = (A+B)%24;

                // 현재 시간 배열에 저장
                timeCase[i] = time;
            }

            // 각 테스트 케이스 별 배열값 출력
            for(int i=0; i<testCase; i++){
                System.out.println("#"+(i+1)+" "+timeCase[i]);
            }
        }
    }
}
