package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1_1157 {

    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 알파벳 단어 중 가장 많이 사용된 알파벳을 출력하기
        // 로직 설계
        // 1. 단어를 입력받아 대문자로 변환
        // 2. 단어를 알파벳으로 분해하고 해당 인덱스 배열값 증가
        // 3. 가장 큰 값의 알파벳 출력, 같은 값이 존재할 경우 ? 출력

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 알파벳 배열 초기화
            int [] alpha = new int[26]; //초기화

//            char ch = String.valueOf(br.readLine()).charAt(0);
//            int ch_int = ch-'A';
//            System.out.println(ch+" "+ch_int);

            // 알파벳 단어 입력받기
            String word = br.readLine();
            // 단어를 대문자로 변환하기
            word = word.toUpperCase();

            // 단어 분해하기
            for(String s : word.split("")){
                // 단어의 int 값 구하기
                int index = s.charAt(0)-'A';
                // 단어 인덱스의 배열값 증가
                alpha[index]++;
                //System.out.println(s+", "+(s.charAt(0)-'A'));
            }

            // 가장 큰 값을 비교할 변수 생성
            int max = Integer.MIN_VALUE;
            // 가장 큰 값이 있는 인덱스 위치를 저장할 변수
            int index_ch =0;
            // 가장 큰 배열값 구하기
            for(int i=0; i<alpha.length; i++){
                if(alpha[i] > max) {
                    max = alpha[i];
                    // 가장 큰 값의 인덱스 저장
                    index_ch = i;
                }
            }
            int num = 0;

            // 가장 큰 값의 개수 구하기
            for(int i=0; i<alpha.length; i++){
                if(max == alpha[i])
                    num++;
            }

            // 가장 큰 값이 1개보다 많은 경우
            if(num>1)
                // ? 출력하기
                System.out.println("?");
            // 그 외의 경우 알파벳 출력
            else System.out.println((char)(index_ch+'A'));
        }
    }
}
