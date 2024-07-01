package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Bronze2_17608 {

    public static void main(String[] args) {

        // 구현 및 해야할 것 : 스택에 값을 입력받아 push 하고 오른쪽에서 보이는 막대기 개수 출력하기
        // 로직 설계
        // 1. 막대기 개수 입력받고 stack 생성
        // 2. stack에 막대기 개수만큼 높이 입력받아 push 하기
        // 3. peek 값이 maxValue보다 큰 경우 maxValue에 peek을 저장하고 cnt 개수 증가
        // 4. 스택이 빌 때까지 pop하고 cnt 출력하기

        // try-with-resources로 BufferedReader 생성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 막대기 개수 입력받기
            int stick = Integer.parseInt(br.readLine());
            // 막대기의 높이를 저장할 스택 생성
            Stack<Integer> stack = new Stack<Integer>();

            // 스택에 막대기 높이를 입력받아 저장
            for (int i = 0; i < stick; i++) {
                stack.push(Integer.parseInt(br.readLine()));
            }

            // 최대 높이를 저장할 변수
            int maxValue = Integer.MIN_VALUE;
            // 보이는 막대기 수를 저장할 변수
            int cnt = 0;
            // 스택이 빌 때까지 반복
            while (!stack.isEmpty()) {
                // peek 값이 maxValue보다 큰 경우
                if (maxValue < stack.peek()) {
                    // maxValue에 peek 값 저장
                    maxValue = stack.peek();
                    // 보이는 막대기 수 증가
                    cnt++;
                }
                // 스택에서 pop
                stack.pop();
            }
            // 보이는 막대기 수 출력
            System.out.println(cnt);

            // 발생한 예외 처리
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
//            int stick = Integer.parseInt(br.readLine());
//
//            int[] result = new int[stick];
//
//            Stack<Integer> stack = new Stack<Integer>();
//
//            int max = Integer.MIN_VALUE;
//
//            for(int i=0; i<stick; i++){
//                result[i] = Integer.parseInt(br.readLine());
//            }
//
//            for (int i = stick - 1; i >= 0; i--) {
//                int x = result[i];
//                if (x > max) {
//                    stack.push(x);
//                    max = x;
//                }
//            }
//
//            System.out.println(stack.size());
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }

//        try (Scanner scanner = new Scanner(System.in)) {
//            int stick = scanner.nextInt();
//
//            int[] result = new int[stick];
//
//            Stack<Integer> stack = new Stack<Integer>();
//
//            int max = Integer.MIN_VALUE;
//
//            for (int i = 0; i < stick; i++) {
//                result[i] = scanner.nextInt();
//            }
//
//            for (int i = stick-1; i >= 0; i--) {
//                int x = result[i];
//                if(x > max) {
//                    stack.push(x);
//                    max = x;
//                }
//            }
//
//            System.out.println(stack.size());
//        }


    }
}
