package D3;

import java.util.Scanner;

public class D3_3431 {
    public static void main(String[] args) {

        // 구현 및 해야할 것 : 테스트케이스 수와 최소운동, 최대운동, 실제 운동시간을 입력받아 상황에 맞는 값을 출력한다
        // 로직 설계
        // 1. 테스트 케이스 수를 입력받고 해당 크기의 배열을 생성한다
        // 2. 각 테스트 케이스만큼 L, U, X를 입력받는다
        // 3. X<L 이면 부족한 운동 시간을 결과로 저장한다
        // 4. L <= X <= U면 결과를 0으로 저장한다
        // 5. X>U면 결과에 -1을 저장한다
        // 6. 테스트 케이스마다 값을 출력한다

        try(Scanner scanner = new Scanner(System.in)){
            // 테스트 케이스 수 입력받기
            int testCase = scanner.nextInt();
            // 테스트 케이스 결과값을 저장할 배열
            int [] exerciseMin = new int[testCase];

            // 테스트 케이스만큼 반복하는 for문
            for(int i=0; i<testCase; i++){
                // 최소 운동시간, 최대 운동시간, 실제 운동시간 입력받기
                int L = scanner.nextInt();
                int U = scanner.nextInt();
                int X = scanner.nextInt();
                // 결과값을 저장할 변수
                int result = 0;

                // 실제 운동시간 < 최소 운동 시간인 경우
                if(X < L)   result = L-X;   //부족한 운동시간 계산
                // 최소 운동 시간 <= 실제 운동시간 <= 최대 운동시간인 경우
                else if((X>=L) && (X<=U))   result = 0;
                // 최대 운동시간 < 실제 운동시간
                else if(X > U)  result = -1;
                // 결과값을 각 테스트 케이스 배열에 저장
                exerciseMin[i] = result;
            }

            // 테스트 케이스 결과값 출력
            for(int i=0; i<testCase; i++){
                System.out.println("#"+(i+1)+" "+exerciseMin[i]);
            }
        }
    }
}
