package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver2_24479 {
    // DFS 실행 + 방문순서 구하기
    public static void DFS(int x){
        visited[x] = true;
        count[x] = ++i;
        for(int node : neighbors[x]){
            if(!visited[node]){
                DFS(node);
            }
        }
    }

    // 방문 배열
    public static boolean [] visited;
    // 인접 리스트
    public static ArrayList<Integer> [] neighbors;
    // 방문 순서 배열
    public static int [] count;
    public static int i=0;

    public static void main(String[] args) {
        // 구현 및 해야할 것 : DFS로 정점의 방문 순서 기록하고 출력하기
        // 로직 설계
        // 1. 정점 수, 간선 수, 시작 정점 입력받고 자료구조 초기화
        // 2. 인접 리스트에 정점 초기화
        // 3. 인접 정점 오름차순으로 정렬
        // 4. R 정점에서 DFS 실행
        // 4-1. 시작 정점 방문 true로 갱신
        // 4-2. 방문 순서 +1, 인접 정점 내 방문하지 않은 정점에 한해 DFS 실행
        // 5. 노드 별 방문 순서 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 정점 수, 간선 수, 시작 정점 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            // 자료구조 초기화
            visited = new boolean[N+1];
            neighbors = new ArrayList[N+1];
            count = new int[N+1];

            for(int i=1; i<N+1; i++){
                neighbors[i] = new ArrayList<>();
            }

            // 인접 리스트 정점 입력 및 초기화
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                neighbors[s].add(e);
                neighbors[e].add(s);
            }

            // 오름차순 정렬
            for(int i=1; i<N+1; i++){
                Collections.sort(neighbors[i]);
            }

            // 시작 정점 R로 DFS 실행
            DFS(R);

            // 결과 출력
            for(int i=1; i<N+1; i++){
                System.out.println(count[i]);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
