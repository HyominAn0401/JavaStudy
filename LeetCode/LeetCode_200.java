package LeetCode;

public class LeetCode_200 {
    //dfs의 개수 출력

    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    static boolean [][] visited;
    static int m, n;

    public static void main(String[] args) {
        char [][] grid = {{'1', '1', '0', '0', '0'},{'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid){
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // 방문하지 않은 경우
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }


    // dfs
    public static void dfs(int x, int y, char[][] grid){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx>=0 && ny>=0 && nx<m && ny<n){
                if(!visited[nx][ny] && grid[nx][ny]=='1'){
                    dfs(nx, ny, grid);
                }
            }
        }
    }
}
