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
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            second = new int[100001];

            Arrays.fill(second, -1);

            System.out.println(bfs(N));

            //System.out.println(bfs(N, 0));
        }
    }

    public static int bfs(int location){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(location);
        second[location] = 0;

        while(!deque.isEmpty()){
            int soobin = deque.pollFirst();

            if(soobin == K) return second[soobin];

            //0초 이동은 addFirst
            int teleport = soobin * 2;
            if(teleport <= 100000 && second[teleport]==-1){
                second[teleport] = second[soobin];
                deque.addFirst(teleport);
            }

            // 1초 이동 addLast
            int [] walk = {-1, 1};
            for(int i=0; i<walk.length; i++){
                int nextSoobin = soobin + walk[i];
                if(nextSoobin >=0 && nextSoobin <=100000 && second[nextSoobin]==-1){
                    second[nextSoobin] = second[soobin]+1;
                    deque.addLast(nextSoobin);
                }
            }

        }
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
