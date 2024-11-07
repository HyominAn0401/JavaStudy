package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class D3_9229 {
    // 과자 2봉지 무게를 선택할 배열
    static int [] selected = new int[2];
    // 과자 무게 저장 배열
    static int [] snacks;
    // N, M값
    static int N, M;
    // 최대 무게를 저장할 변수
    static int maxWeight;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 각 테스트 케이스 별 M 무게가 넘지 않는 2개 과자 무게 합의 최대값 출력하기
        // 로직 설계
        // 1. 테스트 케이스 별 반복, N 크기의 배열 초기화
        // 2. 과자 무게 오름차순 정렬
        // 3. 재귀로 과자 무게 선택 모든 경우의 수 구하고 최대값 비교
        // 4. 각 테스트 케이스 별 최대 무게 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스트 케이스 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과값을 저장할 StringBuilder 객체
            StringBuilder resultSb = new StringBuilder();
            // 테스트 케이스만큼 반복
            for(int i=1; i<=testCase; i++){
                // 각 테스트 케이스 maxWeight MIN_VALUE 값으로 초기화
                maxWeight = Integer.MIN_VALUE;
                // N, M값 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                // N 크기 배열로 초기화
                snacks = new int[N];

                // 배열에 과자 무게 값 저장
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    snacks[j] = Integer.parseInt(st.nextToken());
                }

                // 오름차순 정렬
                Arrays.sort(snacks);

                // 모든 경우의 수에 따른 최대 무게값 구하기
                generateMaxWeight(0,0);

                // maxWeight 값이 MIN_VALUE 값이 아니라면
                // 값이 변했으면
                if(maxWeight!=Integer.MIN_VALUE){
                    // 테스트 케이스 별 값 저장
                    resultSb.append("#"+i+" "+maxWeight+"\n");
                }
                // 값이 변하지 않았으면
                else {
                    // -1 저장
                    resultSb.append("#"+i+" -1\n");
                }

            }
            // 결과 출력
            System.out.print(resultSb);
        }
    }

    // 과자 무게별 모든 경우의 수
    public static void generateMaxWeight(int start, int depth){
        // 깊이가 2가 되면
        if(depth==2){
            // 값을 비교할 sum 변수 0으로 초기화
            int sum = 0;
            // 선택한 과자 무게 합 구하기
            for(int num : selected){
                sum += num;
            }

            // M값보다 sum이 작거나 같으면
            if(sum <= M){
                // maxWeight와 비교해 더 큰 값 저장
                maxWeight = Math.max(maxWeight, sum);
            }
            // 종료
            return;
        }

        // start부터 N-1까지 반복
        // 경우의 수가 오름차순으로 나오도록
        for(int i=start; i<N; i++){
            // 해당 깊이에 과자 무게 저장
            selected[depth] = snacks[i];
            // 재귀
            generateMaxWeight(i+1, depth+1);
        }
    }
}
