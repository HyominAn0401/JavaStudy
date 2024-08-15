package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_21921 {
    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : N과 X를 입력받아 X 기간동안 최대 방문자 수를 출력한다
        // 로직 설계
        // 1. N, X를 입력받고 N크기의 배열을 생성해 숫자를 저장한다.
        // 2. 초기 윈도우 내 합을 구한다.
        // 3. 윈도우를 슬라이딩 시키면서 최대값을 구한다. 최대값이 여러 번 나오면 cnt 값을 증가시킨다.
        // 4. 최대값이 0이 아니면 최대값과 cnt 값을 출력하고 0이면 SAD를 출력한다.

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, X 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long X = Long.parseLong(st.nextToken());

            // 숫자를 저장할 배열 생성
            long [] visitors = new long[(int)N];

            // 합, 최대값, 개수를 저장할 변수 초기화
            long sum = 0;
            long maxValue = 0;
            int cnt = 0;

            // 배열에 숫자 저장
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                visitors[i] = Long.parseLong(st.nextToken());
            }

            //초기 윈도우
            for(int i=0; i<X; i++){
                sum += visitors[i];
            }
            // 최대값 저장 및 cnt값 1로 초기화
            maxValue = sum;
            cnt = 1;

            // 슬라이딩 윈도우
            for(int i=(int)X; i<N; i++){
                // 앞의 값 +, 뒤의 값 -
                sum += visitors[i];
                sum -= visitors[i-(int)X];
                // 현재 최대값보다 크면 업데이트
                if(maxValue < sum) {
                    maxValue = sum;
                    cnt = 1;
                }
                // 최대값이 또 나오면 cnt값 증가
                else if(maxValue == sum)
                    cnt++;
            }

            // 최대값이 0이 아니면 최대값과 cnt 출력
            if(maxValue != 0){
                System.out.println(maxValue+"\n"+cnt);
            }
            // 0이면 SAD 출력
            else{
                System.out.println("SAD");
            }
        }
    }
}
