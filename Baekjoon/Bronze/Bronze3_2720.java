package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze3_2720 {
    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 테스트 케이스 별 최소한의 거스름돈 개수 출력하기
        // 로직 설계
        // 1. 테스트 케이스를 입력받고 해당 크기의 결과를 저장할 배열 생성
        // 2, 쿼터, 다임, 니켈, 페니를 저장한 배열과 해당 동전의 개수를 저장할 배열 생성
        // 3. 그리디로 거스름돈의 개수 저장 후 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스트 케이스 입력받고 결과 저장할 배열 생성
            int testCase = Integer.parseInt(br.readLine());
            String [] result = new String[testCase];

            // 테스트 케이스 별 반복
            for(int t=0; t<testCase; t++){
                // 각 결과를 저장할 StringBuilder 객체 생성
                StringBuilder sb = new StringBuilder();

                // 거스름돈 입력받기
                int charge = Integer.parseInt(br.readLine());
                // 거스름돈 배열
                int [] cents = {25, 10, 5, 1};
                // 각 동전 별 개수를 저장할 배열
                int [] centsCnt = new int[4];

                // 4번 반복하면서 그리디 알고리즘 실행
                for(int i=0; i<4; i++){
                    // 거스름돈이 센트보다 크거나 같은 경우
                    if(charge >= cents[i]){
                        // 개수 저장
                        centsCnt[i] += charge/cents[i];
                        // 나머지 저장
                        charge %= cents[i];
                    }
                    sb.append(centsCnt[i]+" ");
                }

                // 배열에 테스트 케이스 결과값 저장
                result[t] = sb.toString();
            }

            // 출력
            for(String sb : result){
                System.out.println(sb);
            }
        }
    }
}
