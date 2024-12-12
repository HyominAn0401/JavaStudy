package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver3_25418 {
    static Queue<Node> queue = new LinkedList<>();
    static boolean [] visited;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            visited = new boolean[1000001];
            System.out.println(bfs(A, K));
        }
    }

    static int bfs(int a, int k){
        queue.add(new Node(a, 0));
        visited[a] = true;

        while(true){
            Node node = queue.poll();
            int pos = node.position;
            int ti = node.time;

            if(pos==k)  return ti;

            int [] move = {pos+1, pos*2};
            for(int next : move){
                if(next >= 1 && next<=1000000 && !visited[next]){
                    queue.add(new Node(next, ti+1));
                    visited[next] = true;
                }
            }
        }
    }

    static class Node{
        int position, time;
        public Node(int position, int time){
            this.position = position;
            this.time = time;
        }
    }
}
