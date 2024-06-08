package D1;

import java.util.Scanner;

public class D1_2072 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        int [] results = new int[testCase];

        for(int i=0;i<testCase;i++) {
            int oddSum = 0;
            for (int j = 0; j< 10; j++) {
                int num = scanner.nextInt();
                if (num % 2 == 1) oddSum += num;
            }
            results[i] = oddSum;
        }

        for(int i=0; i<testCase; i++){
            System.out.println("#"+(i+1)+" "+results[i]);
        }

        scanner.close();
    }
}
