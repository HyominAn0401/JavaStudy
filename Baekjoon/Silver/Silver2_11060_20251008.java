package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Silver2_11060_20251008 {
    static int [] maze;
    static int [] dist;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            maze = new int[N+1];
            dist = new int[N+1];
            Arrays.fill(dist, -1);

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                maze[i] = Integer.parseInt(st.nextToken());
            }

            System.out.print(bfs(1));
        }
    }

    public static int bfs(int n){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(n);
        dist[n] = 0;

        while(!deque.isEmpty()){
            int index = deque.pollFirst();
            int value = maze[index];

            if(index==maze.length-1)    return dist[index];

            if(value==0)    continue;

            for(int i=1; i<=value; i++){
                int nextIndex = index + i;
                if(nextIndex <= maze.length-1 && dist[nextIndex]==-1){
                    dist[nextIndex] = dist[index]+1;
                    deque.addLast(nextIndex);
                    if(nextIndex == maze.length-1)  return dist[maze.length-1];
                }
            }
        }
        return -1;
    }
}
