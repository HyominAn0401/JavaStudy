package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_1051 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] rectangle = new char[N][M];

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<M; j++){
                    rectangle[i][j] = str.charAt(j);
                }
            }

            int maxValue = Integer.MIN_VALUE;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    maxValue = Math.max(maxSquare(rectangle, i, j), maxValue);
                }
            }

            System.out.print(maxValue);

        }
    }

    private static int maxSquare(char[][] rectangle, int i, int j){
        int s = Math.min(rectangle.length, rectangle[0].length)-1;

        while(s>0){
            if(i+s < rectangle.length && j+s < rectangle[0].length){
                if(rectangle[i][j] == rectangle[i][j+s] && rectangle[i][j+s]==rectangle[i+s][j] && rectangle[i+s][j]==rectangle[i+s][j+s] && rectangle[i+s][j+s]==rectangle[i][j]){
                    return (s+1)*(s+1);
                }
            }
            s--;
        }

        return 1;
    }
}
