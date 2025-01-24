package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Silver3_2149 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 키와 암호문을 입력받고 정렬해 평문 출력하기
        // 로직 설계
        // 1. 키, 암호문 입력받아 길이 저장
        // 2. 배열 높이를 구해 암호문 이차원 배열, 평문 이차원 배열 생성
        // 3. ArrayList에 Code 객체를 저장하고 문자 순서대로 정렬
        // 4. 암호문을 이차원 배열에 저장
        // 5. Code 객체의 인덱스를 저장한 배열을 탐색해 평문 이차원 배열 열 인덱스를 찾음
        // 6. 평문 이차원 배열 값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 키 입력받아 길이 저장
            String key = br.readLine();
            int keyLength = key.length();
            // 암호문 입력받고 길이 저장
            String cipher = br.readLine();
            int cipherLength = cipher.length();
            // 이차원 배열 생성에 사용할 행의 길이
            int width = cipherLength / keyLength;

            // 암호문을 저장할 문자 이차원 배열
            char [][] code = new char[width][keyLength];
            // 평문을 저장할 문자 이차원 배열
            char [][] newCode = new char[width][keyLength];
            // 암호 문자 배열화
            char [] keyCharArray = key.toCharArray();

            // Code를 저장하는 ArrayList 생성
            ArrayList<Code> codeArrayList = new ArrayList<>();
            // ArrayList에 Code(ch, index) 저장
            for(int i=0; i<keyLength; i++){
                codeArrayList.add(new Code(keyCharArray[i], i));
            }

            // 문자 기준으로 ArrayList 내 Code 정렬
            codeArrayList.sort(Comparator.comparing(Code::getCh));

            // 문자열 인덱스를 위한 변수
            int cnt = 0;

            // 이차원 배열에 암호문 분해해 저장
            for(int j=0; j<keyLength; j++){
                for(int i=0; i<width; i++){
                    code[i][j] = cipher.charAt(cnt);
                    cnt++;
                }
            }

            // 정렬된 키의 인덱스를 저장할 배열
            int [] keyIndex = new int[keyLength];
            // 배열에 정렬된 키 인덱스 저장
            for(int i=0; i<keyLength; i++){
                keyIndex[i] = codeArrayList.get(i).getIndex();
            }

            // 평문 배열 값 저장 위한 반복문
            for(int j = 0; j<keyLength; j++){
                // j값과 키 인덱스가 같은 경우의 인덱스 저장을 위한 변수
                int index = -1;
                for(int k=0; k<keyIndex.length; k++){
                    // 키 인덱스와 j값이 같을때 인덱스 찾기
                    if(j==keyIndex[k]){
                        index = k;
                        break;
                    }
                }
                // 평문 배열에 값 저장
                for(int i=0; i<width; i++){
                    newCode[i][j] = code[i][index];
                }
            }

            // 결과값 저장을 위한 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();
            // 평문 저장
            for(int i=0; i<newCode.length; i++){
                for(int j=0; j<newCode[0].length; j++){
                    sb.append(newCode[i][j]);
                }
            }
            // 출력
            System.out.println(sb);

        }
    }
}

// 문자와 인덱스를 가진 Code 클래스
class Code{
    private char ch;
    private int index;

    public Code(char ch, int index){
        this.ch = ch;
        this.index = index;
    }

    public char getCh() {
        return ch;
    }

    public int getIndex() {
        return index;
    }
}
