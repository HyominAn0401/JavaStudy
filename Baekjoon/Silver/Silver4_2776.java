package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver4_2776 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 테스트 케이스 별 수첩2의 숫자가 수첩1에 있는 경우 1, 없으면 0을 출력한다.
        // 로직 설계
        // 1. 테스트 케이스와 각 테스트 케이스 결과를 저장할 배열 생성
        // 2. N, 수첩1 숫자, M, 수첩2 숫자를 입력받고 배열에 저장한다.
        // 3. 수첩1을 오름차순으로 정렬하고 이분탐색으로 있으면 1, 없으면 0을 StringBuilder 객체에 저장한다.
        // 4. 테스트 케이스 별 결과값을 출력한다.

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            // 테스트 케이스 및 결과값을 저장할 배열 생성
            int testCase = Integer.parseInt(br.readLine());
            String [] result = new String[testCase];

            // 테스트 케이스 반복
            for(int t=0; t<testCase; t++){
                // 결과값을 저장할 StringBuilder 객체 생성
                StringBuilder sb = new StringBuilder();

                // N과 N개 숫자를 저장할 배열 생성
                int N = Integer.parseInt(br.readLine());
                int [] note1 = new int[N];

                // 수첩1에 숫자 저장
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i=0; i<N; i++){
                    note1[i] = Integer.parseInt(st.nextToken());
                }

                // M과 M개 숫자를 저장할 배열 생성
                int M = Integer.parseInt(br.readLine());
                int [] note2 = new int[M];

                // 수첩2에 숫자 저장
                st = new StringTokenizer(br.readLine());
                for(int i=0; i<M; i++){
                    note2[i] = Integer.parseInt(st.nextToken());
                }

                // 수첩1 오름차순 정렬
                Arrays.sort(note1);

                // 수첩2 숫자에 대해 이분탐색
                for(int i=0; i<M; i++){
                    int x = note2[i];
                    // 마지막은 줄바꿈 없애기
                    if(i==M-1) {
                        sb.append(binarySearch(note1, x));
                        break;
                    }
                    // 그 외의 경우 줄바꿈 추가
                    sb.append(binarySearch(note1, x)+"\n");
                }
                // 배열에 테스트 케이스 별 결과 저장
                result[t] = sb.toString();
            }
            // 출력
            for(int t=0; t<testCase; t++){
                System.out.println(result[t]);
            }
        }
    }

    // 이분 탐색
    public static int binarySearch(int [] array, int x){
        // start, end값 초기화
        int start = 0;
        int end = array.length-1;
        // start<=end 일 때까지 반복
        while(start <= end){
            int mid = (start+end)/2;
            if(x < array[mid])
                end = mid-1;
            else if(x > array[mid])
                start = mid+1;
            // 값이 존재하면 1 리턴
            else if(x == array[mid])
                return 1;
        }
        // 없으면 0 리턴
        return 0;
    }
}
