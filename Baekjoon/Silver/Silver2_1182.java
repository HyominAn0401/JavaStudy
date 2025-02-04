package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_1182 {
    static int N, S;
    static int cnt = 0;
    static int [] numbers;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 공집합을 제외한 부분 수열을 구하고 합이 S가 되는 경우의 수 출력하기
        // 로직 설계
        // 1. N, S를 입력받고 N 크기 정수 배열에 정수값 저장
        // 2. 현재 인덱스 0, 총합 0, 선택된 수의 개수 0을 매개변수로 부분수열을 찾는 메서드 호출
        // 3. 공집합을 제외한 모든 부분 수열을 구하고 합을 구함
        // 4. 값이 S와 같은 경우 cnt 증가

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, S 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            // N 크기 정수 배열 생성
            numbers = new int[N];

            // 배열에 정수값 저장
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // 초기값 호출
            findSequence(0, 0, 0);

            // 결과 출력
            System.out.println(cnt);

        }

    }

    // 백트래킹으로 부분 수열을 찾고 탐색이 끝났을 때 합이 S와 같고 count가 0보다 큰 경우 cnt를 증가시키는 메서드
    static void findSequence(int index, int sum, int count){
        // 탐색이 끝난 경우
        if(index == N){
            // 조건을 만족하면 cnt 증가
            if(sum==S && count>0){
                cnt++;
            }
            return;
        }

        // 해당 수를 선택한 경우
        findSequence(index+1, sum+numbers[index], count+1);

        // 해당 수를 선택하지 않은 경우
        findSequence(index+1, sum, count);
    }
}
