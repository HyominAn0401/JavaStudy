package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold4_1753 {

    static class Edge implements Comparable<Edge>{
        int vertex, value;
        public Edge(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }

        public int compareTo(Edge e){
            if(this.value > e.value)    return 1;
            else    return -1;
        }
    }

    // 방문 배열
    public static int distance[];
    public static ArrayList<Edge>[] neighbors;
    public static boolean visited[];
    public static int V, E, K;

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            visited = new boolean[V+1];
            neighbors = new ArrayList[V+1];
            distance = new int[V+1];

            // 최단거리배열 큰 값으로 초기화
            for(int i=1; i<V+1; i++){
                distance[i] = Integer.MAX_VALUE;
            }

            // 인접 리스트 초기화
            for(int i=1; i<V+1; i++){
                neighbors[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                neighbors[s].add(new Edge(e, v));
            }

            PriorityQueue<Edge> queue = new PriorityQueue<>();
            queue.add(new Edge(K, 0));
            distance[K]= 0;

            while(!queue.isEmpty()){
                Edge current = queue.poll();
                int currentNode = current.vertex;
                int currentValue = current.value;
                if(visited[currentNode])    continue;
                visited[currentNode] = true;

                for(Edge edge : neighbors[currentNode]){
                    int nextNode = edge.vertex;
                    int nextValue = edge.value + currentValue;

                    if(nextValue < distance[nextNode]){
                        distance[nextNode] = nextValue;
                        queue.add(new Edge(nextNode, distance[nextNode]));
                    }
                }
            }

            for(int i=1; i<=V; i++){
                if(visited[i])
                    System.out.println(distance[i]);
                else System.out.println("INF");

            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
