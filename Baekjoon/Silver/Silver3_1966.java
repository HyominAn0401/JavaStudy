package Silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Silver3_1966 {

    public static void main(String[] args) {
        // 구현 및 해야할 것 : 큐에 숫자를 넣고 중요도가 높은 순으로 출력
        // 로직 설계
        // 1. 테스트 케이스와 각 케이스 결과값을 저장할 배열을 생성한다
        // 2. 각 테스트 케이스에서 N, M값을 입력받고 숫자를 저장할 큐와 인덱스를 저장할 큐를 생성한다
        // 3. 큐에 숫자를 저장하고, peek값을 제외한 나머지 숫자들 중 max 값을 구해 비교한다
        // 4. M 위치에 해당하는 숫자가 poll 될 경우 결과값을 배열에 저장하고 반복을 종료한다
        // 5. 각 테스트 케이스 결과값을 출력한다

        // try-with-resources로 Scanner 자원 관리
        try(Scanner scanner = new Scanner(System.in)){

            // 테스트 케이스 수 입력받기
            int testCase = scanner.nextInt();
            // 각 테스트 케이스 결과값을 저장할 배열
            int [] results = new int[testCase];

            // 테스트 케이스만큼 반복
            for(int t=0; t<testCase; t++) {

                // N과 M값 입력받기
                int N = scanner.nextInt();
                int M = scanner.nextInt();

                // 사용할 변수
                int x;

                // 중요도를 저장할 큐 생성
                Queue<Integer> queue = new LinkedList<Integer>();
                // 중요도의 인덱스를 저장할 큐 생성
                Queue<Integer> indexQueue = new LinkedList<Integer>();

                // 큐에 값 저장
                for (int i = 0; i < N; i++) {
                    x = scanner.nextInt();
                    queue.add(x);
                    indexQueue.add(i);
                }

                // 결과값을 저장할 변수
                int cnt = 0;

                // 작업을 반복
                while (true) {
                    // peek값 poll
                    x = queue.poll();
                    // 비교할 maxValue값 생성 및 초기화
                    int maxValue = Integer.MIN_VALUE;
                    // x 값 외 큐에 남은 숫자들 중 최대값 저장
                    for (int i = 0; i < queue.size(); i++) {
                        int y = queue.poll();
                        if (maxValue < y) maxValue = y;
                        queue.add(y);
                    }

                    // x < maxValue인 경우 : x가 최대값이 아닌 경우
                    if (x < maxValue) {
                        // 큐에 x 추가
                        queue.add(x);
                        // 인덱스 큐에 poll한 값 추가
                        indexQueue.add(indexQueue.poll());
                    }
                    // x >= maxValue인 경우 : x가 최대값인 경우
                    else {
                        // 인덱스 큐에서 peek값 poll
                        int index = indexQueue.poll();
                        // 결과값 +1
                        cnt++;
                        // index가 M값과 같은 경우 반복문 종료
                        if (index == M) {
                            break;
                        }
                    }
                }
                // 테스트 케이스 배열에 결과값 저장
                results[t] = cnt;
            }

            for(int result : results){
                System.out.println(result);
            }

//            while(!queue.isEmpty()){
//                x = queue.poll();
//                int maxValue = Integer.MIN_VALUE;
//                for(int i=0; i<queue.size(); i++){
//                    int y = queue.poll();
//                    if(maxValue <= y)   maxValue=y;
//                    queue.add(y);
//                }
//                System.out.println("max: "+maxValue);
//
//                if(x < maxValue){
//                    System.out.println("m<maxValue: "+x+"를 뒤에 추가");
//                    queue.add(x);
//                    if(M==0)    M = N-1;
//                    else M--;
//                    System.out.println(M);
//                }
//                else{
//                    System.out.println("x >= maxValue: "+x+"를 poll");
//                    M--;
//                    ptr++;
//                    System.out.println(M);
//                }
//            }

//            for(int i=0; i<N; i++){
//                x = queue.peek();
//                System.out.println("peek: "+x);
//                for(int j=0; j<N-1; j++){
//                    queue[i]
//                }
//                if(x < maxValue){
//                    queue.add(queue.poll());
//                    System.out.println("peek값을 뒤로 옮김");
//                    if(M==0)    M = N-1;
//                    else    M--;
//                    System.out.println("x < maxValue 일때 M: "+M);
//                }
//                else{
//                    int y = queue.poll();
//                    if(M==0)    break;
//                    else M--;
//                    System.out.println("x >= maxValue 일때 M: "+M);
//                }
//            }

            //System.out.println(ptr);
        }


    }
}
