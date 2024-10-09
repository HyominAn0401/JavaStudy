package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_21736 {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static char [][] campus;
    static int N, M;
    static boolean [][] visited;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            campus = new char[N][M];

            int start_x=0, start_y=0;

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<M; j++){
                    campus[i][j] = str.charAt(j);
                    if(campus[i][j]=='I') {
                        start_x=i;
                        start_y=j;
                    }
                }
            }

            if(BFS(start_x, start_y)!=0){
                System.out.println(BFS(start_x, start_y));
            }
            else{
                System.out.println("TT");
            }
        }
    }

    public static int BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][M];

        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 0;

        while(!queue.isEmpty()){
            int [] location = queue.poll();

            for(int i=0; i<4; i++){
                int next_X = location[0]+dx[i];
                int next_Y = location[1]+dy[i];

                if(next_X>=0 && next_Y>=0 && next_X<N && next_Y<M && campus[next_X][next_Y]!='X' && !visited[next_X][next_Y]){
                    queue.add(new int[]{next_X, next_Y});
                    visited[next_X][next_Y] = true;
                    if(campus[next_X][next_Y]=='P')
                        cnt++;
                }
            }
        }
        return cnt;
    }
}
