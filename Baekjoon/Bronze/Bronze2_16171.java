package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze2_16171 {

    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 문자열 S와 K를 입력받고 S에서 숫자를 제외했을 때 K가 S 내에 존재하면 1, 아니면 0을 출력한다.
        // 로직 설계
        // 1. 문자열 S와 K를 입력받는다.
        // 2. StringBuilder를 생성하고, S를 StringTokenizer 토큰으로 나눈다.
        // 3. 해당 토큰이 숫자가 아니라면 sb에 추가한다.
        // 4. sb에 K가 존재하면 1, 아니면 0을 출력한다.

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 문자열 S, K 입력받기
            String S = br.readLine();
            String K = br.readLine();

            // StringBuilder 생성
            StringBuilder sb = new StringBuilder();

            // StringTokenizer 생성
            StringTokenizer st;
            // 각 토큰이 숫자인지 검사
            for(int i=0; i<S.length(); i++){
                // 문자열 S를 토큰으로 분리
                st  = new StringTokenizer(S);
                // 토큰을 char 로 형변환
                char ch = st.nextToken().charAt(i);
                // 해당 토큰이 숫작 아닌 경우(문자인 경우(
                if(!Character.isDigit(ch)){
                    // sb에 추가
                    sb.append(ch);
                }
            }

            // sb 내에 문자열 K가 포함된 경우
            if(sb.toString().contains(K)){
                System.out.println(1);
            }
            // 포함되지 않은 경우
            else{
                System.out.println(0);
            }
        }
    }
}
