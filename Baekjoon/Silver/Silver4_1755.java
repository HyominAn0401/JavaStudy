package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver4_1755 {
//    static String [] strArray;
    // Number 객체 배열
    static Number [] numbersArray;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : M 이상 N 이하 정수를 숫자 하나씩 읽고 사전순으로 정렬해 출력하기
        // 로직 설계
        // 1. N, M값 입력받고 숫자와 영어문자열을 저장할 Number 객체 배열 초기화
        // 2. M이상 N이하 모든 정수에 대해 반복
        // 3. 숫자가 한 자리 수인 경우와 두 자리 수인 경우를 나눠 영어문자열 저장
        // 4. 객체 배열에 숫자와 영어문자열 저장 후 영어문자열 기준 사전 순서대로 정렬
        // 5. 한 줄에 10개씩 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // M, N 값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int length = N-M+1;
            //strArray = new String[length];
            // Number 객체 배열 초기화
            numbersArray = new Number[length];

            // 배열 index
            int order = 0;
            // M이상 N이하 숫자에 대해 반복
            while(M<=N){
                // 해당 인덱스에 M값 전달 후 메서드 실행
                numberToEng(M, order);
                // M, order 값 증가
                M++;
                order++;
            }

            // 영어 사전순으로 정렬
            Arrays.sort(numbersArray, (a, b) -> a.numberEnglish.compareTo(b.numberEnglish));

            // 한 줄에 10개씩 출력
            for(int i=0; i<numbersArray.length; i++){
                System.out.print(numbersArray[i].number+" ");
                if((i+1)%10==0) System.out.println();
            }

        }
    }



    // 숫자를 영어 String 으로 변경 후 배열에 저장
    static public void numberToEng(int M, int order){
        String str = "";
        // M이 한 자리 수인 경우
        if(M<10){
//            strArray[order] = switchCase(M, str);
            numbersArray[order] = new Number(M, switchCase(M, str));
        }
        // M이 두 자리 수인 경우
        else{
            // 십의 자리 수, 일의 자리 수 분해
            int [] num = {M/10, M%10};
            // 각 숫자에 대해 메서드 실행
            for(int x : num){
                str = switchCase(x, str);
            }
//            strArray[order] = str;
            // 최종 결과 배열에 저장
            numbersArray[order] = new Number(M, str);
        }
    }

    // 숫자에 대해 영어로 변경
    static public String switchCase(int M, String str){
        switch (M){
            case 0: str += "zero "; break;
            case 1: str += "one "; break;
            case 2: str += "two "; break;
            case 3: str +="three "; break;
            case 4: str += "four "; break;
            case 5: str += "five "; break;
            case 6: str += "six "; break;
            case 7: str += "seven "; break;
            case 8: str += "eight "; break;
            case 9: str += "nine "; break;
        }
        return str;
    }
}

// 숫자와 해당 숫자 영어를 저장할 Number 객체
class Number{
    int number;
    String numberEnglish;

    public Number(int number, String numberEnglish){
        this.number = number;
        this.numberEnglish = numberEnglish;
    }
}
