package Silver.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_2644 {

    static int n;
    static int m;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static boolean [][] visited;
    static int [][] canvas;
    static int cnt = 0;
    static int maxArea = 0;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // 다 0으로 초기화
            canvas = new int[n][m];
            // 다 false로 초기화
            visited = new boolean[n][m];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                    canvas[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(!visited[i][j] && canvas[i][j]==1){
                        cnt++;
                        maxArea = Math.max(maxArea, dfs(i, j));

                    }
                }
            }

            System.out.println(cnt);
            System.out.println(maxArea);
        }
    }

    public static int dfs(int x, int y){
        if(visited[x][y])
            return 0;
        visited[x][y] = true;
        int area = 1;

        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >=0 && cx < n && cy >=0 && cy < m && canvas[cx][cy]==1){
                if(!visited[cx][cy]) {
                    area += dfs(cx, cy);
                }
            }
        }

        return area;
    }
}
