package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_18352 {

    // 도시 개수, 도로 개수, 거리 정보, 출발 도시 번호
    public static int N, M, K, X;
    // 방문 배열
    public static boolean [] visited;
    // 인접 리스트
    public static ArrayList<Edge> [] neighbors;
    // 우선순위 큐
    public static PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
    // 거리 배열
    public static int distance[];

    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 연결 그래프를 입력받고 싲가 노드에서 최단 거리가 K인 도시 번호 출력하기, 없으면 -1 출력하기
        // 로직 설계
        // 1. 도시 개수, 도로 개수, 거리 정보, 출발 도시 번호 입력받고 우선순위 큐, 인접 리스트, 방문 배열, 거리 배열 초기화
        // 2. 인접 리스트에 도로 번호와 가중치 저장, 거리 배열 MAX값으로 초기화
        // 3. 다익스트라 실행
        // 3-1. 출발 노드 큐에 넣고, 큐가 빌 때까지 반복
        // 3-2. poll한 노드가 방문하지 않은 경우 방문 갱신
        // 3-3. 연결된 인접 리스트 개수만큼 반복, 다음 노드가 방문한 적 없고 가중치+현재 거리 < 다음노드 거리배열 값 이면 가중치+현재노드 거리배열 값으로 갱신
        // 4. 결과 인덱스 큐에 넣고 빌 때까지 출력, 없는 경우 -1 출력

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 도시 개수, 도로 개수, 거리 정보, 출발 도시 번호 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            // 방문 배열 초기화
            visited = new boolean[N+1];
            // 인접 리스트
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
                // 단방향 그래프
                neighbors[s].add(new Edge(e,1));
            }

            // 거리 배열 초기화
            for(int i=0; i<N+1; i++){
                // 큰 값으로 초기화
                distance[i] = Integer.MAX_VALUE;
            }

            // 다익스트라 알고리즘 실행
            // 출발 노드 큐에 넣고 시작
            queue.add(new Edge(X, 0));
            // 큐가 빌 때까지 반복
            while(!queue.isEmpty()){
                // 맨 앞 노드 poll
                Edge current = queue.poll(); // ex. (1,0)
                // 노드의 번호와 가중치
                int currentNode = current.vertex; //1
                int currentValue = current.value; //0

                // 방문하지 않은 경우 업데이트
                if(!visited[currentNode])
                    visited[currentNode] = true;

                // 노드의 인접리스트 개수만큼 반복
                for(int i=0; i<neighbors[currentNode].size(); i++){
                    // 해당 노드의 인접 리스트 노드, 가중치
                    int nextNode = neighbors[currentNode].get(i).vertex;
                    int nextValue = neighbors[currentNode].get(i).value;

                    // 방문한 적이 없고 현재가중치+거리배열값 < 다음노드 거리배열 값
                    if(!visited[nextNode] && (currentValue+nextValue < distance[nextNode])){
                        // 거리배열 값 갱신
                        distance[nextNode] = currentValue + nextValue;
                        // 큐에 갱신된 가중치를 포함한 노드 추가
                        queue.add(new Edge(nextNode, distance[nextNode]));
                    }
                }
            }

            // distance 배열에서 K값인 i 출력하기, 없으면 -1 출력하기
            // 큐 생성
            Queue<Integer> resultQueue = new LinkedList<Integer>();
            // K인 값이 있는 경우 큐에 인덱스 추가
            for(int i=1; i<distance.length; i++){
                if(distance[i] == K){
                    resultQueue.add(i);
                }
            }

            // 큐가 빈 경우 = K인 값이 없는 경우 -> -1 출력하고 종료
            if(resultQueue.isEmpty()){
                System.out.println(-1);
                return;
            }

            // 큐가 빌 때까지 인덱스 출력
            while(!resultQueue.isEmpty()){
                System.out.println(resultQueue.poll());
            }
        }
    }
}

// 가중치 있는 그래프 담기 위한 노드 클래스 구현
class Edge implements Comparable<Edge>{
    // 노드, 가중치
    int vertex, value;
    Edge(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    // 우선순위 큐 정렬 기준을 위해 compareTo 함수 구현
    public int compareTo(Edge e){
        if(this.value > e.value) return 1;
        else return -1;
    }
}