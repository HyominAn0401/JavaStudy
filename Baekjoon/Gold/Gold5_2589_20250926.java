package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5_2589_20250926 {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static char [][] map;
    static boolean [][] visited;
    static int [][] distance;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            map = new char[N][M];

            for(int i=0; i<N; i++){
                String line = br.readLine();
                for(int j=0; j<M; j++){
                    map[i][j] = line.charAt(j);
                }
            }

            int maxValue = 0;

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    visited = new boolean[N][M];
                    distance = new int[N][M];

                    if(map[i][j]=='L'){
                        maxValue = Math.max(bfs(i, j), maxValue);
                    }
                }
            }
            System.out.print(maxValue);
        }
    }

    public static int bfs(int x, int y){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        int maxValue = 0;

        while(!queue.isEmpty()){
            int[] array = queue.poll();

            for(int i=0; i<4; i++){
                int nx = array[0] + dx[i];
                int ny = array[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<map.length && ny<map[0].length){
                    if(!visited[nx][ny] && map[nx][ny]=='L'){
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[array[0]][array[1]] + 1;

                        maxValue = Math.max(distance[nx][ny], maxValue);
                    }
                }
            }
        }
        return maxValue;
    }
}
