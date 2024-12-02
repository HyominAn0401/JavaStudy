package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver2_24482 {
    static ArrayList<Integer> [] graph;
    static int N, M, R;
    static boolean [] visited;
    static int [] depth;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : N, M과 시작 정점을 받고 깊이 우선 탐색을 실행해 깊이 출력하기
        // 로직 설계
        // 1. N, M, M 입력받기
        // 2. graph, depth, visited 배열 초기화
        // 3. graph 내림차순 정렬
        // 4. R 시작점에서 DFS 실행
        // 5. 모든 노드 깊이 저장 후 출력하기

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M, R값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            // 그래프
            graph = new ArrayList[N+1];
            // 노드 깊이를 저장할 배열
            depth = new int[N+1];
            // 방문 배열
            visited = new boolean[N+1];

            // 배열 초기화
            for(int i=1; i<=N; i++){
                graph[i] = new ArrayList<>();
                // 노드 깊이 -1로 초기화
                depth[i] = -1;
            }

            // 인접 정점 저장
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }

            // 내림차순 정렬
            for(int i=1; i<=N; i++){
//                Collections.reverse(graph[i]);
                Collections.sort(graph[i], Collections.reverseOrder());
            }

            // 시작 정점과 높이 전달
            dfs(R, 0);

            // 깊이 출력
            for(int i=1; i<=N; i++){
                System.out.println(depth[i]);
            }
        }
    }

    // DFS 메서드
    public static void dfs(int start, int d){
        // 방문 업데이트
        visited[start] = true;
        // 현재 높이 저장
        depth[start] = d;
        //System.out.println(start);
        // 인접 정점에 대해 반복
        for(int x : graph[start]){
            // 방문하지 않았으면
            if(!visited[x]){
                // 깊이+1로 dfs 재귀
                dfs(x, d+1);
            }
        }
    }
}
