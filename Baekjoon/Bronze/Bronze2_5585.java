package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2_5585 {

    public static void main(String[] args) throws IOException {
        // 구현 및 해야할 것 : 받을 잔돈에 포함된 잔돈의 개수를 출력한다
        // 로직 설계
        // 1. 1000 - 입력받은 값, 잔돈의 개수를 구할 변수 초기화
        // 2. 거스름돈 개수가 가장 적게 잔돈 계산
        // 3. 잔돈의 개수 출력하기

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 지불할 돈 입력받기
            int pay = Integer.parseInt(br.readLine());

            // 거스름돈 계산
            int total = 1000-pay;
            // 잔돈 개수 저장할 변수
            int cnt=0;

            // 거스름돈 배열에 저장 - 내림차순
            int [] coins = {500, 100, 50, 10, 5, 1};

            // 거스름돈에 따라 잔돈 계산
            for(int coin : coins){
                cnt += total/coin;
                total = total % coin;
            }

            // 출력
            System.out.println(cnt);
        }
    }
}
