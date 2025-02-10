package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Gold5_13164 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 가장큰키-가장작은키가 비용일 때, 비용을 최소화하는 K개 조로 나눌 때 비용 구하기
        // 로직 설계
        // 1. N, K값을 입력받고 N, N-1 크기의 키 배열과 키차이 배열을 생성한다
        // 2. 배열에 값을 저장한다. 키차이의 총합도 계산한다.
        // 3. 키차이 총합에서 가장 차이가 큰 K-1개의 차이를 뺀 결과를 출력한다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, K 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 키 저장 배열
            int [] length = new int[N];
            // 키차이 저장 배열
            Integer [] lengthGap = new Integer[N-1];
            // 키차이 총합을 저장할 변수
            long sum = 0;

            // 배열에 값 입력
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                // 키값 입력받기
                length[i] = Integer.parseInt(st.nextToken());
                // i가 1 이상이면 키차이 배열에 값 저장
                if(i>=1){
                    lengthGap[i-1] = length[i]-length[i-1];
                    // 총합 구하기
                    sum += lengthGap[i-1];
                }
            }

            // 내림차순 정렬
            Arrays.sort(lengthGap, Collections.reverseOrder());
            // 총합에서 K-1개의 큰 키차이 값 빼기
            for(int i=0; i<K-1; i++){
                sum -= lengthGap[i];
            }

            // 결과 출력
            System.out.println(sum);

        }
    }
}
