package Silver.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2_1654 {
    public static long K;
    public static void main(String[] args) throws Exception{

        // 구현 및 해야할 것 : 이분탐색으로 N개 길이에 맞게 자를 수 있는 랜선의 최대 길이 출력
        // 로직 설계
        // 1. N, K 입력받고 K 크기의 배열 생성 및 랜선 길이 저장
        // 2. 배열 오름차순 정렬
        // 3. 이분탐색
        // 3-1. mid값을 구해 각 길이에서 나눈 몫 cnt에 누적
        // 3-2. cnt가 N보다 작으면 길이가 길어 N이 안 되는 것이므로 end=mid-1로 조정
        // 3-3. cnt가 N보다 크거나 같으면 answer에 값 저장 후 start=mid+1로 조정

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // K와 N값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Long.parseLong(st.nextToken());
            int N  = Integer.parseInt(st.nextToken());

            // 랜선 길이를 저장할 K 크기 배열 생성
            //int [] lanLength = new int[(int)K];
            long [] lanLength = new long[(int)K];

            // 배열에 랜선 길이 저장
            for(int i=0; i<K; i++){
                lanLength[i] = Long.parseLong(br.readLine());
            }

            // 오름차순 정렬
            Arrays.sort(lanLength);
            // 값 출력
            System.out.println(binarySearch(lanLength, N));

        }
    }

    // 랜선의 최대 길이를 찾아낼 이분탐색 메서드
    // 매개변수로 랜선 길이 배열과 N값
    public static long binarySearch(long [] lanLength, int N){
        // start=1(0만큼 자를 순 없으니까), end=배열에서 가장 큰 길이 로 초기화
        long start = 1, end = lanLength[lanLength.length-1];
        // 값을 리턴할 변수
        long answer = 0;

        // start <= end 일동안 반복
        while(start <= end){
            // N과 비교할 변수
            long cnt =0;
            // mid 값 초기화
            long mid = (start+end)/2;
            // 랜선 길이에서 mid 나눈 몫 누적
            for(long length : lanLength){
                // mid가 0이 아닐 경우에 누적
                if(mid!=0)
                    cnt += (length/mid);
            }
            //System.out.println("cnt: "+cnt);

            // 길이가 너무 길다 : N보다 작다
            if(cnt < N){
                //System.out.println("길이가 너무 길다 : N보다 작다");
                end = mid-1;
            }
            else{
                //System.out.println("cnt가 N보다 크거나 같다.");
                // 값 저장
                answer = mid;
                start = mid+1;
            }
        }

        return answer;
    }

//    public static boolean isOverN(int cnt, int N){
//        if(cnt >= N){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
}
