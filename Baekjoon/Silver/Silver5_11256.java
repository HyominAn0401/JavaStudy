package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver5_11256 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 :
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int t=0; t<testCase; t++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int candy = Integer.parseInt(st.nextToken());
                int box = Integer.parseInt(st.nextToken());

                int [] boxSize = new int[box];
                for(int i=0; i<box; i++){
                    st = new StringTokenizer(br.readLine());
                    int height = Integer.parseInt(st.nextToken());
                    int width = Integer.parseInt(st.nextToken());
                    boxSize[i] = height*width;
                }

                Arrays.sort(boxSize);

                int count = 0;
                int i=box-1;
                while(candy > 0){
                    candy -= boxSize[i];
                    count++;
                    i--;
                }

                sb.append(count+"\n");
            }

            System.out.print(sb);
        }
    }
}
