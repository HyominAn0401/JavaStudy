package Bronze;

import java.io.IOException;
import java.util.Scanner;

public class Bronze2_2747 {
    public static int [] Fibo;
    public static void main(String[] args) throws IOException {
        // 구현 및 해야할 것 : n번째 피보나치 수 구하기
        // 로직 설계
        // 1. n 입력받고 n+1 크기의 배열 생성
        // 2. DP 테이블에 점화식에 따른 값 저장
        // 3. n번째 피보나치 수 출력

        // try-with-resources로 scanner 객체 관리
        try(Scanner scanner = new Scanner(System.in)){
            // n값 입력받기
            int n = scanner.nextInt();

            // 배열 초기화
            Fibo = new int[n+1];

            // 0, 1일때 초기화
            Fibo[0] = 0;
            Fibo[1] = 1;

            // DP 테이블 저장
            for(int i=2; i<=n; i++){
                Fibo[i] = Fibo[i-1] + Fibo[i-2];
            }

            // n번째 피보나치 수 출력
            System.out.println(Fibo[n]);
        }
    }

}
