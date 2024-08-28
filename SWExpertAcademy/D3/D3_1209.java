package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_1209 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 각 행의 합, 열의 합, 대각선 합 중 최댓값 출력하기
        // 로직 설계
        // 1. 각 합의 결과를 저장할 result 배열 생성 -> 2*100 + 대각선 합 2개 => 크기 202
        // 2. 2차원 배열에 숫자 입력받아 저장하기
        // 3. result 배열에 각 행과 열의 합 저장, i==j인 경우, i+j==99인 경우의 합 저장
        // 4. result 배열 정렬해 최대값 출력

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            // 결과를 저장할 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // 10번 반복
            for(int t=0; t<10; t++){
                // (왠지 모를) 숫자 입력받기
                int n = Integer.parseInt(br.readLine());
                // 100x100의 숫자를 저장할 이차원 배열 생성
                int [][] numbers = new int[100][100];
                // 각 합을 저장할 배열 생성
                int [] result = new int[202];

                // 이차원 배열에 숫자 저장
                for(int i=0; i<100; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for(int j=0; j<100; j++){
                        numbers[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                // 각 행의 합 열의 합 대각선의 합 구하기
                for(int i=0; i<100; i++){
                    for(int j=0; j<100; j++){
                        // 각 행의 합
                        result[i] += numbers[i][j];
                        // 각 열의 합
                        result[100+i] += numbers[j][i];

                        // 대각선의 합
                        if(i==j){
                            result[200]+= numbers[i][j];
                        }
                        // 역 대각선의 합
                        if(i+j==99)
                            result[201]+= numbers[i][j];
                    }
                }

                // 오름차순 정렬 정렬
                Arrays.sort(result);
                // sb에 최대값 저장
                sb.append("#"+(t+1)+" "+result[201]+"\n");

            }
            // 출력
            System.out.println(sb);
        }
    }
}
