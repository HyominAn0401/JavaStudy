package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver5_5426 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 문자열을 이차원 배열 내 오른쪽을 90도 회전 및 거꾸로 출력한다
        // 로직 설계
        // 1. 각 테스트 케이스 별 문자열을 입력받고 길이의 제곱근 크기의 이차원 배열을 생성한다.
        // 2. 이차원 배열에 문자열을 char로 변환해 값을 저장한다.
        // 3. 같은 크기의 char 이차원 배열을 생성하고 90도 회전하게끔 배열에 저장한다.
        // 4. 해당 배열에서 거꾸로 출력한 값을 stringbuilder 객체에 저장한다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스트 케이스 입력 받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과값을 저장할 StringBuilder 객체
            StringBuilder result = new StringBuilder();
            // 테스트 케이스만큼 반복
            for(int t=0; t<testCase; t++){
                // 문자열 입력받기
                String str = br.readLine();
                // 문자열 길이 제곱근
                int length = (int)Math.sqrt(str.length());
                // 문자열 길이 제곱근 크기의 이차원 배열 생성 -> 문자열 문자값 저장
                char [][] letter = new char[length][length];
                // 문자열 인덱스를 위한 변수
                int cnt = 0;
                // 이차원 배열에 문자 저장
                for(int i=0; i<length; i++){
                    for(int j=0; j<length; j++){
                        letter[i][j] = str.charAt(cnt);
                        cnt++;
                    }
                }

                // 같은 크기의 90도 회전한 값들을 저장할 이차원 배열 생성
                char [][] rotate = new char[length][length];
                // 문자값 저장
                for(int i=0; i<length; i++){
                    int m = 0;
                    for(int j=length-1; j>=0; j--){
                        rotate[i][m] = letter[j][i];
                        m++;
                    }
                }

                // 테스트 케이스 별 결과값을 저장할 StringBuilder 객체
                StringBuilder sb = new StringBuilder();
                // 거꾸로 출력
                for(int i=length-1; i>=0; i--){
                    for(int j=length-1; j>=0; j--){
                        sb.append(rotate[i][j]);
                    }
                }

                // 최종 stringbuilder 객체에 저장
                result.append(sb.toString()+"\n");

            }
            // 결과값 출력
            System.out.print(result);
        }
    }
}
