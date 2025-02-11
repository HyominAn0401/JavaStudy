package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_10157 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 시계방향으로 대기번호가 주어질 때 K번 사람의 위치 출력
        // 로직 설계
        // 1. R*C 크기의 좌석 배열 생성 및 상, 우, 하, 좌 dx, dy 인덱스 배열 생성
        // 2. 시계방향으로 돌아가면서 배열에 값 저장
        // 3. 범위를 넘어가거나 이미 있는 자리면 방향 조정
        // 4. K 번째 대기번호의 위치 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 상, 우, 하, 좌 이동 인덱스
            int [] dx = {-1, 0, 1, 0};
            int [] dy = {0, 1, 0, -1};
            // 방향을 나타낼 변수
            int dir = 0;

            // C, R 입력받아 배열 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int [][] seats = new int[R][C];
            // K값
            int K = Integer.parseInt(br.readLine());

            // 첫 칸에 먼저 배정
            int cnt = 1;
            seats[0][0] = cnt;

            // 인덱스
            int x=0, y=0;

            // 범위를 넘어가면 0 출력
            if((C*R) < K)
                System.out.println(0);
            else {
                while (cnt < K) {
                    // 다음 위치
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    // 범위를 넘어가면 방향 조정
                    if (nx < 0 || ny < 0 || nx >= C || ny >= R || seats[ny][nx] != 0) {
                        dir = (dir + 1) % 4;
                        nx = x + dx[dir];
                        ny = y + dy[dir];
                    }

                    x = nx;
                    y = ny;
                    cnt++;
                    // 배열에 다음 대기번호 저장
                    seats[ny][nx] = cnt;
                }

                // 출력
                System.out.println((x + 1) + " " + (y + 1));
            }
        }
    }
}
