package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_1057 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : N명이 토너먼트를 진행할 때 김과 임이 대결하는 라운드 출력하기
        // 로직 설계
        // 1. N, kim, lim 입력받고 메서드 매개변수로 전달
        // 2. kim과 lim은 언젠가 만나게 되므로 그 수가 같지 않을 때까지 값을 갱신하며 반복
        // 3. 값이 같으면 cnt 반환

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, kim, lim 입력받기
            // 해당 코드에서는 N을 사용하지 않음
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int kim = Integer.parseInt(st.nextToken());
            int lim = Integer.parseInt(st.nextToken());

            // 결과 출력
            System.out.println(roundNum(kim, lim));
        }
    }

    // 만나는 라운드 출력 메서드
    public static int roundNum(int kim, int lim){
        // 라운드 수 저장할 변수
        int cnt = 0;

        // 같은 그룹일 때까지 반복
        while(kim != lim){
            kim = (kim+1)/2;
            lim = (lim+1)/2;
            cnt++;
        }

        return cnt;
    }
}
