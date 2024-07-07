package D3;

import java.util.Scanner;

public class D3_11387 {

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){
            int testCase = scanner.nextInt();
            double [] results = new double[testCase];

            for(int t=0; t<testCase; t++){
                int D = scanner.nextInt();
                int L = scanner.nextInt();
                int N = scanner.nextInt();

                int sum = 0;
                for(int i=0; i<N; i++){
                    sum += i;
                }
                results[t] = D*N+D*L*0.01*sum;
            }

            for(int t=0; t<testCase; t++){
                System.out.println("#"+(t+1)+" "+Math.round(results[t]));
            }
        }
    }
}
