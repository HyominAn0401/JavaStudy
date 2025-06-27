package AlgorithmPracticeKit.DFSBFS;
import java.util.Queue;
import java.util.LinkedList;

public class level2_1844 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps){
        visited = new boolean[maps.length][maps[0].length];
        queue.add(new Node(0,0, 1));
        visited[0][0] = true;

        return bfs(maps);
    }

    public static int bfs(int [][]maps){
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            // 종료조건 필요
            if(x==maps.length-1 && y==maps[0].length-1){
                return node.distance;
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && ny>=0 && nx<maps.length && ny<maps[0].length){
                    if(!visited[nx][ny] && maps[nx][ny]!=0){
                        visited[nx][ny]= true;
                        queue.add(new Node(nx, ny, node.distance+1));
                    }
                }
            }
        }
        return -1;

    }

    static class Node{
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
