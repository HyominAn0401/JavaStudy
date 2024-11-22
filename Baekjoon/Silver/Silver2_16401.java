package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2_16401 {
    static int M;
    static int N;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 이분탐색으로 N명에게 나눠줄 수 있는 최대 과자의 길이 구하기
        // 로직 설계
        // M, N 받고 과자 길이 받기
        // 2. 오름차순 정렬
        // 3. 이분탐색 실행
        // 4. 최소 과자 길이 1, 최대 길이 배열 끝값을 두고 이분탐색
        // 5.
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // M, N값
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            // 배열에 저장
            int [] snack = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                snack[i] = Integer.parseInt(st.nextToken());
            }

            // 오름차순 정렬
            Arrays.sort(snack);
            // 결과값 출력
            System.out.println(binarySearch(snack));

        }
    }

    // 이분탐색
    public static int binarySearch(int [] array) {
        // 최소길이 1
        int start = 1;
        // 최대 길이 배열 끝값
        int end = array[N-1];
        int result = 0;

        // start <= end 일때 반복
        while(start <= end){
            int mid = (start+end)/2;
            // 조건 여부 확인
            if(canDivide(array, mid)){
                result = mid;
                start = mid+1;
            }
            // 조건에 만족하지 않으면
            else{
                end = mid-1;
            }

        }
        // 결과값 반환
        return result;
    }

    public static boolean canDivide(int [] array, int length){
        int count = 0;
        for(int snack : array){
            count += snack/length;
            if(count >= M)  return true;
        }
        return false;
    }
}
