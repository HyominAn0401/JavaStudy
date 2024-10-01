package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver4_2670 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            double [] num = new double[N];

            for(int i=0; i<N; i++){
                num[i] = Double.parseDouble(br.readLine());
            }

            double current = num[0];
            double maxValue = current;

            for(int i=1; i<N; i++){
                current = Math.max(num[i], num[i]*current);
                maxValue = Math.max(current, maxValue);
            }

            System.out.printf("%.3f", maxValue);
        }
    }
}
