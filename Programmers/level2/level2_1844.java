package level2;

import java.util.LinkedList;
import java.util.Queue;

public class level2_1844 {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        int [][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        System.out.println(solution(maps));
    }

    public static int solution(int [][] maps){
        int result = -1;
        int n= maps.length;
        int m = maps[0].length;
        boolean [][] visited = new boolean[n][m];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            int count = node.getCount();

            if(x==n-1 && y==m-1){
                return count;
            }

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    if(!visited[nx][ny] && maps[nx][ny]==1){
                        queue.add(new Node(nx, ny, count+1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return result;
    }


}
class Node{
    private int x;
    private int y;
    private int count;
    public Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getCount(){
        return count;
    }
}
