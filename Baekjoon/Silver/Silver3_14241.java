package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_14241 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 슬라임 크기에 따라 슬라임 점수를 얻을 때 점수의 최댓값 구하기
        // 로직 설계
        // 1. N과 N 크기의 배열에 슬라임 크기 저장
        // 2. 슬라임 크기에 따라 점수 누적합을 구하고 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 슬라임 개수
            int N = Integer.parseInt(br.readLine());
            // 슬라임 크기 저장할 배열
            int [] slime = new int[N];

            // 슬라임 크기 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                slime[i] = Integer.parseInt(st.nextToken());
            }

            // 슬라임 크기 누적할 변수. 초깃값은 배열 첫 값
            int slimeSize = slime[0];
            // 점수를 저장할 변수
            int score = 0;
            // 점수 누적 전 값을 저장할 변수
            int sum = 0;

            // 배열 원소 탐색 반복문
            for(int i=1; i<=N-1; i++){
                // sum 변수에 슬라임 크기값 저장
                sum = slimeSize;
                // 슬라임 크기 누적
                slimeSize += slime[i];
                // 점수 누적
                score += (sum * slime[i]);
            }

            // 결과값 출력
            System.out.println(score);

        }
    }
}
