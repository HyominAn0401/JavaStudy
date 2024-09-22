package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_2644 {
    // 부모 자식 간 관계 저장할 ArrayList 배열
    static ArrayList<Integer> [] relationship;
    // 방문 배열
    static boolean [] visited;
    // 촌수(depth)를 저장할 배열
    static int [] degree;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 인접 리스트를 구성하고 두 사람의 촌수를 BFS로 구해 출력하기, 아니면 -1 출력
        // 로직 설계ㅜ
        // 1. 값을 입력받고 인접 리스트, 방문배열, 촌수 저장 배열 초기화
        // 2. 인접 리스트에 노드 간 관계 저장
        // 3. 구하고자 하는 사람의 번호로 BFS 시작
        // 3-1. 인접 리스트에 저장된 사람 번호에 따라 깊이 누적
        // 4. 결과값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 전체 사람의 수
            int n = Integer.parseInt(br.readLine());
            // 촌수를 구하고자 하는 두 사람의 번호
            StringTokenizer st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            // 관계의 수
            int m = Integer.parseInt(br.readLine());

            // 초기화
            relationship = new ArrayList[n+1];
            degree = new int[n+1];
            visited = new boolean[n+1];

            // 인접 리스트 초기화
            for(int i=1; i<=n; i++){
                relationship[i] = new ArrayList<>();
            }

            // 관계 저장
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                relationship[x].add(y);
                relationship[y].add(x);
            }

            // 두 사람 중 첫 번째 사람으로 BFS 실행
            BFS(person1);

            // 두 번째 사람을 방문하지 않았고 값이 0이면
            if(!visited[person2] && degree[person2]==0){
                System.out.println(-1);
            }
            // 그게 아닌 경우 방문했고 값이 0이 아니므로 촌수 출력
            else    System.out.println(degree[person2]);
        }
    }

    // BFS 메서드
    public static void BFS(int n){
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        // 들어온 값 큐에 추가
        queue.add(n);
        // 방문 업데이트
        visited[n] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 가장 앞 숫자 poll
            int person = queue.poll();
            // 해당 사람의 인접 리스트 숫자에 대해 반복
            for(int x : relationship[person]){
                // 방문하지 않은 경우
                if(!visited[x]) {
                    // 큐에 추가, 방문 업데이트
                    queue.add(x);
                    visited[x] = true;
                    // 촌수(깊이) 누적
                    degree[x] = degree[person] + 1;
                }
            }
        }
    }
}
