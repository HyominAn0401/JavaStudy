package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze2_2675 {

    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 각 테스트 케이스별 문자를 R번 반복해 출력하기
        // 로직 설계
        // 1. 테스트 케이스 입력받고 해당 크기의 배열 생성
        // 2. 각 테스트 케이스 별 반복 횟수 R과 문자열 S 입력받기
        // 3. StringBuilder 객체에 문자열 S를 R번 반복한 값을 추가하고 배열에 저장한다.
        // 4. 테스트 케이스 별 결과를 출력한다.

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스트 케이스 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 테스트 케이스 결과값을 저장할 배열 생성
            String [] strings = new String[testCase];
            // 테이스 케이스만큼 반복
            for(int i=0; i<testCase; i++){
                // StringTokenizer로 분해
                StringTokenizer st = new StringTokenizer(br.readLine());
                // 결과를 저장할 StringBuilder 생성
                StringBuilder sb = new StringBuilder();

                // 반복 횟수
                int N = Integer.parseInt(st.nextToken());
                // 문자열
                String word = st.nextToken();

                // 문자열 분해하기
                for(String s : word.split("")){
                    // StringBuilder 객체에 반복한 문자열 추가
                    for(int j=0; j<N; j++){
                        sb.append(s);
                    }
                }

                // 배열에 결과값 저장
                strings[i] = sb.toString();
            }

            // 결과값 출력
            for(int i=0; i<testCase; i++){
                System.out.println(strings[i]);
            }
        }
    }
}
