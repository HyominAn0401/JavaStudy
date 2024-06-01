package D1;

import java.util.Scanner;

public class D1_1933 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=1; i<=N; i++){
            if(N%i==0){
                System.out.printf("%d ", i);
            }
        }

        sc.close();

//        int length = array.length;
//
//        for(int j=0; j<length; j++){
//            System.out.print(array[j]+" ");
//        }
    }
}
