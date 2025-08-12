package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze1_2309_20250812 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int [] heights = new int[9];
            int sum = 0;
            for(int i=0; i<9; i++){
                heights[i] = Integer.parseInt(br.readLine());
                sum += heights[i];
            }

            Arrays.sort(heights);
            int fake1=0, fake2=0;

            // 전체 합을 다 구해서 100이 되는 경우 출력
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    if((sum - heights[i] - heights[j]) ==100){
                        fake1 = heights[i];
                        fake2 = heights[j];
                        break;
                    }
                }
            }

            for(int height : heights){
                if(height!=fake1 && height!=fake2)
                    System.out.println(height);
            }
        }
    }
}
