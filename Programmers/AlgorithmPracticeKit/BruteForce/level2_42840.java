package AlgorithmPracticeKit.BruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class level2_42840 {
    public static void main(String[] args) throws Exception{
        int [] answers = {1,2,3,4,5};
        int [] result = solution(answers);
    }

    public static int [] solution(int[] answers){
        int answer [] = {};

        int first_cnt=0, second_cnt=0, third_cnt=0;

        int [] first = {1,2,3,4,5};
        int [] second = {2,1,2,3,2,4,2,5};
        int [] third = {3,3,1,1,2,2,4,4,5,5};

        for(int i=0; i<answers.length; i++){
            if(answers[i] == first[i%first.length]) first_cnt++;
            if(answers[i] == second[i%second.length])   second_cnt++;
            if(answers[i] == third[i % third.length])   third_cnt++;
        }

//        int length = answers.length;
//        int first_repeat = length/first.length + 1;
//        int second_repeat = length/second.length +1;
//        int third_repeat = length/third.length + 1;
//
//        int [] first_copy = new int[first.length*first_repeat];
//        int [] second_copy = new int[second.length*second_repeat];
//        int [] third_copy = new int[third.length * third_repeat];
//
//        int maxLength = (first_copy.length > second_copy.length)? first_copy.length : second_copy.length;
//        maxLength = maxLength > third_copy.length ? maxLength : third_copy.length;
//
//        for (int i = 0; i < maxLength; i++) {
//            if (i < first_copy.length) {
//                first_copy[i] = first[i % first.length];
//            }
//            if (i < second_copy.length) {
//                second_copy[i] = second[i % second.length];
//            }
//            if (i < third_copy.length) {
//                third_copy[i] = third[i % third.length];
//            }
//        }
//
//        for(int i=0; i<answers.length; i++){
//            if(answers[i] == first_copy[i]) first_cnt++;
//            if(answers[i] == second_copy[i]) second_cnt++;
//            if(answers[i] == third_copy[i]) third_cnt++;
//        }

        int maxScore = Math.max(Math.max(first_cnt, second_cnt), third_cnt);
        List<Integer> result = new ArrayList<>();

        if(maxScore == first_cnt)   result.add(1);
        if(maxScore == second_cnt)  result.add(2);
        if(maxScore == third_cnt)   result.add(3);

        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}


