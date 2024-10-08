package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver3_7795 {
    public static void main(String[] args) throws Exception {
        // 구현 및 해야할 것 : 이분탐색으로 A>B 쌍의 개수 구하기
        // 로직 설계
        // 1. 테스트 케이스 별 A, B의 값 입력받아 저장하기
        // 2. A, B 오름차순 정렬
        // 3. 이분탐색 진행
        // 3-1. while 문을 벗어날 때 start값을 누적한다.
        // start 값은 A의 크기가 B보다 큰 쌍의 개수를 의미

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 테스트 케이스 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과값을 저장하고 출력할 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();
            // 테스트 케이스만큼 반복
            for (int t = 0; t < testCase; t++) {
                // N, M 값 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                // N, M 크기 배열 생성
                int[] A = new int[N];
                int[] B = new int[M];

                // A 배열에 값 저장
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    A[i] = Integer.parseInt(st.nextToken());
                }
                // B 배열에 값 저장
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < M; i++) {
                    B[i] = Integer.parseInt(st.nextToken());
                }

                // 두 배열 오름차순 정렬
                Arrays.sort(A);
                Arrays.sort(B);

                // 이분탐색
                sb.append(binarySearch(A, B)+"\n");
                //System.out.println(binarySearch(A, B));
            }
            // 결과 출력
            System.out.print(sb);
        }
    }

    // 이분탐색 메서드
    // 두 배열 매개변수로 전달
    public static int binarySearch(int [] A, int []B){
        // A, B 배열 크기
        int N = A.length;
        int M = B.length;
        // 누적값을 저장할 변수 초기화
        int cnt = 0;

        // A 배열 크기만큼 반복
        for(int i=0; i<N; i++){
            int num = A[i];
            // start, end 초기화
            int start = 0, end=M-1;
            // start <= end면 반복
            while(start <= end){
                // mid 초기화
                int mid = (start + end)/2;
                // A 배열 값이 작거나 같으면
                if(num <= B[mid])
                    end = mid-1;
                    //start = mid+1;
                // A 배열 값이 크면
                else if(num > B[mid])
                    start = mid +1;
                    //end = mid-1;
            }
            // cnt에 누적
            cnt += start;
            //System.out.println(cnt);
        }
        return cnt;
    }
}
