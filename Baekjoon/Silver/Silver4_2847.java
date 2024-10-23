package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver4_2847 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 가장 높은 레벨값이 가장 큰 점수를 갖도록 다른 점수를 감소시킬 때 최소한의 감소 횟수
        // 로직 설계
        // 1, 배열에 점수 저장
        // 2. 가장 높은 레벨값 기준으로 잡기
        // 3. 높은 레벨에서 레벨 1까지 탐색
        //    각 단계에서 가장 최적의 선택 : 가능한 최대값-1값으로 조정
        // 4. 감소 횟수 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값 입력받기
            int N = Integer.parseInt(br.readLine());
            // 값을 저장할 배열
            int [] point = new int[N];
            // 배열에 값 저장
            for(int i=0; i<N; i++){
                point[i] = Integer.parseInt(br.readLine());
            }
            // 가장 높은 레벨 점수 기준
            int maxValue = point[N-1];
            // 감소 횟수를 저장할 변수
            int cnt = 0;

            // N-2번째 레벨부터 반복
            for(int i=N-2; i>=0; i--){
                // 최적의 선택 기준값 => 최대값-1
                int maxValueMinus = maxValue-1;
                // 현재 값이 최대값-1보다 크면
                if(point[i] > maxValueMinus){
                    // 감소 횟수 누적
                    cnt += point[i] - maxValueMinus;
                    // 현재 값에 최대값-1 저장
                    point[i] = maxValueMinus;
                }
                // 최대값에 현재 값
                maxValue = point[i];
            }
            // 결과값 출력
            System.out.println(cnt);
        }
    }
}
