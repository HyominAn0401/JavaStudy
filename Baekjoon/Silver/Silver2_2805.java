package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2_2805 {
    public static void main(String[] args) throws IOException {
        // 구현 및 해야할 것 : 나무를 H 높이에서 잘라서 남은 것들의 합이 M이 되는 최대 H값 구하기
        // 로직 설계
        // 1. N, M을 입력받고 N 크기의 배열 생성 수 숫자 저장
        // 2. 해당 배열 오름차순 정렬
        // 3. left=1, right=배열의 최대값 으로 두고 이분탐색

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 나무 높이를 저장할 배열 생성
            long [] tree = new long[N];

            // 배열에 나무 높이 저장
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                tree[i] = Integer.parseInt(st.nextToken());
            }

            // 오름차순 정렬
            Arrays.sort(tree);
            // H 값 구하기 위한 left, right 초기화
            int left = 1;
            int right = (int)tree[N-1];

            long sum =0;
            int mid=0;

            // 이분탐색
            while(left <= right){
                // 총합 계산할 변수 초기화
                sum = 0;
                // mid값 초기화
                mid = (left+right)/2;
                // 배열 내 계산
                for(int i=0; i<N; i++){
//                    tree[i] -= mid;
//                    if(tree[i] > 0)
//                        sum += tree[i];
                    // 높이가 mid보다 크면
                    if(tree[i] > mid)
                        // mid값을 빼서 sum에 누적
                        sum += tree[i] - mid;
                }
                // 합이 M보다 작을때
                if(sum < M)
                    right = mid-1;
                // 그 외
                else
                    left = mid+1;

            }

            // 결과값 출력
            System.out.println(right);

        }
    }

}
