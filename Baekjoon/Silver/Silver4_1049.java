package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Silver4_1049 {
    public static void main(String[] args) throws IOException {
        // 구현 및 해야할 것 : N개 기타줄을 사기 위한 최소한의 비용 계산해 출력하기
        // 로직 설계
        // 1. N과 M을 입력받고 M크기의 6개묶음 가격과 낱개 가격을 저장할 배열을 각각 생성한다.
        // 2. 배열에 각 값을 저장하고 오름차순으로 정렬한다.
        // 3. N이 6보다 작은 경우과 큰 경우를 나눠 계산한다.
        // 3-1. 6보다 작은 경우 : 패키지 가격과 낱개*N 가격 중 작은 값을 택한다.
        // 3-2. 6보다 큰 경우 : 몫과 나머지 값을 구하고 6개패키지+낱개 / 6개 패키지만 / 낱개로만 경우를 나눠 계산한다.

        // BufferedReader 인스턴스 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N(사야할 기타줄)과 M(브랜드 수) 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 가격을 저장할 배열 각각 생성
            int [] sixStrings = new int[M];
            int [] oneString = new int[M];

            // M번 반복해 값 저장하기
            for(int i=0; i<M; i++){
                // 배열에 6개 패키지 가격과 낱개 가격 저장하기
                st = new StringTokenizer(br.readLine());
                sixStrings[i] = Integer.parseInt(st.nextToken());
                oneString[i] = Integer.parseInt(st.nextToken());
            }

            // 오름차순 정렬
            Arrays.sort(sixStrings);
            Arrays.sort(oneString);

            // 최소비용을 저장할 변수 초기화
            int money = 0;

            // N이 6보다 작거나 같은 경우
            if(N <= 6){
                // 패키지 가격과 낱개 가격 중 작은 값
                money = Math.min(sixStrings[0], oneString[0]*N);
            }
            // N이 6보다 큰 경우
            else{
                // 몫과 나머지 계산
                int q = N/6;
                int remainder = N%6;

                // 각 케이스 별 가격 계산
                // 6개 패키지와 낱개로 구매할 때
                int case1 = sixStrings[0]*q + oneString[0]*remainder;
                // 6개 패키지로만 구매할 때
                int case2 = sixStrings[0] * (q+1);
                // 낱개로만 구매할 때
                int case3 = oneString[0]*N;

                // 최소값 저장하기
                money = case1<=case2?case1:case2;
                money = money<=case3?money:case3;
            }

            // 출력 
            System.out.println(money);
        }
    }
}
