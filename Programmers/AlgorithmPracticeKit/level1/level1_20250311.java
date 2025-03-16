package AlgorithmPracticeKit.level1;

import java.util.*;

public class level1_20250311 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 배열에서 연속적으로 나오는 숫자 제거하고 남은 수 배열로 리턴하기
        // 로직 설계
        // 1. 큐를 생성하고 배열의 가장 첫 번째 수 큐에 넣기
        // 2. 배열의 크기가 1보다 큰 경우 각 배열의 수를 탐색해 바로 이전 수와 다른 값이면 큐에 추가한다.
        // 3. 큐의 값들을 result 배열에 추가해 반환한다.

        // 예제 배열값
        int [] arr = {4,4,4,3,3};

        // 리턴할 배열
        int [] answer = Solution(arr);

    }

    // 연속적으로 나타나는 수 제외하고 남은 수 리턴하는 함수
    public static int [] Solution(int [] arr){
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        // 배열의 첫 번째 값 큐에 저장
        queue.add(arr[0]);

        // last 변수에 첫 번째 값 저장
        int last = arr[0];

        // 배열의 크기가 1보다 큰 경우
        if(arr.length > 1){
            // 배열 길이만큼 반복
            for(int i=1; i<arr.length; i++){
                // 바로 이전 값과 다른 값인 경우
                if(arr[i] != last)
                    // 큐에 추가
                    queue.add(arr[i]);
                // 최신값 업데이트
                last = arr[i];
            }
        }

        // 큐에 저장된 값의 개수 크기의 배열 생성
        int [] result = new int[queue.size()];
        // 인덱스
        int i=0;
        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 배열의 큐에서 뺀 값 저장
            result[i] = queue.poll();
            i++;
        }

        // 배열 리턴
        return result;
    }
}
