package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_5014 {
    static boolean [] visited;
    static int [] building;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 현재 위치 S에서 한 번에 U, -D 층수로 이동하면서 G층까지 가는 최소 이동 횟수를 구한다.
        // 로직 설계
        // 1.큐에 현재 층을 넣고 방문 처리한다. 최소횟수 저장 배열은 MAX값으로 초기화한다.
        // 2. 현재 층을 기준으로 탐색한다.
        // 2-1. poll()한 층에서 위로 U층, 아래로 D층 두 가지 경우를 검사한다.
        // 3. 다음 층이 유효하고 방문하지 않은 경우
        // 3-1. 다음 층을 방문한 적 없고, 1보다 크거나 같으며 F보다 작거나 같은 경우
        // 3-1-1. 방문 처리, 현재층+1과 기존 값을 비교해 작은 값으로 업데이트, 큐에 다음 층을 넣는다
        // 4. 최종적으로 배열에서 인덱스 G의 배열값을 출력한다. 값이 MAX값인 경우(업데이트 되지 않아 도달하지 못한 경우) use the stairs를 출력한다.
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int F = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            // 해당 값들을 매개변수로 bfs 실행
            bfs(F, S, G, U, D);

            // 도착 지점 배열값
            int answer = building[G];
            // 값이 업데이트 되지 않은 경우 => 도달 불가능
            if(answer == Integer.MAX_VALUE)
                // 문자열 출력
                System.out.print("use the stairs");
            // 도달
            else
                System.out.print(answer);
        }
    }

    // bfs
    public static void bfs(int F, int S, int G, int U, int D){
        // 층을 저장할 queue
        Queue<Integer> queue = new LinkedList<>();
        // 방문 및 최단횟수 저장 배열
        visited = new boolean[F+1];
        building = new int[F+1];
        // 최댓값으로 초기화
        Arrays.fill(building, Integer.MAX_VALUE);

        // 큐에 현재 위치
        queue.add(S);
        // 횟수 0으로 저장
        building[S] = 0;
        // 방문
        visited[S] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 현재 층 수
            int floor = queue.poll();
            // U, -D 두 가지 경우
            int [] elevator = {U, -D};

            // 2가지 경우 고려
            for(int i=0; i<elevator.length; i++){
                // 다음 층
                int nextFloor = floor + elevator[i];
                // 조건 만족 시
                if(nextFloor >= 1 && nextFloor <= F && !visited[nextFloor]){
                    // 방문 처리
                    visited[nextFloor] = true;
                    // 큐에 삽입
                    queue.add(nextFloor);
                    // 최소값 업데이트
                    building[nextFloor] = Math.min(building[nextFloor], building[floor]+1);
                }
            }
        }
    }
}
