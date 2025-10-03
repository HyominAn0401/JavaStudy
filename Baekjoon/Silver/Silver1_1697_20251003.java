package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_1697_20251003 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            System.out.print(bfs(N, K));
        }
    }

    public static int bfs(int N, int K){
        if(N==K)    return 0;
        int maxValue = 100000;
        Queue<Integer> queue = new LinkedList<>();
        int [] counts = new int[maxValue+1];
        boolean [] visited = new boolean[maxValue+1];

        queue.add(N);
        visited[N] = true;

        while(!queue.isEmpty()){
            int num = queue.poll();
//            int first = num-1;
//            int second = num +1;
//            int third = 2*num;

            int [] move = {num-1, num+1, num*2};

            for(int i=0; i<move.length; i++){
                if(move[i]>=0 && move[i]<=maxValue && !visited[move[i]]){
                    visited[move[i]] = true;
                    counts[move[i]] = counts[num]+1;
                    queue.add(move[i]);
                    if(move[i]==K)  return counts[move[i]];
                }
            }

//            if(0<=first && first <= maxValue&& !visited[first]){
//                visited[first] = true;
//                counts[first] = counts[num]+1;
//                queue.add(first);
//                if(first==K)    return counts[first];
//            }
//
//            if(0<=second && second<=maxValue && !visited[second]){
//                visited[second] = true;
//                counts[second] = counts[num]+1;
//                queue.add(second);
//                if(second==K)   return counts[second];
//            }
//
//            if(third <= maxValue && 0<=third && !visited[third]){
//                visited[third] = true;
//                counts[third] = counts[num] + 1;
//                queue.add(third);
//                if(third==K)    return counts[third];
//            }
        }

        return -1;
    }
}
