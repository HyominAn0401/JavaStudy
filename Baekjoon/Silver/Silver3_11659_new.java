package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_11659_new {
    static int [] number;
    static int [] sumNumber;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            number = new int[N+1];
            sumNumber = new int[N+1];

            st = new StringTokenizer(br.readLine());
            number[1] = Integer.parseInt(st.nextToken());
            sumNumber[1] = number[1];
            for(int i=2; i<=N; i++){
                number[i] = Integer.parseInt(st.nextToken());
                sumNumber[i] = sumNumber[i-1] + number[i];
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
//                sb.append(sectionSum(s,e)+"\n");
                sb.append((sumNumber[e]-sumNumber[s-1])+"\n");
            }

            System.out.print(sb);
        }
    }
}
