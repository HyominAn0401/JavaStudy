package Chap02;

import java.util.Scanner;

public class test05 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 3개 입력>>");
        int side1 = scanner.nextInt();
        int side2 = scanner.nextInt();
        int side3 = scanner.nextInt();

        int max = (side1>side2)?side1:side2;
        max = (max>side3)?max:side3;

        int sum = side1+side2+side3;

        if(max < (sum-max)){
            System.out.println("삼각형이 됩니다.");
        }
        else{
            System.out.println("삼각형이 될 수 없습니다.");
        }

        scanner.close();
    }
}
