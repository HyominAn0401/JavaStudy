package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver4_10828 {
    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 명령어를 입력받아 명령에 따른 값 출력하기
        // 로직 설계
        // 1. 명령어 개수 입력받고 정수를 입력받는 스택 생성
        // 2. 명령어 개수 만큼 반복
        // 3. 들어오는 명령문에 따라 처리
        // 4. 결과값 출력

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 명령어 개수 입력받기
            int orderNum = Integer.parseInt(br.readLine());

            // 정수 입력받는 스택 생성
            Stack<Integer> stack = new Stack<>();
            // 결과 저장할 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // 명령어 개수만큼 반복
            for(int i=0; i<orderNum; i++){
                // 명령어 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();

                // 명령에 따라 처리
                switch(order){
                    // push
                    case "push":
                        // 숫자값 스택에 푸시
                        int num = Integer.parseInt(st.nextToken());
                        stack.push(num);
                        break;
                    // top
                    case "top":
                        //System.out.println(stack.peek());
                        // 스택이 비어있는 경우 -1
                        if(stack.isEmpty()){
                            sb.append(-1+"\n");
                        }
                        // 아닌 경우 스택 맨 위의 값
                        else{
                            sb.append(stack.peek()+"\n");
                        }
                        break;
                    // empty
                    case "empty":
                        // 스택이 빈 경우 1
                        if(stack.isEmpty()) {
                            //System.out.println(1);
                            sb.append(1+"\n");
                        }
                        // 비어있지 않은 경우 0
                        else {
                            //System.out.println(0);
                            sb.append(0+"\n");
                        }
                        break;
                    // size
                    case "size":
                        // 스택에 들어있는 요소 개수 출력
                        //System.out.println(stack.size());
                        sb.append(stack.size()+"\n");
                        break;
                    // pop
                    case "pop":
                        // 스택이 빈 경우 -1
                        if(stack.isEmpty())
                            //System.out.println(-1);
                            sb.append(-1+"\n");
                        // 비어있지 않은 경우 맨 위의 값 pop
                        else{
                            //stack.pop();
                            //System.out.println(stack.pop());
                            sb.append(stack.pop()+"\n");
                        }
                        break;
                }
            }

            // 결과값 출력 
            System.out.println(sb);
        }
    }
}
