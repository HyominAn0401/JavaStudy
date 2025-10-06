package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_11060_new {
    static int [] maze;
    static int [] count;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            maze = new int[N+1];
            count = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                maze[i] = Integer.parseInt(st.nextToken());
            }

            System.out.print(bfs(1));
        }
    }

    public static int bfs(int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while(!queue.isEmpty()){
            int index = queue.poll();
            int value = maze[index];

            if(value==1){
                count[index+1] = count[index]+1;
                queue.add(index+1);
                continue;
            }

            // 0이나 1이 아닌 경우
            int maxIndex = -1;
            int maxValue = Integer.MIN_VALUE;

            for(int i=1; i<=value; i++){
                int nextIndex = index + i;

                if(nextIndex >= maze.length-1){
                    count[nextIndex] = count[index]+1;
                    return count[nextIndex];
                }
                int nextValue = maze[nextIndex];
                if(maxValue <= nextValue){
                    maxIndex = nextIndex;
                    maxValue = nextValue;
                }
            }
            if(maxValue==0){
                return -1;
            }

            queue.add(maxIndex);
            count[maxIndex] = count[index]+1;
        }
        return -1;
    }
}
