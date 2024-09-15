package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_1260 {

    // 방문 배열
    static boolean [] visited;
    // 인접 리스트 배열
    static ArrayList<Integer> [] graph;
    // 출력값을 저장할 dfs, bfs StringBuilder 객체
    static StringBuilder dfsStringBuilder = new StringBuilder();
    static StringBuilder bfsStringBuilder = new StringBuilder();
    // N, M, V 변수
    static int N, M, V;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 그래프와 시작정점을 입력받고 DFS, BFS를 실행한 결과를 각각 출력한다.
        // 로직 설계
        // 1. N, M, V를 입력받고 인접리스트, 방문배열 초기화
        // 2. 인접리스트 오름차순 정렬
        // 3. DFS, BFS 실행한 결과값 출력

        // try-with-resources
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M, V 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            // 인접리스트 배열 초기화
            graph = new ArrayList[N+1];

            // 인접리스트 초기화
            for(int i=1; i<=N; i++){
                graph[i] = new ArrayList<Integer>();
            }

            // 그래프 초기화
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }

            // 인접리스트 오름차순 정렬
            for(int i=1; i<=N; i++){
                Collections.sort(graph[i]);
            }

            // dfs 실행
            // 방문배열 초기화
            visited = new boolean[N+1];
            dfs(V);
            System.out.println(dfsStringBuilder);

            // bfs 실행
            // 방문배열 초기화
            visited = new boolean[N+1];
            bfs(V);
            System.out.print(bfsStringBuilder);
        }
    }

    // DFS 메서드
    public static void dfs(int n){
        // 방문했으면 종료
        if(visited[n]) return;

        // 방문으로 업데이트
        visited[n] = true;
        // dfsStringBuilder에 공백 포함 추가
        dfsStringBuilder.append(n+" ");

        // 인접 리스트 요소들
        for(int x : graph[n]){
            // 방문한 적 없으면
            if(!visited[x]){
                // 재귀 실행
                dfs(x);
            }
        }
    }

//    public static void bfs(int n){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(n);
//        visited[n] = true;
//
//        while(!queue.isEmpty()){
//            for(int x : graph[n]){
//                if(!visited[x]){
//                    queue.add(x);
//                    visited[x] = true;
//                }
//            }
//            bfsStringBuilder.append(queue.poll()+" ");
//            if(!queue.isEmpty()) {
//                n = queue.peek();
//            }
//            else    break;
//        }
//    }

    // BFS 메서드
    public static void bfs(int n){
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        // 해당 노드 큐에 넣기
        queue.add(n);
        // 방문으로 업데이트
        visited[n] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 현재 노드
            int now_node = queue.poll();
            // 추가
            bfsStringBuilder.append(now_node+" ");
            // 인접 리스트 요소들
            for(int x : graph[now_node]){
                // 방문한 적 없으면
                if(!visited[x]){
                    // 방문 업데이트
                    visited[x] = true;
                    // 큐에 추가
                    queue.add(x);
                }
            }
        }
    }
}
