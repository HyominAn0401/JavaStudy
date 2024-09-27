package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_2579 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int [][] triangle = new int[N][N+1];
            int [][] prefixSum = new int[N][N+1];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<=i; j++){
                    triangle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            prefixSum[0][0] = triangle[0][0];

            for(int i=1; i<N; i++){
                for(int j=0; j<=i; j++){
                    prefixSum[i][j] = prefixSum[i-1][j] + triangle[i][j];
                    prefixSum[i][j+1] = prefixSum[i-1][j] + triangle[i][j+1];
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(prefixSum[i][j]+" ");
                }
                System.out.println();
            }


        }
    }
}
