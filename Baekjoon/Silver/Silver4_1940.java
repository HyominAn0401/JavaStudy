package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_1940 {
    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 투 포인터를 이용해 합이 M이 되는 개수를 출력한다
        // 로직 설계
        // 1. N, M을 입력받고 N 크기의 배열을 생성한다.
        // 2. 배열에 숫자를 저장한다.
        // 3. 투 포인터를 이용해 배열 내 두 숫자의 합이 M이 되는 개수를 출력한다.

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M 입력받기
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            // 숫자를 저장할 N 크기의 배열 생성
            int [] weigh = new int[N];
            // 배열에 숫자 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                weigh[i] = Integer.parseInt(st.nextToken());
            }

            // 갑옷을 만들 수 있는 개수를 저장할 변수 초기화
            int cnt = 0;

            // 합이 M이면 cnt 증가
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    if(weigh[i] + weigh[j] == M)
                        cnt++;
                }
            }

            // 결과값 출력
            System.out.println(cnt);
        }
    }
}
