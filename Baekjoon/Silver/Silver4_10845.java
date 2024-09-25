package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Silver4_10845 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 큐를 구현하고 명령에 따른 값 출력하기
        // 로직 설계
        // 1. Deque 객체 생성
        // 2. N값을 입력받고 N번 명령어 반복
        // 3. 결과값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            //Queue<Integer> queue = new LinkedList<>();
            // Deque 생성 -> 맨 뒤의 값 고려
            Deque<Integer> queue = new LinkedList<>();
            // 결과값 저장하기 위한 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // N값 입력받기
            int N = Integer.parseInt(br.readLine());
            // N번 반복
            for(int i=0; i<N; i++){
                // 명령어 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();

                // 명령어에 따른 처리
                switch(order){
                    // front인 경우
                    case "front":
                        // 큐가 비어있지 않으면
                        if(!queue.isEmpty()){
                            // 큐 가장 앞의 정수
                            sb.append(queue.peek()+"\n");
                            //System.out.println(queue.peek());
                        }
                        // 큐에 정수가 없으면 -1
                        else{
                            sb.append(-1+"\n");
                            //System.out.println(-1);
                        }
                        break;
                    // back인 경우
                    case "back":
                        // 큐가 비어있지 않은 경우
                        if(!queue.isEmpty()){
                            // 큐 가장 뒤에 있는 정수
                            sb.append(queue.peekLast()+"\n");
                        }
                        // 큐가 비어 있으면 -1
                        else{
                            sb.append(-1+"\n");
                        }
                        break;
                    // size인 경우
                    case "size":
                        // 큐에 남아있는 정수의 개수
                        sb.append(queue.size()+"\n");
                        //System.out.println(queue.size());
                        break;
                    // empty인 경우
                    case "empty":
                        // 큐가 비어있는 경우
                        if(queue.isEmpty()){
                            // 1
                            sb.append(1+"\n");
                            //System.out.println(1);
                            break;
                        }
                        // 큐가 비어있지 않은 경우
                        else{
                            // 0
                            sb.append(0+"\n");
                            //System.out.println(0);
                        }
                        break;
                    // push인 경우
                    case "push":
                        // 뒤의 정수 입력받기
                        int X = Integer.parseInt(st.nextToken());
                        // 큐에 추가
                        queue.add(X);
                        break;
                    // pop인 경우
                    case "pop":
                        // 큐가 비어있지 않은 경우
                        if(!queue.isEmpty()) {
                            // 가장 앞의 정수 빼기
                            sb.append(queue.poll()+"\n");
                            //System.out.println(queue.poll());
                        }
                        // 큐가 비어있는 경우
                        else{
                            sb.append(-1+"\n");
                            //System.out.println(-1);
                        }
                        break;
                }
            }
            // 결과값 출력
            System.out.print(sb);
        }
    }
}
