package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5_1240 {
    // N, M값 변수
    static int N, M;
    // 정수 배열을 저장할 ArrayList 배열
    static ArrayList<int []> [] graph;
    // 방문 배열
    static boolean [] visited;
    // 거리 배열
    static int [] distance;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 노드로 구성된 트리에서 두 노드 사이의 거리를 BFS로 구해 출력
        // 로직 설계
        // 1. 노드 수와 노드 쌍, 거리를 입력받아 트리를 생성
        // 2. BFS로 거리를 알고자 하는 노드 번호를 매개변수로 입력받아 거리 구하기

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 노드 개수, 노드 쌍의 개수 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            // 결과를 저장할 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // 인접 리스트 초기화
            graph = new ArrayList[N+1];
            //visited = new boolean[N+1];
            //distance = new int[N+1];

            // 인접 리스트 초기화
            for(int i=1; i<=N; i++){
                graph[i] = new ArrayList<>();
            }

            // N-1 줄에 트리상 연결된 두 점과 거리 입력받아 인접 리스트에 추가
            for(int i=0; i<N-1; i++){
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                graph[node1].add(new int[]{node2, dist});
                graph[node2].add(new int[]{node1, dist});
            }

            // M개 노드 쌍 입력받아 BFS 매개변수로 전달
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                sb.append(BFS(s, e)+"\n");
            }

            // 결과 출력
            System.out.print(sb);
        }
    }

    // BFS 메서드
    public static int BFS(int s, int e){
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        // 방문 배열, 거리 배열 초기화
        visited = new boolean[N+1];
        distance = new int[N+1];

        // 큐에 해당 노드 추가
        queue.add(s);
        // 방문 처리
        visited[s] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 가장 앞의 값 poll
            int node = queue.poll();

            // graph[node] 배열에서 반복
            for(int [] x : graph[node]){
                // 해당 노드를 방문하지 않았으면
                if(!visited[x[0]]) {
                    // 방문 업데이트
                    visited[x[0]] = true;
                    // 큐에 추가
                    queue.add(x[0]);
                    // 거리배열에 거리 누적합
                    distance[x[0]] = distance[node]+x[1];
                }
            }
        }
        // 결과값 리턴
        return distance[e];
    }
}
