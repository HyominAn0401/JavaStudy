package Silver;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Silver2_1927 {
    public static void main(String[] args) {
        // 구현 및 해야할 것 : 연산 개수를 입력받고 최소 힙을 이용해 결과값 배열에 저장해 출력한다
        // 로직 설계
        // 1. 연산 개수 입력받고 최소 힙, 결과값을 저장할 배열 생성
        // 2. 값이 0보다 크면 최소 힙에 추가, 0이면 최소 힙에서 가장 작은 값을 결과 배열에 저장하고 삭제, 힙이 비어 있으면 0을 저장
        // 3. 결과값을 출력

        // try-with-resources로 Scanner 관리
        try(Scanner scanner = new Scanner(System.in)){
            // 연산 개수 입력받기
            int numbers = scanner.nextInt();

            // 우선순위 큐로 최소 힙 생성
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            // 결과값을 저장할 배열
            int [] results = new int[numbers];
            // 배열의 인덱스를 저장할 변수
            int index = 0;

            // numbers 만큼 반복할 for문
            for(int i=0; i<numbers; i++){
                int x = scanner.nextInt();
                // x가 0보다 크면 최소 힙에 추가
                if(x>0) minHeap.add(x);
                // x가 0일때
                else if(x==0){
                    // 빈 힙이면 0을 저장
                    if(minHeap.isEmpty()){
                        results[index] = 0;
                        index++;
                    }
                    // 비어있지 않으면 가장 작은 값을 배열에 저장하고 제거
                    else {
                        results[index] = minHeap.poll();
                        index++;
                    }
                }
            }

//            for(int result : results){
//                System.out.println(result);
//            }
            // 결과값 출력
            for(int i=0; i<index; i++){
                System.out.println(results[i]);
            }
        }
    }
}
