package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver4_10845 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            Queue<Integer> queue = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();

                switch(order){
                    case "front":
                        if(!queue.isEmpty()){
                            System.out.println(queue.peek());
                            break;
                        }
                        else{
                            System.out.println(-1);
                            break;
                        }
                    case "back":
                        break;
                    case "pop":

                }
            }
        }
    }
}
