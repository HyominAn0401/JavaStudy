package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver2_11724_new {

    static boolean [] visited;
    static ArrayList<Integer>[] neighbor;

    // DFS 실행
    static void DFS(int k){
        // 스택 생성
        Stack<Integer> stack = new Stack<>();
        // 방문 배열 k를 true로 변경
        visited[k] = true;
        // 스택에 k 푸시
        stack.push(k);

        // 스택이 비지 않을 때까지 반복
        while(!stack.isEmpty()){
            // 스택 맨 위의 값을 pop
            int x = stack.pop();
            // x의 인접 리스트 내 값에 대한 처리 반복문
            for(int i=0; i<neighbor[x].size(); i++){
                // 인접 리스트 값 저장하는 변수 y
                int y = neighbor[x].get(i);
                // y 노드를 방문하지 않은 경우
                if(!visited[y]){
                    // 방문 true로 변경
                    visited[y] = true;
                    // y를 스택에 push
                    stack.push(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 구현 및 해야할 것 : DFS를 실행하고 DFS의 실행 횟수 출력하기
        // 로직 설계
        // 1. 노드 수와 엣지 수 입력받기
        // 2. 방문 배열 및 인접 리스트 초기화
        // 3. 방문하지 않은 노드를 대상으로 DFS를 실행하고 실행 횟수를 카운트
        // 4. 실행 횟수 출력

        // try-with-resources로 BufferedReader 인스턴스 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            // StringTokenizer로 입력값 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 노드와 엣지 수 입력받기
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 방문 배열 초기화 -> 초기값 false
            visited = new boolean[N+1];
            // 인접 리스트 초기화 1
            neighbor = new ArrayList[N+1];

            // 인접 리스트 초기화 2
            for(int i=1; i<N+1; i++){
                neighbor[i] = new ArrayList<>();
            }

            // 인접 리스트 초기화 3
            for(int i=0; i<M; i++){
                // 연결된 각 노드 입력받기
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                // 양방향이므로 각 인접 리스트에 추가
                neighbor[s].add(e);
                neighbor[e].add(s);
            }

            // DFS 횟수를 카운트해 저장할 변수
            int count = 0;

            // 각 노드에 대해 방문하지 않는 노드의 경우 DFS를 실행하고 count 증가
            for(int i=1; i<=N; i++){
                if(!visited[i]){
                    DFS(i);
                    count++;
                }
            }

            // 결과값 출력
            System.out.println(count);

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
