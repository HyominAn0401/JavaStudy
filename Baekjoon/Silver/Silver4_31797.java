package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver4_31797 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            //Queue<Integer> queue = new LinkedList<>();
            Deque<Integer> deque = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int [] personByHands = new int[10001];

            for(int i=1; i<=M; i++){
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                personByHands[left] = i;
                personByHands[right] = i;

                deque.add(left);
                deque.add(right);
            }

            int lastHand = 0;
            for(int i=0; i<N; i++){
//                int person = queue.poll();
//                queue.add(person);
//                int person = deque.poll();
//                deque.add(person);
                lastHand = deque.pollLast();
                deque.add(lastHand);
            }

            System.out.println(personByHands[lastHand]);
        }
    }
}
