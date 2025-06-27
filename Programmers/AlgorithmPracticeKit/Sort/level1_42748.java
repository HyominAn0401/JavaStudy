package AlgorithmPracticeKit.Sort;

import java.util.Arrays;

public class level1_42748 {
    public static void main(String[] args) {
        int [] array = {1,5,2,6,3,7,4};
        int [][] commmands = {{2,5,3}, {4,4,1}, {1,7,3}};
        for(int n : solution(array, commmands)){
            System.out.println(n);
        }
    }

    public static int[] solution(int[] array, int [][] commands){
        int [] answer = new int[commands.length];
        for(int l=0; l< commands.length; l++){
            int i = commands[l][0] - 1;
            int j = commands[l][1] - 1;
            int k = commands[l][2] - 1;

            int [] num = new int[j-i+1];

            int cnt = 0;
            for(int m=i; m<=j; m++){
                num[cnt] = array[m];
                cnt++;
            }

//            int [] sliced = Arrays.copyOfRange(array, i, j);
            Arrays.sort(num);
            answer[l] = num[k];
        }

        return answer;
    }
}
