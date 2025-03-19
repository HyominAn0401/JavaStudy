package Kakao.TechInternship2022;

import java.util.LinkedList;
import java.util.Queue;

public class Kakao2022_tech_internship_118667 {
    public static void main(String[] args) throws Exception{
        int [] queue1 = {1,1};
        int [] queue2 = {1,5};
        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int [] queue2){
        int answer = -1;
        Queue<Integer> queue_1 = new LinkedList<>();
        Queue<Integer> queue_2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0;
        for (int num : queue1) {
            queue_1.add(num);
            sum1 += num;
        }
        for (int num : queue2) {
            queue_2.add(num);
            sum2 += num;
        }

        // for(int num1 : queue1){
        //     queue_1.add(num1);
        // }
        // for(int num2 : queue2){
        //     queue_2.add(num2);
        // }

        //long totalSum = queueSum(queue_1) + queueSum(queue_2);
        long totalSum = sum1+sum2;
        if(totalSum%2!=0){
            return answer;
        }

        // 짝수
        long goal = totalSum/2;
        int count = 0;
        int cnt = queue1.length * 3;

        while(count < cnt){
            if(sum1 == goal)    return count;
            // long sum1 = queueSum(queue_1);
            // long sum2 = queueSum(queue_2);
            // if(sum1 < sum2){
            //     queue_1.add(queue_2.poll());
            // }
            // else if(sum1 > sum2){
            //     queue_2.add(queue_1.poll());
            // }
            // else if(sum1 == sum2){
            //     answer = count;
            //     return answer;
            // }
            if(sum1 > goal){
                long num = queue_1.poll();
                sum1 -= num;
                queue_2.add((int) num);
                sum2 += num;
            }
            else{
                long num = queue_2.poll();
                sum2 -= num;
                queue_1.add((int) num);
                sum1 += num;
            }
            //cnt++;
            count++;
        }
        return answer;

    }

    // public static long queueSum(Queue<Integer> queue){
    //     long sum = 0;
    //     for(long number : queue){
    //         sum += number;
    //     }
    //     return sum;
    // }
}
