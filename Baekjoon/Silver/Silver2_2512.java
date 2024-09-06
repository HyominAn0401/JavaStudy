package Silver.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2_2512 {

    public static int N;
    public static int [] budget;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 모든 요청이 배정될 수 없는 경우 최대한의 정수 상한액 출력하기
        // 로직 설계
        // 1. N과 N 크기의 배열 생성
        // 2. 지방 예산 요청 입력받고 오름차순 정렬하기
        // 3. 국가예산 총액 입력받기
        // 4. 지방예산의 총합이 국가예산 총합보다 작거나 같은 경우 지방예산의 최대값 출력, 아닌 경우 이분탐색
        // 4-1. 이분탐색에서 각 지방예산값이 mid보다 작은 경우 sum 변수에 +지방예산 아닌 경우 +mid
        // 4-2. sum 값이 국가예산 총합보다 큰 경우 end = mid-1로 조정, 아닌 경우 값 answer에 저장 후 start = mid+1로 조정, 이분탐색 반복

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N과 지방예산 값을 저장할 N 크기의 배열 생성
            N = Integer.parseInt(br.readLine());
            budget = new int[N];
            // 지방예산 총합을 저장할 변수 초기화
            int sum = 0;

            // 지방예산값 입력받아 변수에 저장 및 총합 계산
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                budget[i] = Integer.parseInt(st.nextToken());
                sum += budget[i];
            }

            // 국가예산 총액 입력받기
            int nationalBudget = Integer.parseInt(br.readLine());
            // 오름차순 정렬
            Arrays.sort(budget);
            // 값을 비교해 총합이 작거나 같은 경우 지방예산 최대값 출력, 아닌 경우 이분탐색 실행값 출력
            System.out.println(sum <= nationalBudget? budget[N-1]: binarySearch(nationalBudget));
        }
    }

    // 이분탐색
    public static int binarySearch(int nationalBudget){
        // 리턴할 변수
        int answer = 0;
        // start, end 값 초기화
        int start = 0, end = budget[N-1];

        // 이분탐색 반복
        while(start <= end){
            // 총합을 저장할 변수 초기화
            int sum = 0;
            // mid 값 초기화
            int mid = (start+end)/2;
            // mid값과 예산 비교 반복
            for(int i=0; i<N; i++){
                // 예산값이 mid보다 크거나 같은 경우 mid값 누적
                if(budget[i] >= mid){
                    sum += mid;
                }
                // 아닌 경우 예산값 누적
                else {
                    sum += budget[i];
                }
            }

            // 총합이 국가예산보다 큰 경우 end값 조정
            if(sum > nationalBudget)
                end = mid -1;
            // 아닌 경우 값 저장 후 start 값 조정
            else{
                answer = mid;
                start = mid +1;
            }
        }
        // 값 리턴
        return answer;
    }

//    public static int N;
//    public static int [] budget;
//    public static void main(String[] args) throws Exception{
//
//        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
//            N = Integer.parseInt(br.readLine());
//            budget = new int[N];
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int i=0; i<N; i++){
//                budget[i] = Integer.parseInt(st.nextToken());
//            }
//
//            int nationalbudget = Integer.parseInt(br.readLine());
//
//            Arrays.sort(budget);
//
////            for(int money : budget){
////                System.out.print(money+" ");
////            }
////            System.out.println();
//
//            int sum = 0;
//            for(int i=0; i<N; i++){
//                sum += budget[i];
//            }
//
//            int [] maximumPrice = new int[budget[N-1]-budget[0]+1];
//            int j = 0;
//            for(int i=budget[0]; i<=budget[N-1]; i++){
//                maximumPrice[j] = i;
//                j++;
//            }
//            System.out.println(sum<= nationalbudget? budget[N-1]: binarySearch(maximumPrice, nationalbudget));
//        }
//    }
//
//    public static int binarySearch(int [] array, int nationalBudget){
//        int start = 0;
//        int end = array.length-1;
//
//        int answer = 0;
//
//        while(start <= end){
//            int sum = 0;
//            int mid = (start+end)/2;
//            answer = array[mid];
//
//            for(int i=0; i<N; i++){
//                if(budget[i] >= answer){
//                    sum += answer;
//                }
//                else{
//                    sum += budget[i];
//                }
//            }
//
//            if(sum > nationalBudget) {
//                end = mid - 1;
//                //System.out.println("end "+end);
//            }
//            else {
//                answer = array[mid];
//                start = mid+1;
//                System.out.println("start "+start);
//            }
//        }
//
//        return answer;
//    }
}
