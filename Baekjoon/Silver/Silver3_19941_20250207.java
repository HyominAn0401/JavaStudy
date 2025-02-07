package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver3_19941_20250207 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 거리가 K 이내인 햄버거를 선택할 수 있는 최대 사람의 수 출력하기
        // 로직 설계
        // 1. N, K를 입력받고 H와 P의 인덱스를 저장할 큐 생성
        // 2. H와 P에 따른 인덱스 큐에 저장하기
        // 3. 두 큐 중 하나가 빌 때까지 반복
        // 4. 사람 큐 원소값과 햄버거 큐 원소값 차의 절대값이 K 이하면 두 큐에서 poll 및 count 값 증가
        // 5. 아닌 경우 값이 음수면 사람큐, 양수면 햄버거 큐에서 poll
        // 6. 결과값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, K값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 햄버거와 사람의 인덱스를 저장할 큐 생성
            Queue<Integer> hamburgers = new LinkedList<>();
            Queue<Integer> people = new LinkedList<>();

            // 큐에 인덱스 저장
            String line = br.readLine();
            for(int i=0; i<N; i++){
                char ch = line.charAt(i);
                if(ch=='H') hamburgers.add(i);
                if(ch=='P') people.add(i);
            }

            // 결과값을 저장할 변수 초기화
            int count = 0;

            // 반복
            while(true){
                // 두 큐 중 하나의 큐가 비면 종료
                if(people.isEmpty() || hamburgers.isEmpty())
                    break;

                // 차의 절댓값이 K 이하인 경우 조건을 충족
                // 각 큐에서 poll, count 증가
                if(Math.abs(people.peek() - hamburgers.peek()) <= K){
                    people.poll();
                    hamburgers.poll();
                    count++;
                }
                // 거리가 K를 초과하는 경우
                else{
                    if(people.peek() - hamburgers.peek() < 0){
                        people.poll();
                    }
                    else {
                        hamburgers.poll();
                    }
                }
            }

            // 결과 출력
            System.out.println(count);
        }
    }
}
