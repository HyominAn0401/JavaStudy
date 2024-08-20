package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver5_9237 {
    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 가장 빠르게 묘목을 심어 다음날 이장을 초대할 수 있는 날짜 출력하기
        // 로직 설계
        // 1. 묘목 수와 자라는 일 입력받기
        // 2. 내림차순 정렬하기
        // 3. 마지막 나무를 심었을 때 남은 일수를 확인하고 계산해 출력하기

        // BufferedReader
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 묘목 개수와 해당 크기의 배열 생성
            int N = Integer.parseInt(br.readLine());
            Integer [] trees = new Integer[N];

            // 묘목 자라는 날수 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                trees[i] = Integer.parseInt(st.nextToken());
            }

            // 내림차순 정렬
            // 가장 오래 걸리는 묘목 먼저 심기 위함
            Arrays.sort(trees, Collections.reverseOrder());

            // 가장 오래 걸리는 묘목 날수 저장하기 위한 변수 생성
            int maxValue = Integer.MIN_VALUE;

            // 마지막 묘목을 심었을 때 남은 일 확인
            for(int i=0; i<N; i++){
                trees[i] = trees[i] - (N -1 - i);
                // 큰 값 저장
                if(trees[i] > maxValue)
                    maxValue = trees[i];
            }

            // 계산 후 출력
            int days = N + maxValue + 1;
            // int days = N + (maxValue - minValue) + minValue + 1;
            System.out.println(days);
        }
    }
}
