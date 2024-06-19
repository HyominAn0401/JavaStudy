package D3;

import java.util.Scanner;

public class D3_3431 {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){

            int testCase = scanner.nextInt();
            int [] exerciseMin = new int[testCase];

            for(int i=0; i<testCase; i++){
                int L = scanner.nextInt();
                int U = scanner.nextInt();
                int X = scanner.nextInt();
                int result = 0;

                if(X < L)   result = L-X;
                else if((X>=L) && (X<=U))   result = 0;
                else if(X > U)  result = -1;
                exerciseMin[i] = result;
            }

            for(int i=0; i<testCase; i++){
                System.out.println("#"+(i+1)+" "+exerciseMin[i]);
            }
        }
    }
}
