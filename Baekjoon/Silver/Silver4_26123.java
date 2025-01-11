package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_26123 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int [] heights = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                heights[i] = Integer.parseInt(st.nextToken());
            }

            int days = 0;
            long cnt = 0;
            while(days < D){
                int end = 0;
                for(int height : heights){
                    if(height == 0) end++;
                }
                if(end==N)  break;

                int maxHeight = 0;
                for(int height : heights){
                    maxHeight = Math.max(height, maxHeight);
                }


                for(int height : heights){
                    if(height == maxHeight){
                        cnt++;
                    }
                }

                for(int i=0; i<N; i++){
                    if(heights[i] == maxHeight){
                        heights[i] -= 1;
                    }
                }

                days++;
            }

            System.out.println(cnt);
        }
    }
}
