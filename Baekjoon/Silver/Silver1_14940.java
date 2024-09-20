package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_14940 {
    static int n, m;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static int [][] map;
    static boolean [][] visited;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            int start_x=0, start_y=0;

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==2){
                        start_x = i;
                        start_y = j;
                    }
                }
            }

            map[start_x][start_y] = 0;

            BFS(start_x, start_y);

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(!visited[i][j] && map[i][j]==1){
                        map[i][j] = -1;
                    }
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    public static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int [] now = queue.poll();

            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && map[nx][ny]==1){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    map[nx][ny] = map[now[0]][now[1]]+1;
                }
            }
        }
        }
}
