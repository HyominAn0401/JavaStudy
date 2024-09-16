package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Silver1_2667_bfs {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static int N;
    static int [][] house;
    static boolean [][] visited;
    static int [] bfsHouseCont;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            N = Integer.parseInt(br.readLine());

            house = new int[N][N];
            visited = new boolean[N][N];

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    house[i][j] = Integer.parseInt(str.split("")[j]);
                }
            }

            int bfsCount = 0;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && house[i][j]==1){
                        bfsCount++;
                        sb.append(bfs(i, j)+" ");
                    }
                }
            }

            bfsHouseCont = new int[bfsCount];

            for(int i=0; i<bfsCount; i++){
                bfsHouseCont[i] = Integer.parseInt(sb.toString().split(" ")[i]);
            }
            Arrays.sort(bfsHouseCont);

            System.out.println(bfsCount);
            for(int x : bfsHouseCont)
                System.out.println(x);
        }
    }

    static int bfs(int x, int y){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int cnt = 1;

        while(!queue.isEmpty()){
            int [] node = queue.poll();
            for(int i=0; i<4; i++){
                int nx = node[0]+dx[i];
                int ny = node[1]+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && house[nx][ny]==1){
                    cnt++;
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny]=true;
                }
            }
        }
        return cnt;
    }
}
