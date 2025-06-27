package AlgorithmPracticeKit.BruteForce;

import java.util.List;
import java.util.ArrayList;

public class level2_42840_20250627 {
    public static void main(String[] args) throws Exception{
        int[] answers = {1,3,2,4,2};
        for(int n : solution(answers)){
            System.out.println(n);
        }
    }

    public static int [] solution(int[] answers){
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};
        int cnt_1=0, cnt_2=0, cnt_3=0;
        int maxValue = Integer.MIN_VALUE;

        for(int i=0; i<answers.length; i++){
            if(answers[i]==num1[i%5])   cnt_1++;
            if(answers[i]==num2[i%8])   cnt_2++;
            if(answers[i]==num3[i%10])  cnt_3++;
        }

        List<Integer> list = new ArrayList<>();
        maxValue = Math.max(Math.max(cnt_1, cnt_2), cnt_3);
        if(maxValue==cnt_1) list.add(1);
        if(maxValue==cnt_2) list.add(2);
        if(maxValue==cnt_3) list.add(3);

        int [] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
