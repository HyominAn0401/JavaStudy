package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold5_1916 {
    static class Edge implements Comparable<Edge>{
        int vertex, value;

        public Edge(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }

        // 우선 순위 큐 정렬 기준을 위한 compareTo 함수
        public int compareTo(Edge e) {
            if(this.value > e.value)    return 1;
            else return -1;
        }
    }

    public static int N, M;
    public static int distance[];
    public static boolean visited[];
    public static ArrayList<Edge>[] neighbors;

    public static void main(String[] args) {

        // 구현 및 해야할 것 : 도시와 버스 개수, 인접 리스트, 출발도시와 도착도시를 입력받고 다익스트라를 이용해 출발도시에서 도착 도시까지 최소 비용 구하기
        // 로직 설계
        // 1. 도시, 버스개수, 비용, 출발도시, 도착 도시를 입력받기
        // 2. 방문배열, 최단거리배열, 인접 리스트 초기화
        // 2-1. 방문배열 : N+1 크기로 초기화
        // 2-2. 최단거리배열 : N+1 크기, MAX_VALUE로 최대한 큰 값으로 초기화
        // 2-3. 각 인덱스 별 인접리스트 생성, 입력받은 값으로 초기화
        // 3. 우선순위 큐를 생성하고 시작값 푸시, 시작 노드 최단거리 배열 값 0
        // 4. 큐가 빌 때까지 다음 과정을 반복
        // 4-1. 가장 앞의 값 poll, 방문한 적이 있으면 continue, 없을 때 true로 갱신
        // 4-2. 인접 리스트에서 값을 추출해 다음 노드를 방문한 적이 없고, 선택노드 최단배열값 + 가중치 < 다음노드 최단거리배열값 이면 값 갱신
        // 4-3. 갱신한 값으로 큐에 새롭게 푸시하기
        // 5. 도착 도시 최단거리배열값 출력

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 도시 개수, 버스 개수 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());

            // 자료구조 초기화
            visited = new boolean[N+1];
            neighbors = new ArrayList[N+1];
            distance = new int[N+1];

            // 인접 리스트 생성
            for(int i=1; i<N+1; i++){
                neighbors[i] = new ArrayList<>();
            }

            // 최단거리 배열 값 최대한 큰 값으로 초기화
            for(int i=1; i<N+1; i++){
                distance[i] = Integer.MAX_VALUE;
            }

            // 인접 리스트 입력받아 값 저장
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                neighbors[s].add(new Edge(e, v));
            }

            // 출발, 도착 도시 입력받기
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 우선순위 큐 생성
            PriorityQueue<Edge> queue = new PriorityQueue<>();

            // 시작 엣지 생성 후 큐에 푸시
            queue.add(new Edge(start,0));
            // 시작 노드의 최단거리배열 값 0으로 초기화
            distance[start] = 0;

            // 우선순위 큐가 빌 때까지 반복
            while(!queue.isEmpty()){
                // 가장 첫 번째 엣지 poll
                Edge current = queue.poll();
                // 노드 번호와 가중치
                int currentNode = current.vertex;
                int currentValue = current.value;
                // 방문한 적이 있으면 continue;
                if(visited[currentNode]) continue;
                // 방문배열 true로 업데이트
                visited[currentNode] = true;

                // 인접 리스트 별 작업 반복
                for(Edge edge : neighbors[currentNode]){
                    // 다음 노드 번호
                    int nextNode = edge.vertex;
                    // 다음 노드 가중치 + 선택 노드 가중치 값 저장
                    int nextValue = edge.value + currentValue;

                    // 다음 노드를 방문한 적이 없고 다음 노드의 최단거리배열 값이 더 크면
                    if(!visited[nextNode]&&(nextValue < distance[nextNode])){
                        // 최단거리배열 값 업데이트
                        distance[nextNode] = nextValue;
                        // 큐에 푸시하기
                        queue.add(new Edge(nextNode, nextValue));
                    }
                }
            }

            // 도착 도시까지 최단거리 출력
            System.out.println(distance[end]);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
