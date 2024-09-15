package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_2468_new {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static int [][] territory;
    static boolean [][] visited;
    static int N;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            N = Integer.parseInt(br.readLine());
            territory = new int[N][N];

            int minHeight = 100, maxHeight=1;

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    territory[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, territory[i][j]);
                    minHeight = Math.min(minHeight, territory[i][j]);
                }
            }

            int safeZoneCnt = 0;

            for(int h=0; h<=maxHeight; h++){
                visited= new boolean[N][N];
                int cnt = 0;
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(!visited[i][j] && territory[i][j] > h){
                            cnt++;
                            dfs(i, j, h);
                        }
                    }
                }
                safeZoneCnt = Math.max(safeZoneCnt, cnt);
            }
            System.out.println(safeZoneCnt);
        }
    }

    public static void dfs(int x, int y, int height){
        if(visited[x][y])   return;
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && territory[nx][ny] > height){
                dfs(nx, ny, height);
            }
        }
    }
}
