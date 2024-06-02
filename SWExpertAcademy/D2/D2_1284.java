package D2;

import java.util.Scanner;

public class D2_1284 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int fee [][] = new int [T][5];

        for(int i =0; i<fee.length; i++){
            for(int j=0; j<fee[0].length; j++){
                fee[i][j] = scanner.nextInt();
            }
        }

        for(int i=0; i<fee.length; i++){
            System.out.print("#"+(i+1)+" ");
            int A = fee[i][0] * fee[i][4];
            int B = fee[i][1];

            if(fee[i][4] > fee[i][2]){
                B += (fee[i][4] - fee[i][2]) * fee[i][3];
            }
            if(A>=B)    System.out.println(B);
            else        System.out.println(A);
        }

        scanner.close();

//        int P = scanner.nextInt();
//        int Q = scanner.nextInt();
//        int R = scanner.nextInt();
//        int S = scanner.nextInt();
//        int W = scanner.nextInt();
//
//        int A = P*W;
//        int B = Q;
//
//        if(W > R){
//            int extra = (W-R)*S;
//            B += extra;
//        }
//
//        if(A>=B)    System.out.println(B);
//        else        System.out.println(A);

    }
}
