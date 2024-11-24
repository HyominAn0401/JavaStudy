package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver3_1448 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : N개 숫자 중 3개를 선택해 만들 수 있는 삼각형의 최대값 구하기
        // 로직 설계
        // 1. 삼각형 길이 배열에 받기
        // 2. 오름차순 정렬
        // 3. 최대값이 될 수 있는 숫자들 탐색
        // 4. 가장 큰 값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값 입력받고 해당 크기의 배열 생성
            int N = Integer.parseInt(br.readLine());
            int [] triangle = new int[N];

            // 값 저장
            for(int i=0; i<N; i++){
                triangle[i] = Integer.parseInt(br.readLine());
            }

            // 오름차순 정렬
            Arrays.sort(triangle);

            // maxValue 초기화
            int maxValue = Integer.MIN_VALUE;

            // 길이가 3이면
            if(N==3){
                maxValue = Math.max(maxValue, trianglePossible(triangle[0], triangle[1], triangle[2]));
            }
            // 3보다 크면
            else {
                // 최대값이 될 수 있는 모든 수에 대해 반복
                for (int i = N - 1; i >= 2; i--) {
                    // 각 상황별 가장 큰 값
                    int c = triangle[i];
                    int b = triangle[i - 1];
                    int a = triangle[i - 2];

                    // 최대값
                    maxValue = Math.max(maxValue, trianglePossible(a, b, c));
                }
            }
            // 결과 출력
            System.out.println(maxValue);
        }
    }

    // 삼각형 가능 여부 판단 메서드
    public static int trianglePossible(int a, int b, int c){
        // 삼각형이 가능하면 세 변의 길이의 합
        if((a+b)>c){
            return a+b+c;
        }
        // 불가능
        return -1;
    }
}
