package Silver;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class Silver3_2606 {

    static boolean [] visited;
    static ArrayList<Integer>[] arrayLists; //인접 리스트

    public static void main(String[] args) {
        // 구현 및 해야할 것 : 원본 그래프에서 1번을 통해 바이러스에 걸리는 컴퓨터의 수 구해 출력하기
        // 로직 설계
        // 1. 총 컴퓨터 수와 네트워크 연결 수 입력받기
        // 2. 각 컴퓨터에 대한 인접 리스트를 생성하고 초기화하기
        // 3. 각 노드에 연결된 노드를 인접 리스트에 저장하기
        // 4. visited 배열을 초기화하고 큐가 빌 때까지 BFS 실행하기
        // 5. 이미 바이러스에 감염된 1번 컴을 제외하고 나머지 컴의 방문 여부 확인 후 수를 세어 출력하기


        // try-with-resources로 Scanner 자원 관리
        try(Scanner scanner = new Scanner(System.in)){
            // 컴퓨터 수와 네트워크 연결 수 입력받기
            int computers = scanner.nextInt();
            int networks = scanner.nextInt();

            //
            arrayLists = new ArrayList[computers+1];
            // 인접 리스트의 각 ArrayList 초기화하는 for문
            for(int i=1; i<=computers; i++){
                arrayLists[i] = new ArrayList<Integer>();
            }

            // 인접 리스트에 그래프 데이터 저장하는 for문
            for(int i=0; i<networks; i++){
                int S = scanner.nextInt();
                int E = scanner.nextInt();
                // 양방향이므로 간선 모두 추가
                arrayLists[S].add(E);
                arrayLists[E].add(S);
            }

            // 작은 값부터 정렬하는 for문
            for(int i=1; i<=computers; i++){
                Collections.sort(arrayLists[i]);
            }

            // 방문 배열 초기화
            visited = new boolean[computers+1];
            // BFS 실행
            System.out.println(BFS());
//            for(boolean x : visited){
//                System.out.print(x+" ");
//            }
        }
    }

    private static int BFS(){
        // 큐 생성하기
        Queue<Integer> queue = new LinkedList<Integer>();
        // 시작 노드인 1 삽입하기
        queue.add(1);
        // 1번 노드 방문 체크
        visited[1] = true;
        // 감염된 컴퓨터 개수를 저장할 변수
        int cnt = 0;

        // 큐가 빌 때까지 반복하는 while문
        while(!queue.isEmpty()){
            // 큐에서 현재값 가져오기
            int now = queue.poll();
            // 현재 노드의 연결 노드 중 미방문 노드 방문배열에 체크하고 큐에 삽입
            for(int i : arrayLists[now]){
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        // 1번 컴퓨터를 제외한 감염된 컴퓨터의 개수 반환하기
        for(int i=2; i<visited.length; i++){
            if(visited[i]==true)
                cnt++;
        }
        return cnt;
    }
}
