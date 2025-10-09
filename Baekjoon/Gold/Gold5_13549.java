package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Gold5_13549 {
    static int N, K;
    static int [] second;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 수빈이 위치에서 동생을 찾을 수 있는 최단 시간
        // 로직 설계
        // 1. Deque에 수빈이 위치 추가
        // 2. BFS에서 걸어서 이동하는 건 addLast, 순간이동은 addFirst로 큐에 추가한다
        // 3. 가장 빠른 시간을 출력한다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 수비이와 동생 위치
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // N의 최댓값 100000의 +1 크기 배열
            second = new int[100001];
            // 값을 -1로 초기화
            Arrays.fill(second, -1);

            System.out.println(bfs(N));

            //System.out.println(bfs(N, 0));
        }
    }

    // bfs
    public static int bfs(int location){
        // Deque 초기화
        Deque<Integer> deque = new ArrayDeque<>();
        // 현재 위치 큐에 삽입
        deque.add(location);
        // 현재 위치 기반 시간 0으로 초기화
        second[location] = 0;

        // 큐가 빌 때까지 반복
        while(!deque.isEmpty()){
            // 수빈의 위치 poll
            int soobin = deque.pollFirst();

            // 현재 위치가 K와 같으면 반환
            if(soobin == K) return second[soobin];

            //0초 이동은 addFirst
            int teleport = soobin * 2;
            // 범위 내에 있고 아직 방문 안했으면
            if(teleport <= 100000 && second[teleport]==-1){
                // deque에 추가 및 시간 업데이트
                second[teleport] = second[soobin];
                deque.addFirst(teleport);
            }

            // 1초 이동 addLast
            int [] walk = {-1, 1};
            for(int i=0; i<walk.length; i++){
                // 다음 위치
                int nextSoobin = soobin + walk[i];
                // 범위 내에 존재하고 방문 아직이면
                if(nextSoobin >=0 && nextSoobin <=100000 && second[nextSoobin]==-1){
                    // deque에 추가 및 시간 업데이트
                    second[nextSoobin] = second[soobin]+1;
                    deque.addLast(nextSoobin);
                }
            }

        }
        // 불가능할 시 -1 반환
        return -1;
//        Deque<int[]> deque = new ArrayDeque<>();
//        deque.addLast(new int[]{location, sec});
//        second[location] = sec;
//
//        while(!deque.isEmpty()){
//            int [] cur = deque.pollFirst();
//            int soobin = cur[0];
//            int count = cur[1];
//
//            if(soobin == K) return second[soobin];
//
//            int [] walk = {-1, 1};
//
//            for(int i=0; i<walk.length; i++){
//                int nextSoobin = soobin + walk[i];
//                if(nextSoobin>=0 && nextSoobin <=100000 && second[nextSoobin]==-1){
//                    deque.addLast(new int[]{nextSoobin, count+1});
//                    second[nextSoobin] = second[soobin] +1;
//                    if(nextSoobin == K) return second[nextSoobin];
//                }
//            }
//
//            int teleport = soobin*2;
//            if(teleport>=0 && teleport<=100000 && second[teleport]==-1){
//                deque.addLast(new int[]{teleport, count});
//                second[teleport] = second[soobin];
//                if(second[teleport]==K) return second[teleport];
//            }
//        }
//        return -1;
    }
}
