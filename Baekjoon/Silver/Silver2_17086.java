package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_17086 {
    static int [][] cost;
    static int N, M;
    static int [] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int [] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st=  new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int [][] babyShark = new int[N][M];
            cost = new int[N][M];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    babyShark[i][j] = Integer.parseInt(st.nextToken());
                    if(babyShark[i][j]==1) {
                        cost[i][j] = 0;
                    }
                    else{
                        cost[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    bfs(new int[]{i,j});
                }
            }
            int maxValue = Integer.MIN_VALUE;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    maxValue = Math.max(cost[i][j], maxValue);
                }
            }
            System.out.println(maxValue);
        }
    }

    public static void bfs(int []element){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(element);

        while(!queue.isEmpty()){
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int i=0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M && cost[nx][ny]!=0){
                    cost[nx][ny] = Math.min(cost[nx][ny], cost[x][y]+1);
                    System.out.println(cost[nx][ny]);
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
