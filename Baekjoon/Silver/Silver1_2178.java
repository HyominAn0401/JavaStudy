package Silver;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Silver1_2178 {
    // 이동 인덱스
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    // 미로 이차원 배열
    static int [][] maze;
    // 방문 배열
    static boolean [][] visited;
    // N, M값
    static int N, M;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : BFS로 첫 번째 칸에서 [N][M]칸에 도착할 때까지 지나야 하는 최소한의 칸 수 출력하기
        // 로직 설계
        // 1. N, M 입력받아 방문배열, 미로 배열 초기화
        // 2. BFS(0,0 -> 첫 번째 칸) 실행
        // 2-1. 큐를 생성하고 x, y 인덱스의 배열 큐에 추가 및 방문 업데이트
        // 2-2. 상하좌우를 검사, 조건에 맞으면 depth+1하고 다음 노드 반복
        // 3. 마지막 칸에 도착했을 때 depth 출력

        // try-with-resources
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            // 미로 배열과 이차원 배열 초기화
            maze = new int[N][M];
            visited = new boolean[N][M];

            // 미로 배열에 값 저장
            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<M; j++){
                    maze[i][j] = Integer.parseInt(str.split("")[j]);
                }
            }

            // BFS 0,0으로 호출
            BFS(0,0);
            // 마지막 칸에 도착했을 때 depth 출력
            System.out.println(maze[N-1][M-1]);
        }
    }

    // BFS 메서드
    public static void BFS(int x, int y){
        // 큐 생성
        Queue<int []> queue = new LinkedList<>();
        // 매개변수로 들어온 인덱스 값 큐에 추가
        queue.add(new int[]{x,y});
        // 방문으로 업데이트
        visited[x][y] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 가장 앞에 있는 값
            int [] now = queue.poll();
            // 상하좌우 고려
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                // 조건에 맞으면
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(!visited[nx][ny] && maze[nx][ny]==1){
                        // 큐에 다음 노드 추가
                        queue.add(new int[]{nx, ny});
                        // 방문 업데이트
                        visited[nx][ny] = true;
                        // depth +1 추가 
                        maze[nx][ny] = maze[now[0]][now[1]]+1;
                    }
                }
            }
        }
    }
}
