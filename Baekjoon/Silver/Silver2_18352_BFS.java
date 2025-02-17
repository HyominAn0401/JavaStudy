package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_18352_BFS {
    static int N, M, K, X;
    static ArrayList<Integer> [] graph;
    static int [] distance;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            // 그래프 및 거리 배열 초기화
            graph = new ArrayList[N + 1];
            distance = new int[N + 1];
            Arrays.fill(distance, -1);

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 간선 정보 입력
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
            }

            // BFS 실행
            bfs(X);

            // 결과 출력
            boolean found = false;
            for (int i = 1; i <= N; i++) {
                if (distance[i] == K) {
                    System.out.println(i);
                    found = true;
                }
            }

            // K 거리의 도시가 없으면 -1 출력
            if (!found) {
                System.out.println(-1);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                // 방문하지 않은 경우만 탐색
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
