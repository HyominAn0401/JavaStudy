package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1_2810 {

    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 사람 수와 좌석을 입력받고 컵홀더를 놓을 수 있는 최대 사람의 수 출력하기
        // 로직 설계
        // 1. 사람 수와 좌석 상태 입력받기
        // 2. 좌석 상태를 분해해 조건에 맞게 처리학
        // 2-1. 좌석이 S면 오른쪽 컵 홀더 개수 추가
        // 2-2. coupleCnt가 0인 상태에서 좌석이 L이면 coupleCnt 증가
        // 2-3. 다음 좌석도 L이니 coupleCnt 증가해 2가 되어 컵홀더 개수 증가 및 0으로 초기화
        // 3. 컵홀더 놓을 수 있는 최대 사람의 수 출력

        // BufferedReader 인스턴스 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 사람 수 및 좌석 입력받기
            int people = Integer.parseInt(br.readLine());
            String seats = br.readLine();

            // L의 개수를 셀 변수와 컵홀더의 개수를 저장할 변수 초기화
            int coupleCnt = 0;
            int cupHolder = 1;

            // 좌석 개수만큼 반복
            for(char seat : seats.toCharArray()){
                // 좌석이 S면 오른쪽 컵홀더 수 증가
                if(seat == 'S')    cupHolder++;
                // 좌석이 L일때
                else if(seat == 'L'){
                    // L값 하나 증가
                    coupleCnt++;
                    // 쌍이 맞춰지면
                    if(coupleCnt==2){
                        // 컵홀더 수 증가
                        cupHolder++;
                        // 초기화
                        coupleCnt = 0;
                    }
                }
            }

            // 컵홀더 수와 사람 수 중 작은 값 출력
            System.out.println(Math.min(cupHolder, people));
        }
    }
}
