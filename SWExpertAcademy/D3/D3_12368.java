package D3;

import java.util.Scanner;

public class D3_12368 {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){

            int testCase = scanner.nextInt();
            int [] timeCase = new int[testCase];

            for(int i=0; i<testCase; i++){
                int A = scanner.nextInt();
                int B = scanner.nextInt();

                int time = (A+B)%24;

                timeCase[i] = time;
            }

            for(int i=0; i<testCase; i++){
                System.out.println("#"+(i+1)+" "+timeCase[i]);
            }
        }
    }
}
