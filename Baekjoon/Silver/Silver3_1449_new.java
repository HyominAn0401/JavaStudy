package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver3_1449_new {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int [] leak = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                leak[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(leak);

            int i=0;
            int tape = 0;

            while(i<N){
                double maxCover = leak[i]-0.5+L;
                tape++;

                while(i<N && maxCover>=leak[i]+0.5){
                    i++;
                }
            }

            System.out.println(tape);
        }
    }
}
