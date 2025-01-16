package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_1138_new {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int [] taller = new int[N+1];
            int [] order = new int[N+1];
            boolean [] isIn = new boolean[N+1];
            StringBuilder sb = new StringBuilder();

            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                taller[i] = Integer.parseInt(st.nextToken());
            }

//            for(int i=1; i<=N; i++){
//                int or = 1 + taller[i];
//
//                if(isIn[or]){
//                    while(isIn[or]){
//                        or++;
//                    }
//                }
//                isIn[or] = true;
//                order[or] = i;
//            }

            for(int i=1; i<=N; i++){
                int count = taller[i];
                int or = 1;

                while(count > 0 || isIn[or]){
                    if(!isIn[or])
                        count--;

                    or++;
                }

                isIn[or] = true;
                order[or] = i;
            }

            for(int i=1; i<=N; i++){
                sb.append(order[i]+" ");
            }
            System.out.println(sb);
        }
    }
}
