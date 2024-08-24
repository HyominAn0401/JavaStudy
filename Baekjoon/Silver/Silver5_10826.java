package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Silver5_10826 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            //long n = Long.parseLong(br.readLine());

            int n = Integer.parseInt(br.readLine());
            //long[] fibo = new long[(int)n+1];

            BigInteger[] fibo = new BigInteger[n+1];
            //fibo[0] = 0;
            fibo[0] = BigInteger.ZERO;

            if (n >= 1) {
                //fibo[1] = 1;
                fibo[1] = BigInteger.ONE;
                for (int i = 2; i <= n; i++) {
                    //fibo[i] = fibo[i - 1] + fibo[i - 2];
                    fibo[i]=fibo[i-1].add(fibo[i-2]);
                }

            }
            System.out.println(fibo[n]);
        }
    }
}
