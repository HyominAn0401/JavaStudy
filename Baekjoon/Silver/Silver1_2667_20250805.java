package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Silver1_2667_20250805 {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static char [][] house;
    static boolean [][] visited;
    static int N;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            N = Integer.parseInt(br.readLine());
            house = new char[N][N];
            visited = new boolean[N][N];
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<N; i++){
                String str = br.readLine();
                house[i] = str.toCharArray();
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && house[i][j]=='1'){
                        list.add(dfs(i, j));
                    }
                }
            }

            int size = list.size();
            int [] array = new int[size];
            for(int i=0; i<size; i++){
                array[i] = list.get(i);
            }
            Arrays.sort(array);
            StringBuilder sb = new StringBuilder();

            sb.append(size+"\n");

            for(int n : array){
                sb.append(n+"\n");
            }

            System.out.print(sb);
        }
    }
    public static int dfs(int x, int y){
        int count = 1;
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(house[nx][ny]=='1' && !visited[nx][ny]){
                    count += dfs(nx, ny);
                }
            }
        }
        return count;
    }
}
