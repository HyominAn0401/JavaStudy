package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze1_2748_20250518 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            long [] fibo = new long[N+1];

            if(N!=0) {
                fibo[1] = 1;
                for (int i = 2; i <= N; i++) {
                    fibo[i] = fibo[i - 1] + fibo[i - 2];

                }
            }

            System.out.println(fibo[N]);
        }
    }
}
