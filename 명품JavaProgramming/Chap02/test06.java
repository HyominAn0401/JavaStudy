package Chap02;

import java.util.Scanner;

public class test06 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("1~99 사이의 정수를 입력하시오>>");
        int num = scanner.nextInt();

        int num_10 = num/10;
        int num_1 = num%10;

        if((num_10==3 || num_10==6 || num_10==9) || (num_1==3 || num_1==6 || num_1==9)){
            if((num_10==3 || num_10==6 || num_10==9) && (num_1==3 || num_1==6 || num_1==9)){
                System.out.println("박수짝짝");
            }
            else{
                System.out.println("박수짝");
            }
        }
        else{
            System.out.println("박수없음");
        }

        scanner.close();
    }
}
