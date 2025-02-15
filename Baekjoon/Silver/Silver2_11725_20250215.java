package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_11725_20250215 {
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static int [] parentNode;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 트리에서 각 노드의 부모 노드 출력하기
        // 로직 설계
        // 1. 입력값을 받고 그래프를 생성한다.
        // 2. 간선 정보에 따라 인접 리스트에 저장한다. 양방향 간선이므로 각각 노드 모두 반영한다.
        // 3. DFS : 재귀적으로 탐색하면서 탐색이 끝나면 부모 노드를 저장한다.
        //    BFS : 큐에 빈 노드가 없을 때까지 탐색하고 부모 노드를 저장한다.
        // 4. 2번 노드부터 부모 노드 번호를 출력한다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 노드 개수 입력받기
            int N = Integer.parseInt(br.readLine());
            // 그래프를 저장할 인접 리스트 배열
            graph = new ArrayList[N+1];
            // 방문 여부를 확인할 배열
            visited = new boolean[N+1];
            // 부모 노드를 저장할 배열
            parentNode = new int[N+1];

            // 인접 리스트 초기화
            for(int i=1; i<=N; i++){
                graph[i] = new ArrayList<>();
            }

            // 간선 정보 저장
            for(int i=0; i<N-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }

            // dfs 혹은 bfs 실행
            dfs(1,0);
            // bfs(1);

            // 2번 노드부터 부모 노드 출력
            for(int i=2; i<=N; i++){
                System.out.println(parentNode[i]);
            }
        }
    }

    // BFS
    public static void bfs(int n){
        // 큐에 추가
        queue.add(n);

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 노드 poll
            int node = queue.poll();
            // 해당 노드에 연결된 노드 탐색
            for(int num : graph[node]){
                // 방문하지 않은 경우
                if(!visited[num]){
                    // 부모 노드 저장
                    parentNode[num]= node;
                    // 방문으로 업데이트
                    visited[num] = true;
                    // 큐에 해당 노드 추가
                    queue.add(num);
                }
            }
        }
    }

    // DFS
    public static void dfs(int node, int parent){
        // 방문으로 업데이트
        visited[node] = true;
        // 연결된 노드 탐색
        for(int num : graph[node]){
            // 방문하지 않은 경우
            if(!visited[num]){
                // 방문 업데이트
                visited[num] = true;
                // 재귀
                dfs(num, node);
            }
        }
        // 부모 노드 저장
        parentNode[node] = parent;
    }
}
