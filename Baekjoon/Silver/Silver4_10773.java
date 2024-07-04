package Silver;

import java.util.Scanner;
import java.util.Stack;

public class Silver4_10773 {
    public static void main(String[] args) {
        // 구현 및 해야할 것 : 입력받은 숫자 만큼 스택에 넣고 0일 경우 pop, 아닌 경우 push해 남은 숫자들의 합을 출력한다
        // 로직 설계
        // 1. 입력받을 숫자의 개수를 입력받고 Stack을 생성한다
        // 2. 입력받은 숫자만큼 반복하며 숫자 값이 0이 아니면 스택에 push, 0이고 스택이 비어있지 않은 경우 pop한다
        // 3. 스택에 남은 숫자들의 합을 출력한다

        // try-with-resources로 Scanner 인스턴스 관리
        try(Scanner scanner = new Scanner(System.in)){

            // 입력받을 숫자의 개수 입력받기
            int number = scanner.nextInt();
            // 스택 생성
            Stack<Integer> stack = new Stack<Integer>();

            // 입력받은 숫자만큼 반복
            for(int i=0; i<number; i++){
                // 숫자 입력받기
                int x = scanner.nextInt();
                // 0이 아닌 경우 스택에 push
                if(x!=0){
                    stack.push(x);
                }
                // 0이고 스택이 비어있지 않은 경우 pop
                else if(x==0 && !stack.isEmpty()){
                    stack.pop();
                }
            }

            // 스택에 남은 숫자값을 더해 저장할 변수
            int sum = 0;
            // 스택에 남은 숫자값의 개수
            int size = stack.size();

            // 스택에 남은 숫자값의 개수만큼 반복
            for(int i=0; i<size; i++){
                // 남은 숫자의 합 계산
                sum += stack.pop();
            }

            // 숫자의 합 출력
            System.out.println(sum);
        }
    }
}
