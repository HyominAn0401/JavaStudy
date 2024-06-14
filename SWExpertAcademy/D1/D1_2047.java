package D1;

import java.util.Scanner;

public class D1_2047 {

    public static void main(String[] args) {

        // 구현 및 해야할 것 : 문자열을 입력받아 대문자로 변화해 출력하기
        // 로직 설계
        // 1. 문자열 입력받기
        // 2. 대문자로 변환하고 출력하기
        Scanner scanner = new Scanner(System.in);

        // 문자열 입력받기 
        String word = scanner.nextLine();
        // 대문자로 변환 후 출력
        System.out.println(word.toUpperCase());

        scanner.close();
    }
}
