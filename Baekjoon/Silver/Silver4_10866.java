package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Silver4_10866 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            Deque<Integer> deque = new LinkedList<>();
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                if(order.equals("push_back")||order.equals("push_front")){
                    int num = Integer.parseInt(st.nextToken());
                    switch (order) {
                        case "push_back":
                            deque.addLast(num);
                            break;
                        case "push_front":
                            deque.addFirst(num);
                            break;
                    }
                } else{
                    switch (order){
                        case "pop_front":
                            if (deque.isEmpty()) {
                                sb.append(-1+"\n");
                            } else {
                                sb.append(deque.removeFirst()+"\n");
                            }
                            break;
                        case "pop_back":
                            if (deque.isEmpty()) {
                                sb.append(-1+"\n");
                            } else {
                                sb.append(deque.removeLast()+"\n");
                            }
                            break;
                        case "size":
                            sb.append(deque.size()+"\n");
                            break;
                        case "empty":
                            if(deque.isEmpty()) sb.append(1+"\n");
                            else sb.append(0+"\n");
                            break;
                        case "front":
                            if(deque.isEmpty()) sb.append(-1+"\n");
                            else sb.append(deque.getFirst()+"\n");
                            break;
                        case "back":
                            if(deque.isEmpty()) sb.append(-1+"\n");
                            else sb.append(deque.getLast()+"\n");
                            break;
                    }
                }
            }
            System.out.print(sb);
        }
    }
}
