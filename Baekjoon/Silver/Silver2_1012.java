package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_1012 {
    // 이동 벡터
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    // 배추 저장할 이차원 배열
    static int [][] cabbage;
    // 방문 배열
    static boolean [][] visited;
    // 가로, 세로, 배추 수
    static int M, N, K;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : DFS로 배추가 심어져 있는 연결된 땅의 개수 출력하기
        // 로직 설계
        // 1. 각 테스트 케이스 별 M, N, K 입력받아 배열 생성해 값 저장
            // -> 가로 세로 위치 변경
        // 2. 배추가 심어져 있는 위치에 1 저장
        // 3. DFS로 1이 연결된 횟수 계산

        // try-with-resources
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스트 케이스 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과값을 저장할 stringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // 테스트 케이스 반복
            for(int t=0; t<testCase; t++){
                // M, N, K 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                M = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());

                // 배열 초기화
                cabbage = new int[N][M];
                visited = new boolean[N][M];

                // 배추가 저장된 위치 받아 1 저장
                for(int i=0; i<K; i++){
                    st = new StringTokenizer(br.readLine());
                    int y = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());
                    cabbage[x][y] = 1;
                }

                // dfs 횟수를 저장할 변수
                int cnt = 0;

                // 배열의 모든 곳 탐색
                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        // 방문하지 않았고 값이 1이면
                        if(!visited[i][j] && cabbage[i][j]==1){
                            // 횟수 증가
                            cnt++;
                            // dfs 실행
                            dfs(i, j);
                        }
                    }
                }
                // 결과값 sb에 추가
                sb.append(cnt+"\n");
            }
            // 결과값 출력
            System.out.print(sb);
        }
    }

    // dfs 메서드
    public static void dfs(int x, int y){
        // 방문한 적 있으면 종료
        if(visited[x][y])   return;
        // 아니면 방문으로 업데이트
        visited[x][y] = true;

        // 상하좌우 탐색
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 다음 위치가 배열을 벗어나지 않고 방문하지 않았고 값이 1이면
            if(nx>=0 && ny>=0 && nx <N && ny<M && !visited[nx][ny] && cabbage[nx][ny]==1){
                // dfs 실행
                dfs(nx, ny);
            }
        }
    }
}
