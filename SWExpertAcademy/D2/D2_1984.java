package D2;

import java.util.Scanner;

public class D2_1984 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int [] results = new int[testCase];

        for(int i = 0; i<testCase; i++){
            int [] num = new int[10];
            //int max = -999;
            //int min = 999;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;

            for(int j=0; j<10; j++) {
                num[j] = scanner.nextInt();
                sum += num[j];

                if (num[j] > max) max = num[j];
                if (num[j] < min) min = num[j];
            }

            results[i] = Math.round((float)(sum-max-min)/8);
        }

        for(int i = 0; i<testCase; i++){
            System.out.println("#"+(i+1)+" "+ results[i]);
        }

        scanner.close();
    }
}
