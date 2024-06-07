package D1;

import java.util.Scanner;

public class D1_2071 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        int [] averages = new int[testCase];

        for(int i=0;i<testCase;i++){
            int sum = 0;

            for(int j=0; j<10;j++){
                int number = scanner.nextInt();
                sum += number;
            }

            averages[i] = Math.round((float)sum/10);
        }

        for(int i=1; i<=testCase; i++){
            System.out.println("#"+i+" "+averages[i-1]);
        }
    }
}
