package AlgorithmPracticeKit.Sort;

import java.util.Arrays;

public class level2_42746 {
    public static void main(String[] args) throws Exception{
        int [] numbers = {3, 30, 34, 5, 9};
        String answer = solution(numbers);
        System.out.println(answer);
    }

    public static String solution(int[] numbers){
        String [] nums= new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, (a,b)-> (b+a).compareTo(a+b));

        if(nums[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String num : nums){
            sb.append(num);
        }

        return sb.toString();
    }
}
