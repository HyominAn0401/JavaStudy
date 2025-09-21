package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_2559_20250920 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 :
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int [] numArray = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numArray[i] = Integer.parseInt(st.nextToken());
            }

            int resultSum = Integer.MIN_VALUE;
            for(int i=0; i<=N-K; i++){
                int sum = 0;
                for(int j=i+K-1; j>=i; j--){
                    sum += numArray[j];
                }
                if(sum > resultSum) resultSum = sum;
            }

            System.out.println(resultSum);
        }
    }
}
