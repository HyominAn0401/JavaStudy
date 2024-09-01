package Silver;

import java.util.Scanner;

public class Silver3_1463 {
    public static void main(String[] args) {
        // 구현 및 해야할 것 : 정수 X에서 세 가지 연산을 통해 1을 만드는 횟수의 최솟값 출력
        // 로직 설계
        // 1. N 입력받고 N+1크기의 메모리제이션을 이용할 배열 생성
        // 2. 점화식 : i에서 1을 만들 때 사용되는 연산의 횟수, 로 설정
        // 3. 세 가지 연산에 따른 반복문

        // try-with-resources로 Scanner 인스턴스 관리
        try(Scanner scanner = new Scanner(System.in)){
            // N 입력받기
            int N = scanner.nextInt();

            // N+1 크기의 배열 생성
            int [] DP = new int[N+1];

            // 반복
            for(int i=2; i<=N; i++){
                // 1을 빼는 연산이 가능할 때
                DP[i] = DP[i-1] + 1;
                // 2로 나누는 연산이 가능
                if(i%2==0){
                    DP[i] = Math.min(DP[i], DP[i/2]+1);
                }
                // 3으로 나누는 연산이 가능
                if(i%3==0)
                    DP[i] = Math.min(DP[i], DP[i/3]+1);
            }
            // 결과값 출력
            System.out.println(DP[N]);
        }
    }
}
