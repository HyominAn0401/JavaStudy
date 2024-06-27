package D3;

import java.util.Arrays;
import java.util.Scanner;

public class D3_6913 {

    // 1등 점수 반환
    public static String getSolveCnt(int [][]array){
        //int maxValue = Integer.MIN_VALUE;
        int first = 0;
        int [] sumArray = new int[array.length];
        for(int i=0; i<array.length; i++){
            int cnt = 0;
            for(int j=0; j<array[0].length; j++){
                if(array[i][j]==1)  cnt++;
            }
            sumArray[i] = cnt;
            //if(maxValue == cnt) first++;
        }
        Arrays.sort(sumArray);
        int maxValue = sumArray[array.length-1];
        for(int i=0; i<sumArray.length;i++){
            if(sumArray[i] == maxValue) first++;
        }

        return first+" "+maxValue;
    }

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {
            int testCase = scanner.nextInt();
            String [] problems = new String [testCase];
            for (int test = 0; test < testCase; test++) {
                //System.out.println("N, M: ");
                int N = scanner.nextInt();
                int M = scanner.nextInt();

                int[][] problem = new int[N][M];

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        problem[i][j] = scanner.nextInt();
                    }
                }

                problems[test] = getSolveCnt(problem);
            }

            for(int test=0; test<testCase; test++){
                System.out.println("#"+(test+1)+" "+problems[test]);
            }
        }
    }
}
