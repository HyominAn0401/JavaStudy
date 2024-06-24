package D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1983 {

    public static double calculateScore(int mid, int fin, int assignment){
        return mid*0.35+fin*0.45+assignment*0.2;
    }

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){
            int testCase = scanner.nextInt();
            String [] scoreList = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
            String [] totalScore = new String[testCase];

            for(int test=0; test<testCase; test++) {
                int studentsN = scanner.nextInt();
                int numberK = scanner.nextInt();

                double[] scores = new double[studentsN];
                int k = studentsN / 10;
                String[] scoreStr = new String[studentsN];
                double tmp = -1;
                int index = 0;

                for (int i = 0; i < studentsN; i++) {
                    int mid = scanner.nextInt();
                    int fin = scanner.nextInt();
                    int assignment = scanner.nextInt();
                    //System.out.println("mid "+mid+" fin "+fin+" assign "+assignment);
                    scores[i] = calculateScore(mid, fin, assignment);
                    //System.out.println(scores[i]);
                    if (i == (numberK - 1)) tmp = scores[i];
                    //scanner.nextLine();
                }

                Arrays.sort(scores);
                int l = 0;

                for (int i = 0; i < studentsN; i += k) {
                    for (int j = i; j < k + i; j++) {
                        scoreStr[j] = scoreList[l];
                    }
                    l++;
                }

                for (int i = 0; i < studentsN; i++) {
                    if (scores[i] == tmp) index = i;
                }

                totalScore[test] = scoreStr[index];
            }
            for(int i=0; i<testCase; i++){
                System.out.println("#"+(i+1)+" "+totalScore[i]);
            }
        }
    }
}
