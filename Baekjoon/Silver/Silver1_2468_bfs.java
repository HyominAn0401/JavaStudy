package Silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Silver1_2468_bfs {
    static int [][] territory;
    static boolean [][] visited;
    static int N;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            N = Integer.parseInt(br.readLine());
            territory = new int[N][N];

            int maxHeight = Integer.MIN_VALUE;

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    territory[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, territory[i][j]);
                }
            }

            int maxValue = 0;
            for(int h=0; h<=maxHeight; h++){
                int maxCount = 0;
                visited = new boolean[N][N];
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(!visited[i][j] && territory[i][j] > h){
                            maxCount++;
                            bfs(i, j, h);
                        }
                    }
                }
                maxValue = Math.max(maxCount, maxValue);
            }

            System.out.println(maxValue);
            //System.out.println(maxCount);
        }
    }

    static void bfs(int x, int y, int height){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        //int cnt = 1;

        while(!queue.isEmpty()){
            int [] now = queue.poll();
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && territory[nx][ny]>height){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    //System.out.println("nx: "+nx+", ny: "+ny+", cnt: "+cnt);
                }
            }
        }
        //System.out.println("x: "+x+", y: "+y+", cnt: "+cnt);
        //return cnt;
    }
}
