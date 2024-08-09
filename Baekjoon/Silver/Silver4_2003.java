package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_2003 {
    static int [] A;
    static int [] S;

    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 수의 개수와 합 M을 입력받아 배열 내에서 합이 M이 되는 경우의 수를 출력하기
        // 로직 설계
        // 1. N과 M 입력받기
        // 2. N+1 크기로 숫자를 저장할 배열, 누적 합을 저장할 배열을 생성한다.
        // 3. 수를 입력받아 배열에 저장하고 누적 합을 저장한다.
        // 4. start, end 포인터를 초기화한다.
        // 5. start와 end 값이 N을 넘지 않을 때까지 반복한다.
        // 5-1. 누적 합이 M과 같으면 cnt를 증가시키고 start를 증가시킨다.
        // 5-2. 누적 합이 M보다 작으면 end값을 증가시킨다.
        // 5-3. 누적 합이 M보다 크면 start값을 증가시킨다.
        // 6. 반복문이 종료되면 cnt 값을 출력한다.

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N과 M 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 숫자를 저장할 배열 생성
            A = new int[N+1];
            // 누적 합 배열 생성
            S = new int[N+1];

            // 배열에 숫자 저장 및 누적합 저장
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                A[i] = Integer.parseInt(st.nextToken());
                S[i] = A[i]+S[i-1];
            }

            // 투 포인터 생성 및 초기화
            int start=1, end=1;
            // 결과값을 저장할 변수 생성
            int cnt= 0;

            // start와 end값이 N을 넘지 않을 때까지 반복
            while(start<=N && end<=N){
                // 누적 합이 M인 경우
                if((S[end]-S[start-1])==M){
                    // cnt와 start값 증가
                    cnt++;
                    start++;
                }
                // 누적 합이 M보다 작은 경우
                else if((S[end]-S[start-1])<M)
                    // end값 증가
                    end++;
                // 누적 합이 M보다 큰 경우
                else if((S[end]-S[start-1])>M){
                    // start 값 증가
                    start++;
                }
            }

            // 결과값 출력
            System.out.println(cnt);
        }
    }
}
