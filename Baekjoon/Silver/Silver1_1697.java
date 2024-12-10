package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_1697 {
    static Queue<Node> queue = new LinkedList<>();
    static boolean [] visited;
    static int N, K;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            visited = new boolean[100001];

            System.out.println(bfs(N));
        }
    }

    public static int bfs(int n){
        queue.add(new Node(N, 0));
        visited[N] = true;

        while(true){
            Node node = queue.poll();
            int pos = node.position;
            int ti = node.time;

            if(pos==K)  return ti;

            int [] move = {pos-1, pos+1, pos*2};
            for(int next : move){
                // (!visited[next]&&next>=0 && next<=100000) 차이 비교 -> ArrayIndexOutofBounds 에러
                if(next>=0 && next<=100000 &&!visited[next]){
                    queue.add(new Node(next, ti+1));
                    visited[next] = true;
                }
            }
        }
    }
}

class Node{
    int position, time;

    public Node(int position, int time){
        this.position = position;
        this.time = time;
    }
}
