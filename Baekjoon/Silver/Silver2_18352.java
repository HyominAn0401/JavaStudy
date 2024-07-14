package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_18352 {

    public static int N, M, K, X;
    public static boolean [] visited;
    public static ArrayList<Edge> [] neighbors;
    public static PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
    public static int distance[];

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            // 방문 배열 초기화
            visited = new boolean[N+1];
            neighbors = new ArrayList[N+1];
            // 거리 배열 초기화
            distance = new int[N+1];

            // 인접 리스트 초기화 1
            for(int i=1; i<N+1; i++){
                neighbors[i] = new ArrayList<Edge>();
            }

            // 인접 리스트 초기화 2
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                neighbors[s].add(new Edge(e,1));
            }

            // 거리 배열 초기화
            for(int i=0; i<N+1; i++){
                distance[i] = Integer.MAX_VALUE;
            }

            // 인접리스트, 방문배열까지 초기화 완료
            // 다익스트라 알고리즘
            queue.add(new Edge(X, 0));
            while(!queue.isEmpty()){
                Edge current = queue.poll(); // ex. (1,0)
                int currentNode = current.vertex; //1
                int currentValue = current.value; //0

                if(!visited[currentNode]) //방문 안함?
                    visited[currentNode] = true;

                for(int i=0; i<neighbors[currentNode].size(); i++){
                    int nextNode = neighbors[currentNode].get(i).vertex;
                    int nextValue = neighbors[currentNode].get(i).value;

                    if(!visited[nextNode] && (currentValue+nextValue < distance[nextNode])){
                        distance[nextNode] = currentValue + nextValue;
                        queue.add(new Edge(nextNode, distance[nextNode]));
                    }
                }
            }

            // distance 배열에서 K값인 i 출력하기, 없으면 -1 출력하기
            Queue<Integer> resultQueue = new LinkedList<Integer>();
            for(int i=1; i<distance.length; i++){
                if(distance[i] == K){
                    resultQueue.add(i);
                }
            }

            if(resultQueue.isEmpty()){
                System.out.println(-1);
                return;
            }

            while(!resultQueue.isEmpty()){
                System.out.println(resultQueue.poll());
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int vertex, value;
    Edge(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    public int compareTo(Edge e){
        if(this.value > e.value) return 1;
        else return -1;
    }
}