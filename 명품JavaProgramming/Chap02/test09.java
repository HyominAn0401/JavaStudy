package Chap02;

import java.util.Scanner;

public class test09 {

    public static void main(String[] ars){

        Scanner scanner = new Scanner(System.in);

        System.out.print("원의 중심과 반지름 입력>>");
        double centerX = scanner.nextDouble();
        double centerY = scanner.nextDouble();
        double radius = scanner.nextDouble();

        System.out.print("점 입력>>");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        double distance = Math.sqrt(((centerX-x)*(centerX-x))+((centerY-y)*(centerY-y)));

        if(distance <= radius){
            System.out.println("점 ("+x+", "+y+")는 원 안에 있다.");
        }
        else{
            System.out.println("점 ("+x+", "+y+")는 원 안에 없다.");
        }

        scanner.close();
    }
}
