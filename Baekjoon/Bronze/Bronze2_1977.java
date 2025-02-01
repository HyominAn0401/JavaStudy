package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze2_1977 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : M이상 N 이상 수에서 완전제곱수인 수의 합과 최솟값 출력
        // 로직 설계
        // 1. M, N 입력받고 최솟값과 합을 저장할 변수 초기화
        // 2. M이상 N 이하 수에서 완전제곱수면 누적합 계산 및 최솟값 저장
        // 3. sum이 0이 아니면 합과 최솟값 출력, 아니면 -1 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // M, N 입력받기
            int M = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            // 최솟값을 저장할 변수 초기화
            int minValue = Integer.MAX_VALUE;
            // 합을 저장할 변수 초기화
            int sum = 0;

            // 완전제곱수를 위한 변수 i, 1부터 시작
            int i =1;
            // 반복
            while(true){
                // 완전제곱수
                int num = i*i;
                // N보다 값이 커지면 반복문 종료
                if(num > N) break;
                // 조건 내에 있으면
                if(num >= M){
                    // 완전제곱수 누적
                    sum += num;
                    // 최솟값 비교
                    minValue = Math.min(minValue, num);
                }
                // i값 증가
                i++;
            }

            // 합이 0이 아니면 출력
            if(sum!=0)  System.out.println(sum+"\n"+minValue);
            // 0이면 -1 출력
            else System.out.println(-1);
        }
    }
}
