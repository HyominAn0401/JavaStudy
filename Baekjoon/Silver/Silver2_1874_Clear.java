package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver2_1874_Clear {

    public static void main(String[] args) {

        // 구현 및 해야할 것 :
        // 로직 설계
        // 1. 입력받을 숫자 개수를 입력받는다
        // 2. 스택, 수열을 저장할 배열, +/- 를 저장할 배열을 생성한다
        // 3. 배열에 숫자를 입력받아 수열을 저장한다
        // 4-1. 스택이 비어 있거나 스택에 넣어야 할 수열의 숫자가 peek보다 크면 push하고 배열에 +를 저장한다
        // 4-2. 수열의 숫자가 peek와 같으면 pop하고 배열에 -를 저장한다
        // 4-3. 그 외의 경우 No를 출력하고 반복문을 빠져나간다
        // 5. 배열에 저장된 character 값을 출력한다

        // try-with-resources로 BufferedReader를 열고 자동으로 닫히게 설정
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 입력 받을 숫자의 개수 입력받기
            int number = Integer.parseInt(br.readLine());
            // 정수 스택 생성
            Stack<Integer> stack = new Stack<Integer>();
            // 수열을 저장할 배열
            int [] array = new int[number];
            // +/-를 저장할 배열
            char [] result = new char[number*2];

            // 배열에 수열을 저장하는 for문
            for(int i=0; i<number; i++){
                array[i] = Integer.parseInt(br.readLine());
            }

            // 1부터 number까지 저장할 변수
            int cnt = 1;
            // 수열 배열 인덱스를 저장할 변수
            int arrayCnt = 0;
            // 결과 배열 인덱스를 저장할 변수
            int resultCnt = 0;

            while(arrayCnt < number){
                // 스택이 비어 있거나 스택에 넣어야 할 숫자가 peek보다 큰 경우
                if(stack.isEmpty() || array[arrayCnt] > stack.peek()) {
                    // 스택에 cnt 값 push
                    stack.push(cnt);
                    // 배열에 + 저장
                    result[resultCnt] = '+';
                    // 배열 인덱스 증가
                    resultCnt++;
                    // 다음에 스택에 넣을 숫자 증가
                    cnt++;
                    // 다음 반복으로 넘어감
                    continue;
                }

                // 수열의 숫자가 peek과 같은 경우
                if(array[arrayCnt] == stack.peek()) {
                    // 수열 인덱스 증가
                    arrayCnt++;
                    // 스택에서 pop
                    stack.pop();
                    // 배열에 - 저장
                    result[resultCnt] = '-';
                    // 결과 인덱스 증가
                    resultCnt++;
                    // 그 외의 경우
                } else {
                    // No를 출력하고 종료
                    System.out.println("NO");
                    return;
                }
            }

            // 배열에 저장된 character값 출력할 for문
            for(int i=0; i<resultCnt; i++){
                System.out.println(result[i]);
            }

            // 예외 처리
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
