package D1;

import java.util.Scanner;

public class D1_2068 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        int [] max_numbers = new int[testCase];

        for(int i=0; i<testCase; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j<10; j++) {
                int number = scanner.nextInt();
                if (number > max) max = number;
            }
            max_numbers[i] = max;
        }

        for(int i=0; i<testCase; i++){
            System.out.println("#"+(i+1)+" "+max_numbers[i]);
        }
    }
}
