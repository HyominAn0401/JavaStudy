package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Silver1_12852 {
    static Queue<Node> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            //Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(N, 0));

            int [] path = new int[N+1];

            System.out.println(bfs(path));
//            System.out.print(sb);
            //System.out.println(dfs(N, 0));
        }
    }

    static int bfs(int [] path){
        boolean [] visited = new boolean[path.length];

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int n = node.number;

            if(node.number==1)  return node.depth;

            if(!visited[n]) {
                if (n % 3 == 0) {
                    queue.add(new Node(n / 3, node.depth + 1));
                    //sb.append((n/3) + " ");
                }
                if (n % 2 == 0) {
                    queue.add(new Node(n / 2, node.depth + 1));
                    sb.append((n / 2) + " ");
                }
                queue.add(new Node(n - 1, node.depth + 1));
                sb.append((n - 1) + " ");
            }
        }
        return -1;
    }

    static int dfs(int n, int depth){

        if(n==1)    return depth;
        if(n%3==0)  dfs(n/3, depth+1);
        if(n%2==0)  dfs(n/2, depth+1);
        dfs(n-1, depth+1);

        return -1;
    }

    static class Node{
        private int number;
        private int depth;

        public Node(int number, int depth){
            this.number = number;
            this.depth = depth;
        }
    }
}
