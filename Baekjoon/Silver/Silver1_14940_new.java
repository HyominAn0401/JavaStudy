package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_14940_new {
    // 이동 인덱스
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    // n, m값
    static int n, m;
    // 지도 배열
    static int [][] map;
    // 방문 배열
    static boolean [][] visited;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : BFS로 깊이를 구해 출력하고 방문하지 않은 값은 -1로 출력하기
        // 로직 설계
        // 1. 지도 배열, 방문 배열 초기화 및 값 저장
        // 2. 시작점 2를 찾아 0으로 저장
        // 3. 시작점에서 BFS 실행. 1이고 방문하지 않은 노드의 경우 깊이 누적
        // 4. BFS 종료 후 결과값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // n, m값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            // 배열 초기화
            map = new int[n][m];
            visited = new boolean[n][m];
            // 시작 노드 인덱스 저장할 변수
            int start_x=0, start_y=0;

            // 이차원 배열에 값 저장
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    // 시작점 구하기
                    if(map[i][j]==2){
                        start_x = i;
                        start_y = j;
                    }
                }
            }

            // 시작점 0으로 업데이트
            map[start_x][start_y] = 0;
            // 시작점에서 BFS 실행
            BFS(start_x, start_y);

            // 결과 출력
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    // 방문하지 않았고 값이 1이면
                    if(!visited[i][j] && map[i][j]==1){
                        // -1로 업데이트
                        map[i][j] = -1;
                    }
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }

        }
    }

    // BFS 메서드
    public static void BFS(int x, int y){
        // 큐 생성
        Queue<int []> queue = new LinkedList<>();
        // 큐에 노드 추가
        queue.add(new int[]{x, y});
        // 방문 처리
        visited[x][y] = true;

        // 큐가 빌 때까지 바복
        while(!queue.isEmpty()){
            // 맨 앞 노드 poll
            int [] now = queue.poll();

            // 상하좌우
            for(int i=0; i<4; i++){
                int nx = now[0]+dx[i];
                int ny = now[1] + dy[i];
                // 조건에 만족하면
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && map[nx][ny]==1){
                    // 큐에 넣고 방문처리
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    // 깊이 누적
                    map[nx][ny] = map[now[0]][now[1]]+1;
                }
            }
        }
    }
}
