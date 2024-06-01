package D1;

import java.util.Scanner;

public class D1_1936 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String result ="";
        char result2 = ' ';

        //A가 가위
        if(a==1){
            //B가 바위
            if(b==2){
                result = "B";
            }
            //B가 보
            else if(b==3) {
                result = "A";
            }
        }
        //A가 바위
        else if(a==2){
            //B가 가위
            if(b==1){
                result = "A";
            }
            else if(b==3){
                result = "B";
            }
        }
        //A가 보
        else if(a==3){
            //B가 가위
            if(b==1){
                result = "B";
            }
            else if(b==2){
                result = "A";
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
