package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Silver1_2178_deque {
    static int N, M;
    static char [][] map;
    static int [][] dist;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            dist = new int[N][M];

            for(int i=0; i<N; i++){
                Arrays.fill(dist[i], -1);
            }

            for(int i=0; i<N; i++){
                String line = br.readLine();
                for(int j=0; j<M; j++){
                    map[i][j] = line.charAt(j);
                }
            }

            System.out.println(bfs(0, 0));
        }
    }

    public static int bfs(int a, int b){
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(a, b));
        dist[a][b] = 1;

        while(!deque.isEmpty()){
            Node node = deque.pollFirst();
            int x = node.x;
            int y = node.y;

            for(int i=0; i<4; i++){
                int next_X = x + dx[i];
                int next_Y = y + dy[i];

                if(next_X >=0 && next_X<N && next_Y>=0 && next_Y<M){
                    if(map[next_X][next_Y]=='1' && dist[next_X][next_Y]==-1){
                        dist[next_X][next_Y] = dist[x][y] + 1;
                        deque.add(new Node(next_X, next_Y));

                        if(next_X==N-1 && next_Y==M-1){
                            return dist[N-1][M-1];
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
