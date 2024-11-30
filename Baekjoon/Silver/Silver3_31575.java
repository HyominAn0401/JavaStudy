package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver3_31575 {
    static int N, M;
    static boolean [][] visited;
    static int [][] city;
    static int [] dx = {1, 0};
    static int [] dy = {0, 1};
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            city = new int[M][N];

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    city[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(bfs(0,0));

        }
    }

    public static String bfs(int x, int y){
        visited = new boolean[M][N];
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()){
            int [] current = queue.poll();
            int current_x = current[0];
            int current_y = current[1];
            if(current_x==M-1 && current_y==N-1 && city[current_x][current_y]==1){
                return "Yes";
            }

            visited[current_x][current_y] = true;

            for(int i=0; i<2; i++){
                int nx = current_x+dx[i];
                int ny = current_y+dy[i];

                if(nx>=0 && ny>=0 && nx<M && ny<N && !visited[nx][ny] && city[nx][ny]==1){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return "No";
    }
}
