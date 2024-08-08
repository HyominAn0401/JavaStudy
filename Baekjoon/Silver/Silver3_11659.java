package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_11659 {
    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : N개의 수를 입력받아 i번째 부터 j번째 수까지 합을 M번 구하고 출력한다
        // 로직 설계
        // 1. N, M을 입력받고 N개의 수를 저장할 배열, M번 합을 저장할 배열, 구간합 배열을 생성한다.
        // 2. 0 인덱스 값을 0으로 초기화하고 N개의 수를 저장하면서 구간합 배열에 값을 저장한다.
        // 3. i와 j를 입력받고 M번 i부터 j까지 숫자의 합을 저장해 출력한다.

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // StringTokenizer로 N, M 분리
            StringTokenizer st = new StringTokenizer(br.readLine());
            // N과 M 입력받기
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // N+1크기의 배열(0번째 인덱스 고려) 생성
            int [] numbers = new int[N+1];
            // M번 합을 저장할 배열 생성
            int [] sum = new int[M];
            // N+1 크기의 배열 생성 -> 구간합 저장할 배열
            int [] S = new int[N+1];

            // 0번 인덱스 0으로 초기화
            numbers[0] = 0;
            S[0] = 0;

            // 숫자 입력받아 배열에 저장하기
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
                // 누적합 저장하기
                S[i] = numbers[i] + S[i-1];
            }

            // i, j 입력받기
            for(int t=0; t<M; t++){
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());

                // 구간 합 구하기
                sum[t] = S[j]-S[i-1];
            }

            // 출력
            for(int num : sum){
                System.out.println(num);
            }

        }
    }
}
