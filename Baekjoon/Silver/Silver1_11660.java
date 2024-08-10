package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_11660 {

    // 숫자를 저장할 이차원 배열
    static int [][] numbersArray;
    // 누적 합을 저장할 이차원 배열
    static int [][] prefixSum;

    public static void main(String[] args) throws IOException{

        // 구현 및 해야할 것 : 이차원 배열에서 행렬이 주어질 때 행렬 내 누적 합 구하기
        // 로직 설계
        // 1. N, M을 입력받고 N+1 크기의 숫자를 저장할 이차원 배열과 누적 합을 저장할 이차원 배열을 생성한다.
        // 2. 숫자를 저장하면서 누적 합을 구해 배열에 각각 저장한다.
        // 3. M 만큼 반복하면서 x1, y1, x2, y2 사이의 합을 구해 출력한다.

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 결과값을 저장할 StringBuilder 생성
            StringBuilder sb = new StringBuilder();

            // 숫자와 누적합을 저장할 이차원 배열 생성
            numbersArray = new int[N+1][N+1];
            prefixSum = new int[N+1][N+1];

            // 숫자 저장
            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++){
                    numbersArray[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 누적 합 저장
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + numbersArray[i][j];
                }
            }

            // M만큼 반복하면서 누적합 구하기
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                sb.append(numberSum(x1, y1, x2, y2)).append("\n");
            }

            System.out.println(sb);
        }
    }

    // (x1, y1)부터 (x2, y2)까지의 합을 구해 리턴하는 메소드
    static int numberSum(int x1, int y1, int x2, int y2){

        return prefixSum[x2][y2] - prefixSum[x2][y1-1] - prefixSum[x1-1][y2] + prefixSum[x1-1][y1-1];
    }

//    static int [][] numArray;
//    static int [][] prefixSum;
//    static int N;
//
//    public static void main(String[] args) throws IOException {
//        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//
//            StringBuilder sb = new StringBuilder();
//
//            numArray = new int[N+1][N+1];
//            prefixSum = new int[N+1][N+1];
//
//            for(int i=1; i<=N; i++){
//                st = new StringTokenizer(br.readLine());
//                for(int j=1; j<=N; j++){
//                    numArray[i][j] = Integer.parseInt(st.nextToken());
//                    //prefixSum[i][j] = prefixSum[i][j-1] + numArray[i][j];
//                    if(j-1 == 0)
//                        prefixSum[i][j] = prefixSum[i-1][N] + numArray[i][j];
//                    else
//                        prefixSum[i][j] = prefixSum[i][j-1] + numArray[i][j];
//                }
//            }
//
////            for(int i=0; i<N+1; i++){
////                for(int j=0; j<N+1; j++){
////                    System.out.print(prefixSum[i][j]+" ");
////                }
////                System.out.println();
////            }
//
//            // 숫자 입력받기
//            for(int i=0; i<M; i++){
//                st = new StringTokenizer(br.readLine());
//                int x1 = Integer.parseInt(st.nextToken());
//                int y1 = Integer.parseInt(st.nextToken());
//                int x2 = Integer.parseInt(st.nextToken());
//                int y2 = Integer.parseInt(st.nextToken());
//
//                sb.append(ArraySum(x1, y1, x2, y2)).append("\n");
//            }
//
//            System.out.println(sb);
//
//        }
//
//    }
//
//    static int ArraySum(int x1, int y1, int x2, int y2){
//        int sum = 0;
//        if(y1-1==0){
//            sum = prefixSum[x2][y2] - prefixSum[x1-1][N];
//        }
//        else sum = prefixSum[x2][y2] - prefixSum[x1][y1-1];
//
//
//        return sum;
//    }
}
