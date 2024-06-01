package Chap02;

import java.util.Scanner;

public class test12 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //(1) if-else
//        double result = 0;
//
//        System.out.print("연산>>");
//        double first = scanner.nextDouble();
//        String op = scanner.next();
//        double second = scanner.nextDouble();
//
//        if(op.equals("+")){
//            result = first + second;
//            System.out.println(first+op+second+"의 계산 결과는 "+result);
//        } else if (op.equals("-")) {
//            result = first - second;
//            System.out.println(first+op+second+"의 계산 결과는 "+result);
//        } else if (op.equals("*")) {
//            result = first * second;
//            System.out.println(first+op+second+"의 계산 결과는 "+result);
//        } else if (op.equals("/")) {
//            if(first == 0 || second == 0)
//                System.out.println("0으로 나눌 수 없습니다.");
//            else {
//                result = first / second;
//                System.out.println(first + op + second + "의 계산 결과는 " + result);
//            }
//        }

        //(2) switch
        System.out.print("연산>>");
        double first = scanner.nextDouble();
        String op = scanner.next();
        double second = scanner.nextDouble();

        switch (op){
            case "+":
                System.out.println(first + op + second + "의 계산 결과는 " + (first+second));
                break;
            case "-":
                System.out.println(first + op + second + "의 계산 결과는 " + (first-second));
                break;
            case "*":
                System.out.println(first + op + second + "의 계산 결과는 " + (first*second));
                break;
            case "/":
                if(first ==0 || second ==0){
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                else{
                    System.out.println(first + op + second + "의 계산 결과는 " + (first/second));
                    break;
                }
            default:
                System.out.println("해당 사항 없음");
        }

        scanner.close();
    }
}
