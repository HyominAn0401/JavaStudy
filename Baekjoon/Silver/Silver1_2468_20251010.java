package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Silver1_2468_20251010 {
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                String line = br.readLine();
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(line.split("")[j]);
                }
            }

            List<Integer> houses = new ArrayList<>();

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        houses.add(dfs(i, j));
                    }
                }
            }

            Collections.sort(houses);
            System.out.println(houses.size());
            for(int a : houses){
                System.out.println(a);
            }
        }
    }

    public static int dfs(int x, int y){
        visited[x][y] = true;
        int house = 1;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<visited.length && ny>=0 && ny<visited.length && !visited[nx][ny] && map[nx][ny]==1){
                visited[nx][ny] = true;
                house += dfs(nx, ny);
            }
        }

        return house;
    }
}
