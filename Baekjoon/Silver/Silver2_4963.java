package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_4963 {
    static int [] dx = {-1, 1, 0, 0, -1 ,-1, 1, 1};
    static int [] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int [][] islands;
    static boolean [][] visited;
    static int h, w;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringBuilder sb = new StringBuilder();
            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                w = Integer.parseInt(st.nextToken());
                h = Integer.parseInt(st.nextToken());
                if(w==0 && h==0)    break;

                islands = new int[h][w];
                visited = new boolean[h][w];

                for(int i=0; i<h; i++){
                    st = new StringTokenizer(br.readLine());
                    for(int j=0; j<w; j++){
                        islands[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                int cnt = 0;

                for(int i=0; i<h; i++){
                    for(int j=0; j<w; j++){
                        if(!visited[i][j] && islands[i][j]==1){
                            cnt++;
                            bfs(i, j);
                        }
                    }
                }
                sb.append(cnt+"\n");
            }
            System.out.print(sb);
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int [] now = queue.poll();
            for(int i=0; i<8; i++){
                int nx = now[0]+dx[i];
                int ny = now[1] + dy[i];

                if(nx<h && ny<w && nx>=0 && ny>=0 && !visited[nx][ny] && islands[nx][ny]==1){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
