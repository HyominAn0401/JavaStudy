package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver4_1758 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 순서를 바꿔 팁의 최대값 구하기
        // 로직 설계
        // 1. N값 입력받아 N+1 크기의 두 개 배열 생성
        // 2. 배열에 값 저장
        // 3. 배열 내림차순 정렬(가장 팁이 높은 사람이 앞 순서로 가도록)
        // 4. 팁 - (등수-1) 값을 누적합한다. 값이 음수이면 더하지 않는다.
        // 5. 결과 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // N값 입력받기
            long N = Integer.parseInt(br.readLine());
            // 팁을 저장할 배열
            long [] tips = new long[(int)N+1];
            // 정렬해 저장할 배열
            long [] tipsReverse = new long[(int)N+1];

            // 배열에 값 저장
            for(int i=1; i<=N; i++){
                tips[i] = Long.parseLong(br.readLine());
            }

            // 오름차순 정렬
            Arrays.sort(tips);
            // 정렬에 사용할 변수
            int num=1;

            // 내림차순 정렬
            for(long i=N; i>=1; i--){
                tipsReverse[num] = tips[(int)i];
                num++;
            }
            // 결과값을 저장할 변수
            long maxValue = 0;
            for(int i=1; i<=N; i++){
                // 돈 - (등수 - 1)
                long value = tipsReverse[i] - (i-1);
                // 해당 값이 음수가 아니면
                if(value>0)
                    // 누적
                    maxValue += value;

            }
            // 결과값 출력
            System.out.println(maxValue);
        }
    }
}
