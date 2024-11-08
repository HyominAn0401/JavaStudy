package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D4_1249 {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    //static boolean [][] visited;
    static int [][] road;
    static int N;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int t=1; t<=testCase; t++){
                N = Integer.parseInt(br.readLine());
                road = new int[N][N];

                for(int i=0; i<N; i++){
                    String str = br.readLine();
                    for(int j=0; j<str.length(); j++){
                        road[i][j] = Integer.parseInt(str.split("")[j]);
                    }
                }

                sb.append("#"+t+" "+bfs(new int[]{0,0})+"\n");
            }
            System.out.print(sb);
        }
    }

    public static int bfs(int[] start){
        int sum = 0;
        //int minValue = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        //visited = new boolean[N][N];
        int [][] cost = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        queue.add(start);
        cost[0][0] = road[0][0];

        while(!queue.isEmpty()){
            int[] element = queue.poll();
            int x = element[0];
            int y = element[1];
            //visited[x][y] = true;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N){
                    //visited[nx][ny] = true;
                    int nextCost = cost[x][y] + road[nx][ny];
                    //sum += road[nx][ny];
//                    if(road[nx][ny] + road[x][y] <= sum){
//                        road[nx][ny] += road[x][y];
//                        //minValue = road[nx][ny];
//                        //visited[nx][ny] = true;
//                        queue.add(new int[]{nx, ny});
//                    }
                    if(nextCost < cost[nx][ny]){
                        cost[nx][ny] = nextCost;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return cost[N-1][N-1];
    }
}
