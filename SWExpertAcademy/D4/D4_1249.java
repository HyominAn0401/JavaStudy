package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D4_1249 {
    // x, y 인덱스
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    //static boolean [][] visited;
    // 2차원 배열
    static int [][] road;
    static int N;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : BFS로 탐색해 걸리는 최소한의 수 출력
        // 로직 설계
        // 1. N값 입력받고 배열에 값 저장
        // 2. 매개 변수로 시작 배열값 전달
        // 3. BFS로 탐색, cost 배열을 두고 최솟값 저장
        // 4. 최솟값 출력
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스트 케이스 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과값을 저장할 StringBuilder
            StringBuilder sb = new StringBuilder();
            // 테스트 케이스 반복
            for(int t=1; t<=testCase; t++){
                // N값 입력받고 배열 초기화
                N = Integer.parseInt(br.readLine());
                road = new int[N][N];

                // 배열에 값 저장
                for(int i=0; i<N; i++){
                    String str = br.readLine();
                    for(int j=0; j<str.length(); j++){
                        road[i][j] = Integer.parseInt(str.split("")[j]);
                    }
                }

                // sb에 결과값 저장
                sb.append("#"+t+" "+bfs(new int[]{0,0})+"\n");
            }
            // 출력
            System.out.print(sb);
//            for(int i=0; i<N; i++){
//                for(int j=0; j<N; j++){
//                    System.out.print(cost[i][j])
//                }
//            }
        }
    }

    // BFS 메서드
    public static int bfs(int[] start){
        int sum = 0;
        //int minValue = Integer.MAX_VALUE;
        // 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        //visited = new boolean[N][N];
        // 최저값을 저장할 cost 배열
        int [][] cost = new int[N][N];
        // 가장 큰 수로 초기화
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        // 시작값 추가
        queue.add(start);
        // 최소 비용 첫 번째 값으로 업데이트
        cost[0][0] = road[0][0];

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 맨 앞의 노드 poll
            int[] element = queue.poll();
            int x = element[0];
            int y = element[1];
            //visited[x][y] = true;

            // 상하좌우 반복
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 조건에 만족하면
                if(nx>=0 && ny>=0 && nx<N && ny<N){
                    //visited[nx][ny] = true;
                    // 누적합
                    int nextCost = cost[x][y] + road[nx][ny];
                    //sum += road[nx][ny];
//                    if(road[nx][ny] + road[x][y] <= sum){
//                        road[nx][ny] += road[x][y];
//                        //minValue = road[nx][ny];
//                        //visited[nx][ny] = true;
//                        queue.add(new int[]{nx, ny});
//                    }
                    // 최소값이면
                    if(nextCost < cost[nx][ny]){
                        cost[nx][ny] = nextCost;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }


//        for(int i=0; i<N; i++){
//            for(int j=0;j<N; j++){
//                System.out.print(cost[i][j]+" ");
//            }
//            System.out.println();
//        }
        return cost[N-1][N-1];
    }
}
