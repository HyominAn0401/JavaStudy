package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_11052 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int [] cards = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                cards[i] = Integer.parseInt(st.nextToken());
            }

            int [] pay = new int[N+1];

            for(int i=1; i<=N; i++){
                for(int k=1; k<=i; k++){
                    pay[i] = Math.max(pay[i], pay[i-k] + cards[k]);
                }
            }

            System.out.println(pay[N]);
        }
    }
}
