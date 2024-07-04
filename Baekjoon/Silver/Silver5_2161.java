package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Silver5_2161 {

    public static void main(String[] args) {

        // 구현 및 해야할 것 : 큐에 1부터 N까지 숫자를 입력하고 첫 카드는 버리고 다음 카드는 맨 뒤로 추가하는 작업을 반복 실행하고 출력한다
        // 로직 설계
        // 1. 카드의 개수를 입력받는다
        // 2. 큐와 결과값을 저장할 배열을 생성한다
        // 3. 큐에 숫자를 넣고, 첫 카드는 버리고 그 다음 카드는 큐 맨 뒤로 옮기는 작업을 수행한다
        // 4. 큐에 카드가 1장 남으면 결과를 출력한다

        // try-with-resources로 Buffer를 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 카드의 개수 입력받기
            int number = Integer.parseInt(br.readLine());

            // 카드 숫자를 담을 큐 생성
            Queue<Integer> queue = new LinkedList<>();

            // 결과값을 저장할 배열 생성
            int result[] = new int[number];

            // 큐에 숫자 추가
            for(int i=1; i<=number; i++){
                queue.add(i);
            }

            // 배열 인덱스를 관리할 변수
            int i=0;

            // 큐에 카드가 한 장 남을 때까지 반복
            while(queue.size()!=1){
                // 1. 첫 번째 카드 버리기
                result[i] = queue.poll();
                // 2. 두 번째 카드 뒤로 빼기
//                int x = queue.poll();
//                queue.add(x);
                queue.add(queue.poll());
                i++;
            }

            // 결과값 출력
            for(i=0; i<number-1; i++){
                System.out.print(result[i]+" ");
            }
            // 큐에 남은 숫자 출력
            System.out.println(queue.poll());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
