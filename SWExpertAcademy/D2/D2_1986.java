package D2;

import java.util.Scanner;

public class D2_1986 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //횟수 검사
        int i = 1;
        int k = 0;


        //Test
        int T = scanner.nextInt();
        int results[] = new int[T];

        while(i<=T){
            int odd = 0, even = 0;
            int N = scanner.nextInt();

            for(int j=1; j<=N; j++){
                if(j%2==1) odd+=j;
                else if(j%2==0) even+=j;
            }
            results[k] = odd - even;

            i++;
            k++;
        }
        for(i=0;i<T;i++){
            System.out.printf("#%d %d\n", i+1, results[i]);
        }

        scanner.close();
    }
}
