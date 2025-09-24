package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_1912_20250924 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : n개의 정수로 이루어진 수열 중 연속된 수의 합 최대값 출력하기
        // 로직 설계
        // 1. 숫자 배열과 prefix 배열 초기화
        // 2. prefix 배열에 누적합이 현재 숫자보다 더 작은 경우 계산X

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());

            long [] numArray = new long[n];
            long [] prefix = new long[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int i=0; i<n; i++){
//                numArray[i] = Long.parseLong(st.nextToken());
//                prefix[i+1] = prefix[i] + numArray[i];
//            }

            for(int i=0; i<n; i++){
                numArray[i] = Long.parseLong(st.nextToken());
                prefix[i+1] = Math.max(prefix[i]+numArray[i], numArray[i]);
            }

            long resultSum = Long.MIN_VALUE;
//            for(int i=1; i<n; i++){
//                long sum = Long.MIN_VALUE;
//                for(int j=i; j<n+1; j++){
//                    sum = Math.max(prefix[j] - prefix[j-i], sum);
//                }
//                resultSum = Math.max(sum, resultSum);
//            }

            for(int i=1; i<n+1; i++){
                resultSum = Math.max(resultSum, prefix[i]);
            }

            System.out.println(resultSum);
        }
    }
}
