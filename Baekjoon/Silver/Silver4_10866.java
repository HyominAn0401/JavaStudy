package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Silver4_10866 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 정수 저장 덱을 구현해 입력 명령을 처리해 결과 출력하기
        // 로직 설계
        // 1. 정수 저장 덱 구현
        // 2. 명령어 분리
        // 3. 숫자 입력이 있는 경우, 명령어만 있는 경우
        // 4. 명령어별 결과 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 명령어 개수 입력받기
            int N = Integer.parseInt(br.readLine());
            // 결과 저장 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();
            // 정수 저장 덱
            Deque<Integer> deque = new LinkedList<>();
            // 명령어 개수만큼 반복
            for(int i=0; i<N; i++){
                // 명령어 받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                // 명령어
                String order = st.nextToken();
                // 명령어 구분
                if(order.equals("push_back")||order.equals("push_front")){
                    // 숫자 입력받기
                    int num = Integer.parseInt(st.nextToken());
                    switch (order) {
                        // 덱 뒤에 숫자 추가
                        case "push_back":
                            deque.addLast(num);
                            break;
                        // 덱 앞에 추가
                        case "push_front":
                            deque.addFirst(num);
                            break;
                    }
                } else{
                    switch (order){
                        // 맨 앞의 값 pop
                        case "pop_front":
                            // 덱이 비어있으면 -1
                            if (deque.isEmpty()) {
                                sb.append(-1+"\n");
                            } else {
                                // 덱에서 첫번째 값 삭제
                                sb.append(deque.removeFirst()+"\n");
                            }
                            break;
                        case "pop_back":
                            // 덱이 비어있으면 -1
                            if (deque.isEmpty()) {
                                sb.append(-1+"\n");
                            } else {
                                // 덱에서 마지막 값 삭제
                                sb.append(deque.removeLast()+"\n");
                            }
                            break;
                            // 덱에 있는 원소 개수 출력
                        case "size":
                            sb.append(deque.size()+"\n");
                            break;
                        case "empty":
                            // 덱이 비어있는지 확인
                            if(deque.isEmpty()) sb.append(1+"\n");
                            else sb.append(0+"\n");
                            break;
                        case "front":
                            // 비어있으면 -1
                            if(deque.isEmpty()) sb.append(-1+"\n");
                            // 첫번째 값 출력
                            else sb.append(deque.getFirst()+"\n");
                            break;
                        case "back":
                            // 비어있으면 -1
                            if(deque.isEmpty()) sb.append(-1+"\n");
                            // 마지막 값 출력
                            else sb.append(deque.getLast()+"\n");
                            break;
                    }
                }
            }
            // 결과 출력
            System.out.print(sb);
        }
    }
}
