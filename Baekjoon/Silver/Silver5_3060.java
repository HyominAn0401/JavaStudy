package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_3060 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 6마리 돼지의 요구를 모두 들어줄 수 없는 날 출력하기
        // 로직 설계
        // 1. 각 테스트 케이스 별 사료 양을 저장할 배열 2개 생성
        // 2. feed 배열에 사료의 양 저장
        // 3. 첫날 모든 요구를 들어줄 수 없는 경우 1 출력
        // 4. 다음날 돼지의 요구 사료양 구해 nextFeed 배열에 저장
        // 5. total 값이 N보다 크면 day 추가하고 종료

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 테스트 케이스 입력받기
            int T = Integer.parseInt(br.readLine());
            // 결과를 저장할 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // 테스트 케이스 반복
            for (int t = 0; t < T; t++) {
                // 사료 양 입력받기
                long N = Long.parseLong(br.readLine());
                // 사료 양 저장할 배열 2개 생성
                long[] feed = new long[6];
                long[] nextFeed = new long[6];

                // 배열에 사료 저장
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < 6; i++) {
                    feed[i] = Integer.parseInt(st.nextToken());
                }

                // 일수를 저장할 변수
                int day=0;
                // 사료의 전체 값
                long total = 0;
                // 전체 사료 양 구하기
                for (long f : feed)
                    total += f;

                // 첫날 불가능하면 1 출력
                if (total > N) {
                    sb.append("1\n");
                    continue;
                }

                // 반복
                while (true) {
                    // 각 돼지별 사료 요구량 구하기
                    for(int i=0; i<6; i++){
                        nextFeed[i] =feed[i]+feed[(i+1)%6] + feed[(i+5)%6] + feed[(i+3)%6];
                    }

                    // 전체 사료량 구하기
                    total = 0;
                    for(int i = 0; i < 6; i++){
                        feed[i] = nextFeed[i];
                        total += nextFeed[i];
                    }

                    day++;
                    if (total > N){
                        sb.append((day + 1)).append("\n");
                        break;
                    }
                }
            }
            System.out.print(sb);
        }
    }
}
