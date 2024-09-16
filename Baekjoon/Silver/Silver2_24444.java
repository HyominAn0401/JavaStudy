package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_24444 {
    // 인접 리스트
    static ArrayList<Integer> [] graph;
    // 방문 배열
    static boolean [] visited;
    // N, M값
    static int N, M;
    // 방문 순서 저장 배열
    static int [] visitOrder;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 그래프를 입력받고 BFS로 노드를 방문할 때 각 노드의 방문 순서를 출력하기
        // 로직 설계
        // 1. N, M, R값 입력받아 인접 리스트, 방문배열 초기화
        // 2. 인접 리스트에 정점 저장
        // 3. 인접 리스트 오름차순 정렬
        // 4. BFS로 방문 순서 저장 및 출력


        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M, R값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            // 인접 리스트, 방문 배열, 방문 순서 배열 초기화
            graph = new ArrayList[N+1];
            visited = new boolean[N+1];
            visitOrder = new int[N+1];

            // 인접 리스트 초기화
            for(int i=1; i<=N; i++){
                graph[i] = new ArrayList<Integer>();
            }

            // 인접 리스트에 정점 저장
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }

            // 인접 리스트 오름차순 정렬
            for(int i=1; i<=N; i++){
                Collections.sort(graph[i]);
                // 내림차순 - 24445
                //Collections.sort(graph[i], Comparator.reverseOrder());
            }

            // 시작점 R에서 BFS 실행
            bfs(R);

            // 모든 노드 탐색
            for(int i=1; i<=N; i++){
                // 방문했으면 출력
                if(visited[i]){
                    System.out.println(visitOrder[i]);
                }
                // 방문 안했으면 시작 정점에서 방문할 수 없는 경우이므로 0 출력
                else{
                    System.out.println(0);
                }
            }

        }
    }

    // bfs 메서드
    static void bfs(int v){
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        // 시작 노드 큐에 추가
        queue.add(v);
        // 방문으로 업데이트
        visited[v] = true;
        // 방문 순서르 저장할 cnt 변수 초기화
        int cnt = 1;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 큐 가장 앞의 값
            int n = queue.poll();
            // 방문 순서에 저장
            visitOrder[n] = cnt++;
            // 인접 노드 반복
            for(int x : graph[n]){
                // 방문한 적 없으면 큐에 추가하고 방문으로 업데이트
                if(!visited[x]){
                    queue.add(x);
                    visited[x] = true;
                }
            }
        }
    }
}
