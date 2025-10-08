package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Silver1_5014_arraydeque {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int F = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int answer = bfs(F, S, G, U, D);
            if(answer == -1)
                System.out.println("use the stairs");
            else System.out.println(answer);
        }
    }

    public static int bfs(int F, int S, int G, int U, int D){
        Deque<Integer> deque = new ArrayDeque<>();
        if(S == G)  return 0;

        int [] building = new int[F+1];
        Arrays.fill(building, -1);

        int [] elevator = {U, -D};

        deque.addLast(S);
        building[S] = 0;

        while(!deque.isEmpty()){
            int floor = deque.pollFirst();
            for(int i=0; i<elevator.length; i++){
                int nextFloor = floor + elevator[i];
                if(nextFloor>=1 && nextFloor<=F && building[nextFloor]==-1){
                    building[nextFloor] = building[floor]+1;
                    deque.addLast(nextFloor);
                    if(G == nextFloor){
                        return building[G];
                    }
                }
            }
        }
        return -1;
    }
}
