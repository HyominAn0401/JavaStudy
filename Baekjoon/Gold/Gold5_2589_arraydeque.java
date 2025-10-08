package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Gold5_2589_arraydeque {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static char [][] map;
    static int [][] dist;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            dist = new int[N][M];

            for(int i=0; i<map.length; i++){
                String line = br.readLine();
                for(int j=0; j<map[0].length; j++){
                    map[i][j] = line.charAt(j);
                }
            }

            int answer = 0;

            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[0].length; j++){
                    if(map[i][j]=='L'){
                        for(int k=0; k<dist.length; k++){
                            Arrays.fill(dist[k], -1);
                        }
                        answer = Math.max(bfs(i, j), answer);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static int bfs(int n, int w){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int []{n, w});
        dist[n][w] = 0;

        int maxValue = Integer.MIN_VALUE;

        while(!deque.isEmpty()){
            int [] nextNode = deque.pollFirst();
            int x = nextNode[0];
            int y = nextNode[1];

            for(int i=0; i<4; i++){
                int next_X = x + dx[i];
                int next_Y = y + dy[i];

                if(next_X>=0 && next_X<map.length && next_Y>=0 && next_Y<map[0].length){
                    if(map[next_X][next_Y]=='L' && dist[next_X][next_Y]==-1){
                        deque.add(new int[]{next_X, next_Y});
                        dist[next_X][next_Y] = dist[x][y] + 1;
                        maxValue = Math.max(dist[next_X][next_Y], maxValue);
                    }
                }
            }
        }
        return maxValue;
    }
}
