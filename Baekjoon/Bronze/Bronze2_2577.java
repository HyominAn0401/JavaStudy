package Bronze;

import java.util.Scanner;

public class Bronze2_2577 {
    public static void main(String[] args) {
        // 구현 및 해야할 것 : A*B*C 결과값에 0-9 숫자가 몇 번씩 쓰였는지 출력하기
        // 로직 설계
        // 1. A, B, C를 입력받고 A*B*C 값을 구한다.
        // 2. 0-9 개수를 셀 배열을 생성한다.
        // 3. 결과값을 String으로 변환하고 분해한 후 개수를 세서 배열에 저장한다.

        // Scanner 인스턴스 생성
        Scanner scanner = new Scanner(System.in);
        // A, B, C 입력받기
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        // A*B*C 값 구하기
        int result = A*B*C;

        // 0-9 개수를 저장할 배열 생성
        int [] count = new int[10];

        // 문자열로 변환
        String resultStr = Integer.toString(result);
        // 등장 횟수만큼 증가
        for(char ch : resultStr.toCharArray()){
            count[Character.getNumericValue(ch)]++;
        }

        // 출력
        for(int cnt : count){
            System.out.println(cnt);
        }
    }
}
