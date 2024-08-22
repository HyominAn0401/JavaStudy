package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver4_11399 {
    public static void main(String[] args) throws IOException {
        // 구현 및 해야할 것 : 모든 사람들이 돈을 인출하는 데 필요한 시간합의 최솟값
        // 로직 설계
        // 1. N을 입력받고 각 시간과 누적합을 저장할 배열을 생성한다.
        // 2. 시간을 오름차순으로 정렬하고 누적합을 계산한다.

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N 입력받고 N+1 크기의 시간 저장 배열, 누적합 저장 배열 생성
            int N = Integer.parseInt(br.readLine());
            int [] time = new int[N+1];
            int [] prefixSum = new int[N+1];

            // 배열에 시간 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                time[i] = Integer.parseInt(st.nextToken());
            }

            // 오름차순 정렬
            Arrays.sort(time);

            // 시간합의 최솟값을 저장할 변수
            int minimumTime = 0;

            // 누적합 저장 및 모든 사람들이 인출하는 데 필요한 시간 최솟값 구하기
            for(int i=1; i<=N; i++){
                prefixSum[i] = prefixSum[i-1] + time[i];
                minimumTime += prefixSum[i];
            }

            // 출력 
            System.out.println(minimumTime);
        }
    }
}
