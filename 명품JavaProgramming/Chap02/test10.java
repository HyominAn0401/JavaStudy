package Chap02;

import java.util.Scanner;

public class test10 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("첫번째 원의 중심과 반지름 입력>>");
        int centerX1 = scanner.nextInt();
        int centerY1 = scanner.nextInt();
        int radius1 = scanner.nextInt();

        System.out.print("두번째 원의 중심과 반지름 입력>>");
        int centerX2 = scanner.nextInt();
        int centerY2 = scanner.nextInt();
        int radius2 = scanner.nextInt();

        double distance = Math.sqrt((centerX1-centerX2)*(centerX1-centerX2)+(centerY1-centerY2)*(centerY1-centerY2));
        if ((radius1+radius2)<distance){
            System.out.println("두 원은 서로 겹치지 않는다.");
        }
        else System.out.println("두 원은 서로 겹친다.");

        scanner.close();
    }
}
