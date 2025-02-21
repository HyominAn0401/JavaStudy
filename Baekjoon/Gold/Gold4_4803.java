package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Gold4_4803 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 그래프를 탐색해 트리의 개수 출력하기
        // 로직 및 설계
        // 1. 각 테스트 케이스에서 정점과 간선 개수를 입력받고 인접 리스트로 구현하고 그래프를 생성
        // 2. 1부터 n까지 노드를 BFS로 탐색. 방문하지 않은 노드의 경우 BFS를 실행하고, 메서드를 통해 연결 요소가 트리인지 확인
        // 3. 트리 개수가 0, 1, 2이상인 경우를 나눠 다른 문장을 출력

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 테스트 케이스 저장 변수
            int caseNumber = 0;
            // 결과 문장을 저장할 StringBuilder
            StringBuilder sb = new StringBuilder();

            // 0 0 전까지 반복
            while (true) {
                // 테스트 케이스 증가
                caseNumber++;
                // n, m 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                // n과 m 모두 0이면 종료
                if(n==0 && m==0) break;

                // 인접리스트 초기화
                List<Integer>[] graph = new ArrayList[n + 1];
                // 방문 배열 초기화
                boolean[] visited = new boolean[n + 1];

                // 인접리스트 초기화
                for(int i=1; i<=n; i++) {
                    graph[i] = new ArrayList<>();
                }

                // 인접 리스트에 간선 정보 저장
                for (int i=0; i<m; i++) {
                    st = new StringTokenizer(br.readLine());
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());
                    graph[s].add(e);
                    graph[e].add(s);
                }

                // 트리의 개수를 저장할 변수
                int treeCount = 0;

                // 각 정점 BFS로 탐색
                for (int i=1; i<=n; i++) {
                    // 방문하지 않은 경우
                    if(!visited[i]){
                        // 트리이면 개수 증가
                        if(isTree(graph, visited, i)){
                            treeCount++;
                        }
                    }
                }

                // 트리 개수에 따라 다른 문장 저장
                if(treeCount >1){
                    sb.append("Case "+caseNumber+": A forest of "+treeCount+" tree.\n");
                } else if (treeCount == 1) {
                    sb.append("Case "+caseNumber+": There is one tree.\n");
                } else {
                    sb.append("Case "+caseNumber+": No trees.\n");
                }
            }

            // 결과 출력
            System.out.print(sb);
        }
    }

    // BFS로 트리인지 여부 확인하는 메서드
    private static boolean isTree(List<Integer>[] graph, boolean[] visited, int start){
        // 노드와 엣지의 개수 저장 변수
        int nodeCount = 0, edgeCount = 0;
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        // 첫 노드 큐에 추가
        queue.add(start);
        // 방문 업데이트
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 맨 앞 노드 꺼내기
            int node = queue.poll();
            // 노드 개수 증가
            nodeCount++;

            // 노드에 연결된 노드들 탐색
            for(int neighbor : graph[node]){
                // 엣지 증가
                edgeCount++;
                // 방문하지 않은 경우
                if(!visited[neighbor]){
                    // 방문 업데이트
                    visited[neighbor]=true;
                    // 큐에 추가
                    queue.add(neighbor);
                }
            }
        }
        // 엣지 /2
        edgeCount/=2;

        // 결과 반환
        return edgeCount==nodeCount-1;
    }
}
