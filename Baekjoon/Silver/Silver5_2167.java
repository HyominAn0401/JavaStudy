package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_2167 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int [][] numberArray = new int[N+1][M+1];
            int [][] sumArray = new int[N+1][M+1];

            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=M; j++){
                    numberArray[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sumArray[1][1] = numberArray[1][1];

            for(int i=1; i<=N; i++){
                for(int j=1; j<=M; j++){
                    sumArray[i][j] = sumArray[i-1][j] + sumArray[i][j-1] - sumArray[i-1][j-1] + numberArray[i][j];
                }
            }

            int K = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int l=0; l<K; l++){
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                sb.append(accumulateSum(i, j, x, y, sumArray)+"\n");
            }
            System.out.print(sb);

        }
    }

    public static int accumulateSum(int i, int j, int x, int y, int [][] sumArray){
        return sumArray[x][y] - sumArray[i-1][y] - sumArray[x][j-1] + sumArray[i-1][j-1];
    }
}
