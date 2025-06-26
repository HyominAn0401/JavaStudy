package AlgorithmPracticeKit.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class level2_42746_20250626 {
    public static void main(String[] args) {
        int [] numbers = {3,30,34,5,9};
        System.out.println(solution(numbers));
    }

    public static String solution(int [] numbers){
        StringBuilder sb = new StringBuilder();
        String [] numStr = new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            numStr[i] = String.valueOf(numbers[i]);
        }

        Comparator<String> bySize = (a,b) -> (b+a).compareTo(a+b);

        Arrays.sort(numStr, bySize);

        for(String str: numStr){
            sb.append(str);
        }

        return sb.toString();
    }
}
