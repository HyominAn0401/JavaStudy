package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver5_9625 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int K = Integer.parseInt(br.readLine());
            int [] A = new int[K+1];
            int [] B = new int[K+1];

            A[0] = 1;
            A[1] = 0;
            B[1] = 1;

            if(K==1){
                System.out.println(A[1]+" "+B[1]);
            }
            else{
                for(int i=2; i<=K; i++){
                    A[i] = A[i-1] + A[i-2];
                    B[i] = B[i-1] + B[i-2];
                }
                System.out.println(A[K]+" "+B[K]);
            }
        }
    }
}
