package D1;

import java.util.Scanner;

public class D1_2029 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int k = 0;
        int T = scan.nextInt();
        int array_A[] = new int [T];
        int array_B[] = new int [T];

        for(int i=0; i<T; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            array_A[i] = a/b;
            array_B[i] = a%b;
        }

        for(int j =0; j<T; j++){
            k++;
            System.out.println("#"+k+" "+array_A[j]+" "+array_B[j]);
        }
    }
}
