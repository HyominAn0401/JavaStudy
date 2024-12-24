package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Silver1_12852_help {
    static Queue<Node> queue = new LinkedList();
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            int [] path = new int[N+1];

            int result = bfs(N, path);
//            for(int num : path){
//                System.out.println(num);
//            }
            System.out.println(result);
            printPath(N, path);

//            System.out.println(sb.toString().trim());
        }
    }

    static int bfs(int start, int [] path){
        queue.add(new Node(start, 0));

        boolean [] visited = new boolean[start+1];
        visited[start] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int n = node.number;

            if(n==1) return node.depth;

            if(n%3==0 && !visited[n/3]){
                queue.add(new Node(n/3, node.depth+1));
                visited[n/3] = true;
                path[n/3] = n;
            }
            if(n%2==0 && !visited[n/2]){
                queue.add(new Node(n/2, node.depth+1));
                visited[n/2] = true;
                path[n/2] = n;
            }
            if (n-1>0 && !visited[n-1]){
                queue.add(new Node(n-1, node.depth+1));
                visited[n-1] = true;
                path[n-1] = n;
            }
        }
        return -1;
    }

    static void printPath(int n, int [] path){
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        while(n!=0){
            list.addFirst(n);
            n = path[n];
        }
        for(int num : list){
            sb.append(num+" ");
        }
        System.out.println(sb.toString().trim());
    }

    static class Node{
        int number;
        int depth;

        public Node(int number, int depth){
            this.number = number;
            this.depth = depth;
        }
    }
}
