package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_2468 {
    static int [][] territory;
    static boolean [][] visited;
    static int N;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            N = Integer.parseInt(br.readLine());
            territory = new int[N][N];

            int minHeight = 100, maxHeight = 1;

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    territory[i][j] = Integer.parseInt(st.nextToken());
                    minHeight = Math.min(minHeight, territory[i][j]);
                    maxHeight = Math.max(maxHeight, territory[i][j]);
                }
            }

            int maxSafeZone = 0;

            for(int h=minHeight; h<=maxHeight; h++){
                visited = new boolean[N][N];
                int safeZoneCnt = 0;

                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(!visited[i][j] && territory[i][j] > h){
                            dfs(i, j, h);
                            safeZoneCnt++;
                        }
                    }
                }
                maxSafeZone = Math.max(safeZoneCnt, maxSafeZone);
            }
            System.out.println(maxSafeZone);
        }

    }

    // dfs
    public static void dfs(int x, int y, int height){
        if(visited[x][y]) return;
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<N && ny < N && nx>=0 && ny>=0 && !visited[nx][ny] && territory[nx][ny]>height){
                dfs(nx, ny, height);
            }
        }
    }
}
