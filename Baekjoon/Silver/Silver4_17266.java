package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_17266 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int [] location = new int[M];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                location[i] = Integer.parseInt(st.nextToken());
            }

            int start = 1;
            int end = N;
            int result = N;

            while(start<=end){
                int height = (start+end)/2;
                if(canCover(location, height, N)){
                    result = height;
                    end = height-1;
                }
                else{
                    start = height+1;
                }
            }

            System.out.println(result);
        }
    }

    public static boolean canCover(int [] location, int height, int tunnelLength){
        if(location[0] - height > 0)
            return false;

        for(int i=1; i<location.length-1; i++){
            if(location[i-1] + height < location[i]-height)
                return false;
        }

        if(location[location.length-1]+height < tunnelLength)
            return false;

        return true;
    }
}
