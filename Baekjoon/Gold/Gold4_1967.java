package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold4_1967 {
    static ArrayList<Node>[] tree;
    static int [] distance;
    static boolean [] visited;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            tree = new ArrayList[N+1];

            for(int i=1; i<=N; i++){
                tree[i] = new ArrayList<>();
            }

            for(int i=0; i<N-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                tree[s].add(new Node(e, dist));
                tree[e].add(new Node(s, dist));
            }


            int maxRadius = 0;
            for(int i=1; i<=N; i++){
                visited = new boolean[N+1];
                distance = new int[N+1];
                maxRadius = Math.max(maxRadius, bfs(i));
            }

            System.out.print(maxRadius);
        }
    }

    public static int bfs(int n){
        Queue<Node> queue = new LinkedList<>();
        visited[n] = true;
        queue.add(new Node(n, 0));
        int maxValue = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int num = node.node;

            for(Node node1: tree[num]){
                int nextNum = node1.node;
                int nextDistance = node1.dist;

                if(!visited[nextNum]){
                    visited[nextNum] = true;
                    queue.add(node1);
                    distance[nextNum] = distance[num] + nextDistance;
                }

                maxValue = Math.max(maxValue, distance[nextNum]);
            }
        }

        return maxValue;
    }

    public static class Node{
        private int node;
        private int dist;

        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}
