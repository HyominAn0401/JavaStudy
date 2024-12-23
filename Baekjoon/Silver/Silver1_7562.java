package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_7562 {
    static Queue<Node> queue;
    static int [][] chess;
    static boolean [][] visited;
    static int [] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int [] dy = {1, 2, 2, 1, -1, -2, -2 ,-1};

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringBuilder sb = new StringBuilder();
            int testCase = Integer.parseInt(br.readLine());
            for(int t = 0; t<testCase; t++){
                int I = Integer.parseInt(br.readLine());
                queue = new LinkedList<>();
                chess = new int[I][I];
                visited = new boolean[I][I];

                int start_x=0, start_y=0;
                int end_x=0, end_y=0;

                StringTokenizer st = new StringTokenizer(br.readLine());
                start_x = Integer.parseInt(st.nextToken());
                start_y = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(br.readLine());
                end_x = Integer.parseInt(st.nextToken());
                end_y = Integer.parseInt(st.nextToken());

                queue.add(new Node(start_x, start_y, 0));

                sb.append(bfs(end_x, end_y)+"\n");
            }
            System.out.print(sb);
        }
    }

    public static int bfs(int end_x, int end_y){
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.x == end_x && node.y == end_y)
                return node.depth;

            visited[node.x][node.y] = true;

            for(int i=0; i<8; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx>=0 && ny>=0 && nx<chess.length && ny<chess.length && !visited[nx][ny]){
                    queue.add(new Node(nx, ny, node.depth+1));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    static class Node{
        private int x;
        private int y;
        private int depth;

        public Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
