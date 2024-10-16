package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze3_10162 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : T를 정확히 맞추기 위해 A, B, C 횟수를 최소화하는 각 횟수 출력
        // 로직 설계
        // 1. T를 입력받고 A, B, C의 요리시간이 저장된 배열 생성
        // 2. T를 A, B, C(내림차순) 시간대로 나누고 나머지 값에 대한 계산 반복
        // 3. time이 0이면(T를 정확히 맞추면) 각 횟수 출력, 아니면 -1 출력

        try(BufferedReader br= new BufferedReader(new InputStreamReader(System.in))){
            // T 입력받기
            int T = Integer.parseInt(br.readLine());
            // A, B, C 저장
            int [] microwave = {300, 60, 10};
            // 결과를 저장할 StringBuilder 객체
            StringBuilder sb = new StringBuilder();

            // time 변수에 저장
            int time = T;
            // A, B, C 요리시간으로 나누기
            for(int i=0; i<3; i++){
                // 나눈 몫 저장
                int num = time/microwave[i];
                // sb에 추가
                sb.append(num+" ");
                // 나머지 값 저장
                time %= microwave[i];
            }

            // 값이 0이면
            if(time==0)
                System.out.println(sb);
            // 값이 0이 아니면 -1 출력
            else System.out.println(-1);
        }
    }
}
