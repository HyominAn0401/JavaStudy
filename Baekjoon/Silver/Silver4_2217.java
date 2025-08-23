package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver4_2217 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int [] ropes = new int[N];

            for(int i=0; i<N; i++){
                ropes[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(ropes);

            int maxValue = Integer.MIN_VALUE;

            for(int i=1; i<=N; i++){
                maxValue = Math.max(maxValue, ropes[N-i]*i);
            }

            System.out.println(maxValue);
        }
    }
}
