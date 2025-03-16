package AlgorithmPracticeKit.level2;

import java.util.LinkedList;
import java.util.Queue;

public class level2_1844 {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : DFS or BFS를 이용해 도착지에 도착하는 가장 작은 횟수 출력하기
        // 로직 설계
        // 1. 노드 저장 큐 초기화
        // 2. 첫 위치 및 count 값 저장 노드를 큐에 추가하고 방문으로 업데이트
        // 3. 큐가 빌 때까지 해당 노드가 조건에 만족하는 경우 다음 노드 큐에 추가 및 count+1
        // 4. 도착지에 도달하면 count 출력, 불가능하면 -1 출력

        int [][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        System.out.println(solution(maps));
    }

    // 최솟값 반환하는 함수
    public static int solution(int [][] maps){
        // 최솟값 저장 변수. 도달 불가능하면 -1 그대로 출력
        int result = -1;
        // 맵의 가로, 세로 길이
        int n= maps.length;
        int m = maps[0].length;
        // 방문 여부 이차원 배열
        boolean [][] visited = new boolean[n][m];

        // 노드 저장 큐
        Queue<Node> queue = new LinkedList<>();
        // 첫 위치 큐에 저장
        queue.add(new Node(0,0, 1));
        // 방문 업데이트
        visited[0][0] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 첫 번째 노드 꺼내기
            Node node = queue.poll();
            // 해당 노드의 x, y, count 값
            int x = node.getX();
            int y = node.getY();
            int count = node.getCount();

            // 위치에 도달하면 count 리턴
            if(x==n-1 && y==m-1){
                return count;
            }

            // 상하좌우 반복
            for(int i=0; i<4; i++){
                // 다음 노드
                int nx = x+dx[i];
                int ny = y+dy[i];

                // 조건에 만족하면
                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    // 방문하지 않았고 값이 1이면
                    if(!visited[nx][ny] && maps[nx][ny]==1){
                        // 큐에 추가
                        queue.add(new Node(nx, ny, count+1));
                        // 방문 업데이트
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        // 결과 반환
        return result;
    }


}
class Node{
    private int x;
    private int y;
    private int count;
    public Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getCount(){
        return count;
    }
}
