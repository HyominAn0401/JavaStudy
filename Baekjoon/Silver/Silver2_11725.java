package Silver.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_11725 {
    static ArrayList<Integer>[] graph;
    static boolean [] visited;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        // 구현 및 해야할 것 : 루트가 1인 트리에서 DFS를 이용해 각 노드의 부모 노드 번호를 출력하기
        // 로직 설계
        // 1. N 입력받고 인접 리스트, 방문 배열, 부모 노드 번호를 저장할 배열을 생성하고 초기화한다. 인접 리스트에 각 노드를 저장한다.
        // 2. dfs(1)을 실행하고, 방문하지 않은 노드에 대해 재귀한다. 해당 과정에서 각 노드의 부모 노드 번호를 저장한다.
        // 3. 결과값을 출력한다.

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 노드의 개수 N값 입력받기
            int N = Integer.parseInt(br.readLine());

            // 인접 리스트, 방문 배열, 부모 노드 번호 저장 배열 초기화
            graph = new ArrayList[N+1];
            visited = new boolean[N+1];
            parent = new int[N+1];

            // 인접 리스트 초기화
            for(int i=1; i<=N; i++){
                graph[i] = new ArrayList<Integer>();
            }

            // 인접 리스트에 노드 저장
            for(int i=0; i<N-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }

            // 트리 루트 1로 DFS 시작
            dfs(1);

            // 2번 노드부터 부모 노드 번호 출력
            for(int i=2; i<=N; i++){
                System.out.println(parent[i]);
            }
        }
    }

    // DFS 실행 메서드
    public static void dfs(int v){
        // 현재 노드를 방문한 경우 종료
        if(visited[v]) return;
        // 방문하지 않았으면 true로 업데이트
        visited[v] = true;

        // 현재 노드의 인접 리스트 노드 반복
        for(int x : graph[v]){
            // 방문하지 않았으면
            if(!visited[x]) {
                // 인접 리스트 노드의 부모 노드 저장
                parent[x] = v;
                // 재귀 실행
                dfs(x);
            }
        }
    }
}
