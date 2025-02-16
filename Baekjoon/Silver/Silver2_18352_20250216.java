package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Silver2_18352_20250216 {
    static int N, M, K, X;
    // 인접리스트 배열
    static ArrayList<Integer> [] graph;
    // 방문 여부
    static boolean [] visited;
    // 거리
    static int [] distance;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 출발 도시에서 거리가 K인 도시들 오름차순 출력
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            // 초기화
            graph = new ArrayList[N+1];
            distance = new int[N+1];
            visited = new boolean[N+1];

            // 인접 리스트 초기화 및 거리 배열 최대값 저장
            for(int i=1; i<=N; i++){
                graph[i] = new ArrayList<>();
                distance[i] = Integer.MAX_VALUE;
            }

            // 간선 정보 추가
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
            }

            // 다익스트라 실행
            dijkstra(X);

            // K인 값 출력
            boolean found = false;
            for(int i=1; i<=N; i++){
                if(distance[i] == K){
                    System.out.println(i);
                    found = true;
                }
            }

            // 없으면 -1 출력
            if(!found)
                System.out.println(-1);

        }
    }

    // 다익스트라 메서드
    public static void dijkstra(int start){
        // 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 큐에 노드 추가
        pq.add(new Node(start, 0));
        // 처음 노드 거리 0
        distance[start] = 0;

        // 큐가 빌 때까지 반복
        while(!pq.isEmpty()){
            Node current = pq.poll();
            int nodeVertex = current.vertex;
            int nodeDistance = current.distance;

            // 방문했으면 넘어가기
            if(visited[nodeVertex])
                continue;
            visited[nodeVertex] = true;

            // 연결된 노드에 대해 탐색
            for(int num : graph[nodeVertex]){
                int numDistance = nodeDistance+1;
                if(numDistance <distance[num]){
                    distance[num] = numDistance;
                    pq.add(new Node(num, numDistance));
                }
            }
        }
    }

    // 노드
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;
        Node(int vertex, int distance) {
            this.vertex=vertex;
            this.distance=distance;
        }

        public int compareTo(Node other) {
            return this.distance-other.distance;
        }
    }
}
