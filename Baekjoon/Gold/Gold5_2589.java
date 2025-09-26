package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5_2589 {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    static String [][] map;
    static boolean [][] visited;
    static int [][] distance;

    static int N, M;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new String[N][M];

            for(int i=0; i<N; i++){
                String line = br.readLine();
                for(int j=0; j<M; j++){
                    map[i][j] = line.split("")[j];
                }
            }

            int maxValue = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    visited = new boolean[N][M];
                    distance = new int[N][M];
                    if(map[i][j].equals("L")){
                        maxValue = Math.max(maxValue, bfs(i, j));
                        //System.out.println("map["+i+"]["+j+"] : "+maxValue);
                    }
                }
            }

            System.out.print(maxValue);
        }
    }

    public static int bfs(int x, int y){
        int maximum = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(!visited[nx][ny] && map[nx][ny].equals("L")){
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[node.x][node.y]+1;
                        if(distance[nx][ny] > maximum)
                            maximum = distance[nx][ny];
                    }
                }
            }
        }
        return maximum;
    }

    public static class Node{
        private int x;
        private int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
