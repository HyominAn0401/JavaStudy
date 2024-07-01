package D3;

import java.util.Scanner;
import java.util.Stack;

public class D3_1234 {

    public static void main(String[] args) {

        // 구현 및 해야할 것 : 같은 번호로 붙어있는 쌍을 소거하고 남은 번호를 출력한다
        // 로직 설계
        // 1. 이차원 배열을 생성하고 테스트 케이스 10번 실행한다
        // 2. 각 테스트 케이스에서 비밀번호 길이와 문자열을 입력받는다
        // 3. 스택을 생성하고 현재 값과 peek 값이 같으면 pop, 아니면 push 한다
        // 4. 스택에 남은 원소 개수만큼 크기를 구하고 배열을 생성한 후 pop한 값을 저장한다.
        // 5. 각 테스트 케이스 값을 출력한다

        // try-with-resources로 Scanner 자원 관리
        try(Scanner scanner = new Scanner(System.in)) {
            // 테스트 케이스 별 값을 저장할 이차원 배열
            int [][] results = new int[10][];

            // 10번 반복할 for 문
            for (int testCase = 0; testCase < 10; testCase++) {
                // 비밀번호 길이와 문자열 입력받기
                int capacity = scanner.nextInt();
                String numbers = scanner.next();

                // integer 값을 저장할 스택 생성
                Stack<Integer> stack = new Stack<>();

                // 비밀번호 길이만큼 반복할 for문
                for (int i = 0; i < capacity; i++) {
                    // String으로 입력받은 문자열을 정수값으로 변환
                    int x = Integer.parseInt(String.valueOf(numbers.charAt(i)));

                    // 스택이 비어있지 않고 가장 위의 값이 현재 값과 같을 때
                    if (!stack.isEmpty() && stack.peek() == x) {
                        // 스택에서 소거
                        stack.pop();
                        //System.out.println("pop함");
                    }
                    // 현재 값과 같지 않을 경우
                    else {
                        // 스택에 현재 값 push
                        stack.push(x);
                        //System.out.println(x+"를 push함");
                    }
                }

                // 스택에 남아있는 원소의 개수를 저장할 변수
                int size = stack.size();

                // 스택에 저장된 원소의 개수를 reverse로 저장하기 위한 배열
                int [] reverse = new int[size];

                // reverse 배열에 pop한 값 저장
                for(int i=0; i<size; i++){
                    reverse[i] = stack.pop();
                }

                // 이차원 배열에 저장
                results[testCase] = reverse;
            }

            // 각 테스트 케이스 별 결과값 출력
            for(int testCase=0; testCase<10; testCase++){
                System.out.print("#"+(testCase+1)+" ");
                for(int i=0; i<results[testCase].length;i++){
                    System.out.print(results[testCase][i]);
                }
                System.out.println();
            }
        }
    }
}
