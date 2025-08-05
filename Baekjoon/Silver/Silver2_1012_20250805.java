package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_1012_20250805 {
    static int M, N;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static int [][] farm;
    static boolean [][] visited;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int t=0; t<testCase; t++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                M = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
                int cabbage = Integer.parseInt(st.nextToken());

                farm = new int[M][N];
                visited = new boolean[M][N];

                for(int i=0; i<cabbage; i++){
                    st = new StringTokenizer(br.readLine());
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());
                    farm[s][e] = 1;
                }

                int count = 0;

                for(int i=0; i<M; i++){
                    for(int j=0; j<N; j++){
                        if(farm[i][j]==1 && !visited[i][j]){
                            dfs(i, j);
                            count++;
                        }
                    }
                }

                sb.append(count+"\n");

            }
            System.out.print(sb.toString());
        }
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<M && ny<N){
                if(!visited[nx][ny] && farm[nx][ny]==1){
                    dfs(nx, ny);
                }
            }
        }
    }
}
