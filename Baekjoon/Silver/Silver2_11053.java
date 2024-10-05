package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_11053 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            int [] num = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            int current = num[0];
            int maxCurrent = current;
            int cnt = 1;
            int maxCnt = cnt;

            for(int i=1; i<N; i++){
                if(current >= num[i]){
                    current = num[i];
                }
                else{
                    current = current + num[i];
                    cnt++;
                }
                maxCurrent = Math.max(maxCurrent, current);
                maxCnt = Math.max(maxCnt, cnt);
            }

            System.out.println(maxCnt);

        }
    }
}
