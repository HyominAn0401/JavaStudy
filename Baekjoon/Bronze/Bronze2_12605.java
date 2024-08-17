package Bronze;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bronze2_12605 {
    public static void main(String[] args) throws IOException{

        // 구현 및 해야할 것 : 케이스 별 단어 순서 뒤집어서 출력하기
        // 로직 설계
        // 1. 케이스 입력받고 해당 크기의 배열 생성
        // 2. 공백 기준으로 문자열 분리해 스택에 추가
        // 3. 스택에서 pop하기

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 케이스 개수 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과를 저장할 케이스 크기의 배열 생성
            String[] caseStr = new String[testCase];

            // 케이스 만큼 반복
            for(int i=0; i<testCase; i++){
                // 스택과 StringBuilder 생성
                Stack<String> stack = new Stack<>();
                StringBuilder sb = new StringBuilder();

                // 문자열 입력받기
                String str = br.readLine();
                // 공백으로 단어 나눠 스택에 추가
                for(String word : str.split(" ")){
                    stack.push(word);
                }
                // 스택이 빌 때까지 StringBuilder 객체에 추가
                while(!stack.isEmpty()){
                    sb.append(stack.pop()+" ");
                }
                // 배열에 저장
                caseStr[i] = sb.toString();
            }

            // 결과값 출력 
            for(int i=0; i<testCase; i++){
                System.out.println("Case #"+(i+1)+": "+caseStr[i]);
            }
        }
    }
}
