package Silver.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_24480 {
    // 인접 리스트
    static ArrayList<Integer> [] arrayLists;
    // 방문 배열
    static boolean [] visited;
    // 방문 순서 배열
    static int [] visitOrder;
    // 방문 순서
    static int count;

    public static void main(String[] args) throws IOException{
        // 구현 및 해야할 것 : DFS로 정점을 방문하고 방문 순서를 출력한다
        // 로직 설계
        // 1. N과 M을 입력받고 인접 리스트, 방문 배열, 방문순서 배열 등을 초기화한다
        // 2. 인접 리스트에 정점을 저장한다.
        // 3. 인접 리스트를 내림차순 정렬한다.
        // 4.

        // try-with-resource로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N(정점 수), M(간선 수), R(시작 정점)값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            // 인접 리스트, 방문 배열, 방문 순서 배열 초기화
            arrayLists = new ArrayList[N+1];
            visited = new boolean[N+1];
            visitOrder = new int[N+1];

            // 인접 리스트 초기화
            for(int i=1; i<=N; i++){
                arrayLists[i] = new ArrayList<Integer>();
            }

            // 간선 수 만큼 정점 추가
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                // 양방향 간선
                arrayLists[s].add(e);
                arrayLists[e].add(s);
            }

            // 인접 리스트 내림차순 정렬
            for(int i=1; i<=N; i++){
                //Arrays.sort(arrayLists, Collections.reverseOrder());
                arrayLists[i].sort(Comparator.reverseOrder());
            }

            // 방문 순서를 누적할 변수
            count = 0;
            // 시작 정점에서 DFS 실행
            dfs(R);

            // 모든 노드를 순회하면서 방문하지 않은 노드가 있는지 확인하기
//            boolean hasUnvisited = false;
//            for(int i=1; i<= N; i++){
//                if(!visited[i]){
//                    hasUnvisited = true;
//                    break;
//                }
//            }

            // 연결되지 않은 노드가 있으면 0 출력
//            if(hasUnvisited){
//                for(int i=0; i<count; i++){
//                    System.out.println(0);
//                }
//            }
//            for(int i=1; i<=N; i++){
//                if(!visited[i]) {
//                    dfs(i);
//                }
//            }
            //System.out.println(cnt);

            // 방문 순서 출력
            for(int i=1; i<=N; i++){
                System.out.println(visitOrder[i]);
            }
        }
    }

    // DFS 함수
    public static void dfs(int v){
        // 현재 노드가 방문한 적 있으면 종료
        if(visited[v])  return;
        // 방문
        visited[v] = true;
        // 방문 순서 누적
        count++;
        // 해당 노드 방문 순서 저장
        visitOrder[v] = count;
        //System.out.println(v);

        // 인접 리스트 노드 재귀
        for(int x : arrayLists[v]){
            if(!visited[x]) {
                //System.out.println(x);
                dfs(x);
            }
        }
    }
}
