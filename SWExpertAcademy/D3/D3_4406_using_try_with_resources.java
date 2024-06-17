package D3;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_4406_using_try_with_resources {

    public static void main(String[] args) {

        // 구현 및 해야할 것 : 테스트 케이스 별 입력된 문자열에서 모음인 문자를 제외하고 출력하기
        // 로직 설계
        // 1. 테스트 케이스 입력받고 2-3단계를 반복하기
        // 2. 문자열 입력받아 개별 문자로 분해하기
        // 3. 문자가 모음이 아닌 경우만 문자 배열에 저장
        // 4. 배열에 빈 값이 있는 경우를 제외하고 문자 출력하기

        // try-with-resources를 이용해 Scanner 인스턴스 자동 관리
        try(Scanner scanner = new Scanner(System.in)){
            // 테스트 케이스 입력받기
            int testCase = scanner.nextInt();
            // 모음을 제거한 문자들을 저장할 배열
            char [][] wordsWithoutVowel = new char[testCase][];
            // 다음 줄 입력을 위한 줄바꿈
            String blank = scanner.nextLine();

            // 테스트 케이스만큼 반복하는 for문
            for(int i=0; i<testCase; i++) {
                // 문자열 입력받기
                String word = scanner.next();
                // 모음이 제거된 문자들 저장할 배열 초기화
                char[] wordWithoutVowel = new char[word.length()];

                // 문자열의 각 문자를 검사하는 for문
                for (int j = 0; j < word.length(); j++) {
                    // 현재 문자
                    char currentChar = word.charAt(j);
                    // 현재 문자가 모음이 아닌 경우 배열에 저장
                    if (currentChar != 'a' && currentChar != 'e' && currentChar != 'i' && currentChar != 'o' && currentChar != 'u') {
                        wordWithoutVowel[j] = currentChar;
                    }
                }
                // 배열 저장
                wordsWithoutVowel[i] = wordWithoutVowel;
            }

            // 결과 출력하는 for문
            for(int i=0; i<testCase; i++){
                System.out.print("#"+(i+1)+" ");
                for(int j=0; j<wordsWithoutVowel[i].length;j++){
                    // 배열에서 빈 값 무시
                    if(wordsWithoutVowel[i][j]==0)  continue;
                    // 배열에서 출력
                    System.out.print(wordsWithoutVowel[i][j]);
                }
                System.out.println();
            }
        }
    }
}
