package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver5_2669 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : A, B의 이름을 입력받아 알파벳 획순으로 궁합 구하기
        // 로직 설계
        // 1. A, B 이름을 입력받고 한 글자씩 번갈아 char 배열에 저장한다.
        // 2. 각 알파벳의 획순을 구해 배열에 저장한다.
        // 3. 반복문에서 획순을 더해 저장하고 획순이 10이상이면 10을 빼고 저장한다.
        // 4. 배열 1, 2번째 인덱스 값을 출력한다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 이름 입력받기
            String him = br.readLine();
            String her = br.readLine();
            // char 배열로 저장
            char [] hisName = him.toCharArray();
            char [] herName = her.toCharArray();
            // 배열의 길이
            int length = her.length();

            // 두 명의 이름을 번갈아 합친 것을 저장하기 위한 배열 생성
            char [] names = new char[length*2];
            // 획순 저장할 배열 생성
            int [] match = new int[length*2];

            // 배열에 두 명 이름을 번갈아 저장
            for(int i=0; i<length; i++){
                names[i*2] = hisName[i];
                names[i*2+1] = herName[i];
            }

            // 각 문자의 획순 저장
            for(int i=0; i<length*2; i++){
                match[i] = getStrokes(names[i]);
            }

            // 반복문으로 획순 더하기
            for(int i=0; i<names.length-2; i++){
                for(int j=0; j<names.length-1-i; j++){
                    int sum = match[j] + match[j+1];
                    // 합이 10 이상이면 10 빼고 저장
                    if(sum >= 10)   sum -= 10;
                    match[j] = sum;
                }
            }

            // 결과값 저장을 위한 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();
            // 배열 인덱스 첫 번째, 두 번째 값 sb 객체에 저장
            for(int i=0; i<2; i++){
                sb.append(match[i]);
            }
            // 결과값 출력
            System.out.println(sb.toString());
        }
    }

    // 알파벳 획순을 반환하는 메서드
    public static int getStrokes(char ch){
        switch (ch){
            case 'C': case 'L': case 'O': case 'S': case 'U': case 'V': case 'W': case 'Z':
                return 1;
            case 'B': case 'D': case 'G': case 'J': case 'K': case 'M': case 'N': case 'P': case 'Q': case 'R': case 'T': case 'X': case 'Y':
                return 2;
            case 'A': case 'E': case 'F': case 'H': case 'I':
                return 3;
        }
        return -1;
    }
}
