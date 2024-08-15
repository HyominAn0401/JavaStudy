package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_12847_new {
    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            long [] salary = new long[(int)N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                salary[i] = Long.parseLong(st.nextToken());
            }
            long sum = 0;
            long maxValue = Long.MIN_VALUE;

            // 초기 윈도우 합
            for(int i=0; i<M; i++){
                sum += salary[i];
            }
            maxValue = sum;
            //System.out.println(maxValue);

            for(int i=(int)M; i<N; i++){
                sum += salary[i];
                sum -= salary[(int)(i-M)];
                if(sum > maxValue)
                    maxValue = sum;
            }

            System.out.println(maxValue);
        }
    }
}
