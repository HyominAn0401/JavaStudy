package D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1983 {

    // 중간 기말 과제 점수를 받아 총점을 구해 반환하는 함수
    public static double calculateScore(int mid, int fin, int assignment){
        return mid*0.35+fin*0.45+assignment*0.2;
    }

    public static void main(String[] args) {
        // 구현 및 해야할 것 :
        // 로직 설계
        // 1. 테스트 케이스를 입력받고 결과를 저장할 totalScore 배열을 생성한다
        // 2. 각 테스트 케이스 별 학생 수와 특정 학생 번호를 입력받고 점수를 계산할 scores 배열, 등급을 저장할 scoreStr배열을 생성한다
        // 3. 각 학생의 중간, 기말, 과제 점수를 받아 총점을 계산하고 배열에 저장한다. 특정 학생 점수를 tmp에 저장한다
        // 3. 오름차순으로 scores 배열을 정렬하고 성적 순으로 등급을 매긴다
        // 4. scores 배열에서 tmp에 저장된 점수를 찾아 totalScore에 저장한다
        // 5. 테스트 케이스 결과를 출력한다


        // try-with-resources로 Scanner 자원 관리
        try(Scanner scanner = new Scanner(System.in)){
            // 테스트 케이스 입력받기
            int testCase = scanner.nextInt();
            // 점수 등급 배열 초기화
            String [] scoreList = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
            // 최종 결과를 저장할 배열
            String [] totalScore = new String[testCase];

            // 테스트 케이스만큼 반복하는 for문
            for(int test=0; test<testCase; test++) {
                // 학생 수 입력받기
                int studentsN = scanner.nextInt();
                // 특정 학생 번호 입력받기
                int numberK = scanner.nextInt();

                // 총점을 계산해 저장할 배열
                double[] scores = new double[studentsN];
                // 각 등급 별 학생 수를 저장할 변수
                int k = studentsN / 10;
                // 학생별 등급을 저장할 배열
                String[] scoreStr = new String[studentsN];
                // 특정 학생 점수를 임시로 저장할 변수
                double tmp = -1;
                // 특정 학생 등급을 찾을 인덱스변수
                int index = 0;

                // 학생 수만큼 반복할 for문
                for (int i = 0; i < studentsN; i++) {
                    // 중간, 기말, 과제 점수 입력받기
                    int mid = scanner.nextInt();
                    int fin = scanner.nextInt();
                    int assignment = scanner.nextInt();
                    // 총점 계산 후 배열에 저장
                    scores[i] = calculateScore(mid, fin, assignment);
                    // 특정 학생 점수 tmp에 저장
                    if (i == (numberK - 1)) tmp = scores[i];
                }

                // 총점 오름차순으로 정렬
                Arrays.sort(scores);
                // 등급 인덱스를 위한 변수
                int l = 0;

                // 점수 등급 저장을 위한 for문
                for (int i = 0; i < studentsN; i += k) {
                    // 점수 구간별 등급 할당하는 for문
                    for (int j = i; j < k + i; j++) {
                        scoreStr[j] = scoreList[l];
                    }
                    l++;
                }

                for (int i = 0; i < studentsN; i++) {
                    // 특정 학생 점수로 인덱스 찾기
                    if (scores[i] == tmp) index = i;
                }

                // 배열에 결과 저장
                totalScore[test] = scoreStr[index];
            }
            // 테스트 케이스 별 결과값 출력
            for(int i=0; i<testCase; i++){
                System.out.println("#"+(i+1)+" "+totalScore[i]);
            }
        }
    }
}
