package D1;

import java.util.Scanner;

public class D1_2043 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int P = scanner.nextInt();
        int K = scanner.nextInt();
        int result = 0;

        for(int i=K; i<=P; i++){
            result++;
        }
        System.out.print(result);

        scanner.close();
    }
}
