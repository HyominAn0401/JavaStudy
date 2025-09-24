package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_2559_20250924{
    public static void main(String args[])  throws Exception{
        // 구현 및 해야할 것 : 수열에서 연속 K개 최대합 출력하기
        // 로직 설계
        // 1. 수열을 저장 및 prefix 배열에 누적합 저장
        // 2. K부터 N까지 K개 간격에 따른 최대합 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, K값
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 온도를 저장할 배열 초기화
            int [] numArray = new int[N];
            // 누적합을 저장할 배열
            int [] prefix = new int[N+1];

            // 수열 저장
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numArray[i] = Integer.parseInt(st.nextToken());
                // 누적합 저장
                prefix[i+1] = prefix[i] + numArray[i];
            }

            int answer = Integer.MIN_VALUE;
            // 간격별 최대값
            for(int i=K; i<N+1; i++){
                int sum = prefix[i] - prefix[i-K];
                answer = Math.max(sum, answer);
            }

            System.out.println(answer);
        }
    }
}
