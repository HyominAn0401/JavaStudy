package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D4_1226 {
    // 미로 배열
    static int [][] maze;
    // 방문 배열
    static boolean [][] visited;
    // 이동 인덱스
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 각 테스트 케이스에서 출발점과 도착점을 구해 BFS로 도착점에 도달할 수 있는가 판별해 출력하는 문제
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 결과값을 저장할 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();
            // 테스트 케이스 별 반복
            for(int t=0; t<10; t++) {
                // 테스트 케이스 입력받기
                int testCase = Integer.parseInt(br.readLine());
                // 미로 배열, 방문 배열 초기화
                maze = new int[16][16];
                visited = new boolean[16][16];
//            int [] start={};
//            int [] end={};
                // 출발점과 도착점 x, y값 저장할 변수
                int start_x = 0, start_y = 0, end_x = 0, end_y = 0;

                // 배열에 값 저장하면서 출발점, 도착점 구하기
                for (int i = 0; i < 16; i++) {
                    String str = br.readLine();
                    for (int j = 0; j < 16; j++) {
                        maze[i][j] = Integer.parseInt(str.split("")[j]);
                        // 값이 2면 출발점 : i, j값 저장
                        if (maze[i][j] == 2) {
//                        start[0] = i;
//                        start[1] = j;
                            start_x = i;
                            start_y = j;
                        }
                        // 값이 3이면 도착점 : i, j값 저장
                        if (maze[i][j] == 3) {
//                        end[0] = i;
//                        end[1] = j;
                            end_x = i;
                            end_y = j;
                        }
                    }
                }

                //BFS(start[0], start[1]);
                // 시작점에서 BFS 실행
                BFS(start_x, start_y);

                //if(maze[end[0]][end[1]]!=2){
                // 도착점 값이 2가 아니면 도달 불가능, 0 저장
                if (maze[end_x][end_y] != 2) {
                    //System.out.println(0);
                    sb.append("#"+testCase+" "+0+"\n");
                } else {
                    // 도착점 값이 2면 도달 가능, 1 저장
                    //System.out.println(1);
                    sb.append("#"+testCase+" "+1+"\n");
                }
            }
            // 결과 출력
            System.out.print(sb);

//            for(int i=0; i<16; i++){
//                for(int j=0; j<16; j++){
//                    System.out.print(maze[i][j]+" ");
//                }
//                System.out.println();
//            }
        }
    }

    // BFS 메서드
    public static void BFS(int x, int y){
        // 큐 생성
        Queue<int []> queue = new LinkedList<>();
        // 큐에 매개변수 인덱스 추가
        queue.add(new int[]{x, y});
        // 방문배열에 업데이트
        visited[x][y] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 큐에서 poll
            int [] now = queue.poll();
            // 상하좌우
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                // 조건에 만족하면
                if(nx>=0 && ny>=0 && nx<16 && ny<16 && !visited[nx][ny]){
                    // 값이 0이거나 3이면
                    // 0이면 이동 가능, 3이면 도착점
                    if(maze[nx][ny]==0 || maze[nx][ny]==3) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        maze[nx][ny] = maze[now[0]][now[1]];
                    }
                }
            }
        }
    }
}
