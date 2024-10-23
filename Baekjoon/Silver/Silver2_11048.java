package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_11048 {
    // x, y 방향 인덱스
    static int [] dx = {0, 1, 1};
    static int [] dy = {1, 0, 1};

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : (1,1)에서 (N,M)으로 이동할 때까지 가져올 수 있는 가장 큰 사탕의 수 DP로 구하기
        // 로직 설계
        // 1. 미로와 같은 크기의 사탕 배열 생성
        // 2. 미로에 값 입력하고 사탕 배열 첫 위치 초기화
        // 3. 방향 인덱스에 따라 3가지 방향으로 이동했을 때 가져갈 수 있는 사탕의 개수 중 최댓값 저장
        // 4. N, M 위치에서 사탕의 최대값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // N, M 크기의 미로, 사탕 배열
            int [][] maze = new int[N][M];
            int [][] candy = new int[N][M];

            // 미로 배열에 사탕의 개수 입력
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    maze[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 사탕배열 첫 위치 개수 초기화
            candy[0][0] = maze[0][0];

            // 첫 위치에서 미로 끝까지 반복
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    // 3가지 방향으로 이동할 수 있음
                    for(int k=0; k<3; k++){
                        // 다음 i, j 위치
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        // 범위 내에 있다면
                        if(nx>=0 && ny>=0 && nx<N && ny<M){
                            // 최대값 저장
                            candy[nx][ny] = Math.max(candy[nx][ny], (candy[i][j] + maze[nx][ny]));
                        }
                    }
                }
            }
            // 미로 끝 최대값 출력
            System.out.println(candy[N-1][M-1]);
        }
    }
}
