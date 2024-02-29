package Chap02;

import java.util.Scanner;

public class test11 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //(1) if-else
//        String season ="";
//
//        System.out.print("달을 입력하세요(1~12)>>");
//        int month = scanner.nextInt();
//
//        if(month==3 || month==4 || month==5){
//            season = "봄";
//        }
//        else if(month==6 || month==7 || month==8){
//            season = "여름";
//        }
//        else if(month==9 || month==10 || month==11){
//            season = "가을";
//        }
//        else if(month==12 || month==1 || month==2){
//            season = "겨울";
//        }
//        else{
//            System.out.println("해당사항 없음");
//        }
//
//        System.out.println(season);
//
//
        //(2) switch
        System.out.print("달을 입력하세요(1~12)>>");
        int month = scanner.nextInt();

        switch(month){
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("겨울");
                break;
            default:
                System.out.println("해당사항 없음");
        }

        scanner.close();
    }
}
