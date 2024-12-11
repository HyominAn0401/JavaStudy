package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_16953 {
    static Queue<Node> queue = new LinkedList<>();
    static boolean [] visited;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st= new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            visited = new boolean[1000000001];
            System.out.println(bfs(A, B));
        }
    }

    static long bfs(long a, long b){
        queue.add(new Node(a, 0));
        visited[(int)a] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            long pos = node.position;
            long ti = node.time;

            if(pos == b)    return ti+1;

            long [] move = {pos*2, pos*10+1};
            for(long next : move){
                if(next >= 1 && next <=1000000000 && !visited[(int)next]){
                    queue.add(new Node(next, ti+1));
                    visited[(int)next] = true;
                }
            }
        }
        return -1;
    }

    static class Node{
        long position, time;
        public Node(long position, long time){
            this.position = position;
            this.time = time;
        }
    }
}
