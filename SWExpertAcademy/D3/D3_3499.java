package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_3499 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int t=1; t<=testCase; t++){
                int N = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());

                Queue<String> queue1 = new LinkedList<>();
                Queue<String> queue2 = new LinkedList<>();

                if(N%2==0){
                    for(int i=0; i<N/2; i++){
                        queue1.add(st.nextToken());
                    }
                    for(int i=N/2; i<N; i++){
                        queue2.add(st.nextToken());
                    }
                }
                else{
                    for(int i=0; i<N/2+1; i++){
                        queue1.add(st.nextToken());
                    }
                    for(int i=N/2+1; i<N; i++){
                        queue2.add(st.nextToken());
                    }
                }

                sb.append("#"+t+" ");
                for(int i=0; i<N; i++){
                    if(i==0 || i%2==0){
                        sb.append(queue1.poll()+" ");
                    }
                    else{
                        sb.append(queue2.poll()+" ");
                    }
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }
}
