package D1;

import java.util.Scanner;

public class D1_2070 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        char [] operators = new char[testCase];

        for(int i=0; i<testCase; i++){
            char operator = ' ';
            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();
            if(firstNumber < secondNumber)
                operator = '<';
            else if(firstNumber > secondNumber)
                operator = '>';
            else if(firstNumber == secondNumber)
                operator = '=';
            operators[i] = operator;
        }

        for(int i=0; i<testCase; i++){
            System.out.println("#"+(i+1)+" "+operators[i]);
        }

        scanner.close();
    }
}
