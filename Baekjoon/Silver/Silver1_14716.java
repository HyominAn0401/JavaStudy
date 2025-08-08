package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_14716 {
    static int [][] banner;
    static int [] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int [] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static boolean [][] visited;
    static int M, N;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            banner = new int[M][N];
            visited = new boolean[M][N];

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    banner[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(banner[i][j]==1 && !visited[i][j]){
                        count += dfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static int dfs(int x, int y){
        int count = 1;
        visited[x][y] = true;

        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<M && ny<N){
                if(!visited[nx][ny] && banner[nx][ny]==1){
                    count = dfs(nx, ny);
                }
            }
        }

        return count;
    }
}
