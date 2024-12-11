package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_1697_new {
    static boolean [] visited;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : -1, +1, *2 3가지 경우로 N에서 K로 도달하는 가장 빠른 시간 출력
        // 로직 설계
        // 1. N, K 값 입력받고 100001 크기의 방문 배열 초기화
        // 2. N, K값 매개변수로 BFS 실행
        // 3. 큐에 node 추가
        // 4. 큐에서 node 원소 poll, 위치와 시간 저장
        // 5. pos값이 K와 같으면 반복문 종료, 아니면 pos에 -1, +1, *2 값을 move 배열에 저장
        // 6. move 배열 값들이 조건에 만족하면 큐에 ti+1로 추가, 방문 업데이트
        // 7. BFS 실행 결과값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, K 값 입력받기
            StringTokenizer st= new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 방문배열 초기화
            visited = new boolean[100001];
            // N, K값 매개변수 전달
            System.out.println(bfs(N, K));
        }
    }

    // BFS 메서드
    public static int bfs(int n, int k){
        // 큐에 추가
        queue.add(new Node(n, 0));
        // 방문 업데이트
        visited[n] = true;

        // 반복
        while(true){
            // 첫 번째 원소 poll
            Node node = queue.poll();
            int pos = node.position;
            int ti = node.time;

            // pos 값이 k와 같으면 시간 리턴
            if(pos==k)  return ti;

            // -1, +1, *2 값 배열에 저장
            int [] move = {pos-1, pos+1, pos*2};
            // 배열 내 값들에 따라 반복
            for(int next : move){
                // 0 이상 100000 이하이고 방문하지 않았으면
                if(next>=0 && next<=100000 && !visited[next]){
                    // 큐에 추가, time + 1
                    queue.add(new Node(next, ti+1));
                    // 방문 업데이트
                    visited[next] = true;
                }
            }
        }

    }

    // 노드 클래스
    static class Node{
        // 위치, 시간
        int position, time;
        public Node(int position, int time){
            this.position = position;
            this.time = time;
        }
    }
}
