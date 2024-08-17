package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Silver4_2164 {
    public static void main(String[] args) throws IOException {
        // 구현 및 해야할 것 : 큐에서 카드가 한 장 남을때까지 처리한 후 마지막 카드 출력하기
        // 로직 설계
        // 1. N 입력받고 큐에 1-N까지 추가
        // 2. 큐에 있는 카드 개수가 1개가 될 때까지 반복
        // 2-1. 맨 위의 카드 버리기
        // 2-2. 다음 카드 맨 밑으로 넣기
        // 3. 마지막 카드 출력

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N 입력받기
            int N = Integer.parseInt(br.readLine());
            // 큐 생성
            Queue<Integer> queue = new LinkedList<>();

            // 큐에 숫자 넣기
            for(int i=1; i<=N; i++){
                queue.add(i);
            }

            // 카드 개수가 1개가 될 때까지 반복
            while(queue.size() > 1){
                // 맨 위 카드 버리기
                queue.poll();
                // 다음 카드 맨 밑으로 넣기
                queue.add(queue.poll());
            }

            // 출력 
            System.out.println(queue.poll());
        }
    }
}
