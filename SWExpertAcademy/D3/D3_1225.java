package D3;

import java.util.Scanner;

public class D3_1225 {

    public static void main(String[] args) {

        // 구현 및 해야할 것 : 8개 숫자에서 가장 앞에 잇는 숫자를 사이클 내에서 차감하고 숫자들의 순서를 조정해 최종 결과를 출력한다.
        // 로직 설계
        // 1. 숫자 배열을 저장할 2차원 배열을 생성하고 2-4 단계를 10번 반복한다
        // 2. 테스크케이스 번호와 배열에 8개 데이터를 입력 받는다
        // 3. 1-5 숫자 내 사이클을 실행하고, 첫 번째 배열값에서 차감할 때마다 왼쪽으로 값을 이동시킨다. 차감값이 0 이하가 되면 해당값을 0으로 설정하고 반복을 종료한다
        // 4. 2차원 배열 해당 행에 정렬된 배열을 저장한다
        // 5. 수정된 배열을 출력한다

        // try-with-resources를 이용한 Scanner 인스턴스 자동 관리
        try(Scanner scanner = new Scanner(System.in)){
            // 정렬된 숫자배열을 저장할 2차원 배열
            int [][] cipherNumbers = new int[10][8];

            // testCase 10번 반복하기 위한 for문
            for(int testCase = 0; testCase<10; testCase++) {
                // 데이터값을 저장하고 정렬할 배열
                int[] cipherNumber = new int[8];
                // 배열 마지막 값이 0일 경우 while 반복문을 제어하기 위한 변수
                boolean lastNumberZero = false;

                // 테스트 케이스 번호 입력받기 위한 변수
                int caseNumber = scanner.nextInt();
                // 불필요한 공백을 위한 변수
                String blank = scanner.nextLine();

                // 배열에 8개 데이터를 입력받아 저장하는 for문
                for (int i = 0; i < 8; i++) {
                    cipherNumber[i] = scanner.nextInt();
                }

                // 첫 번째 배열값이 0이 될 때까지 반복하기 위한 while문
                while (!lastNumberZero) {
                    // 1-5까지 차감하는 cycle을 구현하기 위한 for문
                    for (int i = 1; i <= 5; i++) {
                        // 첫 번째 배열값에서 차감된 값이 0이하인 경우
                        if ((cipherNumber[0] - i) <= 0) {
                            // 배열 값 앞으로 한 칸씩 이동
                            for (int j = 1; j < 8; j++) {
                                cipherNumber[j - 1] = cipherNumber[j];
                            }
                            // 마지막 배열값 0으로 설정
                            cipherNumber[7] = 0;
                            // lastNumberZero를 true로 설정해 반복문 종료
                            lastNumberZero = true;
                            break;
                            // 차감 값이 0이 아닌 경우
                        } else {
                            // 첫 번째 배열값에서 i를 뺀 값을 저장하기 위한 변수
                            int tmp = cipherNumber[0] - i;
                            // 배열 값 앞으로 한 칸씩 이동
                            for (int j = 1; j < 8; j++) {
                                cipherNumber[j - 1] = cipherNumber[j];
                            }
                            // 마지막 배열값에 tmp 값 저장
                            cipherNumber[7] = tmp;
                        }
                    }
                }
                // 2차원 배열 testCase 행에 해당 배열 저장
                cipherNumbers[testCase] = cipherNumber;
            }

            // 배열 값 출력하기 위한 for문
            for(int k=0; k<10; k++){
                System.out.print("#"+(k+1)+" ");
                for(int j = 0; j<8; j++){
                    System.out.print(cipherNumbers[k][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
