package AlgorithmPracticeKit.Sort;

import java.util.Arrays;

public class level2_42747 {
    public static void main(String[] args) {
        int [] citations = {3,0,6,1,5};
        System.out.println(solution(citations));
    }

    public static int solution(int [] citations){
        Arrays.sort(citations);

        int answer = 0;
        for(int h=0; h<10000; h++){
            int high=0, low=0;
            for(int i=0; i<citations.length; i++){
                if(citations[i] >= h){
                    high = citations.length-i;
                    low = i;
                    if(high >= h)
                        continue;
                    else{
                        answer = high;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
