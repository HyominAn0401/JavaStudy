package D3;

import java.util.Scanner;

public class D3_8931 {

    public static class NumStack{
        // 스택으로 사용할 배열
        private int [] stk;
        // 스택 포인터
        private int ptr;

        // 생성자
        public NumStack(int len){
            // 스택 크기 초기화
            stk = new int[len];
            // 포인터 초기화
            ptr=0;
        }

        // 스택에 요소 추가
        public int push(int x){
            // 스택에 x 추가하고 포인터 증가
            return stk[ptr++] = x;
        }

        // 스택에서 요소 제거
        public int pop(){
            // 포인터 감소, 해당 위치 값 반환
            return stk[--ptr];
        }

    }

    public static void main(String[] args) {

        // 구현 및 해야할 것 : 각 테스트 케이스마다 수를 입력받아 0이면 제거, 아니면 스택에 추가해 숫자의 합을 계산하고 출력한다
        // 로직 설계
        // 1. 테스트 케이스를 입력받고 해당 크기만큼 숫자합을 저장할 배열을 생성한다.
        // 2. 각 테스트 케이스 별 스택 크기를 입력받고 NumStack 인스턴스를 생성한다.
        // 3. 크기만큼 숫자를 입력받고 0이 아니면 스택에 푸시, 0이면 0 포함 가장 최근에 추가된 숫자를 팝한다.
        // 4. 스택에 남아있는 숫자의 합을 계산하고 totalSum 배열에 저장한다.

        // try-with-resources를 이용한 Scanner 인스턴스
        try(Scanner scanner = new Scanner(System.in)){
            // 테스트 케이스 입력받기
            int testCase = scanner.nextInt();
            // 숫자 합을 저장할 배열
            int [] totalSum = new int[testCase];

            // 테스트 케이스만큼 반복할 for문
            for(int test=0; test<testCase; test++) {
                // 스택의 크기 입력받기
                int K = scanner.nextInt();
                // NumStack 인스턴스 생성 및 초기화
                NumStack numStack = new NumStack(K);

                //
                int x;
                // 숫자 합을 저장할 변수
                int sum = 0;

                // 스택 크기만큼 반복할 for문
                for (int i = 0; i < K; i++) {
                    // 숫자를 입력받아 인스턴스 내 스택에 push
                    x = scanner.nextInt();
                    numStack.push(x);
                    // 0이면 0을 포함해 가장 최근에 추가된 숫자 pop
                    if (x == 0) {
                        numStack.pop();
                        numStack.pop();
                    }
                }

                // 스택에 있는 숫자들의 합을 계산하는 반복문
                for (int i = 0; i < numStack.ptr; i++) {
                    sum += numStack.stk[i];
                }
                // 배열에 숫자합 저장
                totalSum[test] = sum;
            }

            // 각 테스트 케이스별 숫자합 출력
            for(int i=0; i<testCase; i++){
                System.out.println("#"+(i+1)+" "+totalSum[i]);
            }
        }
    }


}
