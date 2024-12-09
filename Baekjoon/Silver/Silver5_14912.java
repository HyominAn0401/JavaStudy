package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_14912 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            int cnt = 0;

            for(int i=1; i<=n; i++){
                String str = String.valueOf(i);
                for(char c : str.toCharArray()){
                    if( c == d){
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
