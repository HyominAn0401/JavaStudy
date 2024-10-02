package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Silver3_2193 {
    // Memory Exceeded
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : DP를 이용해 N자리 이친수의 개수 출력
        // 로직 설계
        // 1. N값을 입력받고 자리별 이친수를 저장할 ArrayList 배열과 개수를 저장할 배열 생성
        // 2. 1자리수 값을 초기화, 각 자리별 이친수 저장
        // 3. N자리 이친수의 개수 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값 입력받기
            int N = Integer.parseInt(br.readLine());
            // N+1 크기의 이친수를 저장할 ArrayList 배열 생성
            ArrayList<String> [] dp = new ArrayList[N+1];
            // 자리별 이친수의 개수를 저장할 배열 생성
            int [] count = new int[N+1];

            // 리스트 배열 초기화
            for(int i=1; i<=N; i++){
                dp[i] = new ArrayList<>();
            }

            // 1자리 수 초기화
            dp[1].add("1");
            count[1] = 1;

            // ArrayList를 돌면서 이친수 생성 및 저장
            for(int i=2; i<=N; i++){
                // 자리별 이친수 개수를 저장할 변수
                int cnt = 0;
                // 이전 자릿수 숫자로 판단
                for(String x : dp[i-1]){
                    //System.out.println("x: "+x);
                    //System.out.println(x.charAt(x.length()-1));
                    // 맨 끝값이 0이면
                    if(x.charAt(x.length()-1)=='0'){
                        // 0과 1을 붙이고 개수 +2
                        dp[i].add(x+"0");
                        dp[i].add(x+"1");
                        cnt += 2;
                    }
                    // 끝값이 1이면
                    else{
                        // 0 붙이고 +1
                        dp[i].add(x+"0");
                        cnt++;
                    }
                }
                // 해당 자리수에 이친수의 개수 저장
                count[i] = cnt;
            }
            // N자리수 이친수 개수 출력
            System.out.println(count[N]);
//            for(int i=1; i<N+1; i++){
//                System.out.println("i: "+i);
//                for(String x : dp[i]){
//                    System.out.print(x+" ");
//                }
//                System.out.println();
//            }
        }
    }
}
