package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver5_16435 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fruit = Integer.parseInt(st.nextToken());
            int snake = Integer.parseInt(st.nextToken());

            int [] fruitsHeight = new int[fruit];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<fruit; i++){
                fruitsHeight[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(fruitsHeight);

            for(int i=0; i<fruit; i++){
                if(snake >= fruitsHeight[i])
                    snake+=1;
                else break;
            }

            System.out.println(snake);
        }
    }
}
