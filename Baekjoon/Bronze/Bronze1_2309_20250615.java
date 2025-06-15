package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze1_2309_20250615 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int [] heights = new int[9];
            int sum = 0;

            for(int i=0; i<9; i++){
                heights[i] = Integer.parseInt(br.readLine());
                sum += heights[i];
            }

            Arrays.sort(heights);

            // 모든 경우의 수 다 구해서 합이 100이 되는 지 확인하기
            // 2개 숫자를 제외하고 나머지 합 구하기

            int fake1=0, fake2=0;
            int correctSum = 0;

            for(int i=0; i<9; i++){
                for(int j=i+1; j<9; j++){
                    correctSum = sum - (heights[i]+heights[j]);
                    if(correctSum==100){
                        fake1 = heights[i];
                        fake2 = heights[j];
                        break;
                    }
                }
            }

//            for(int i=0; i<heights.length; i++){
//                if(heights[i]!=fake1 && heights[i]!=fake2)
//                    System.out.println(heights[i]);
//            }

            for(int height : heights){
                if(height==fake1 | height==fake2)
                    continue;
                else System.out.println(height);
            }
        }
    }
}
