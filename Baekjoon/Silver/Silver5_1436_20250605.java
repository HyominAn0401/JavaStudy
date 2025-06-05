package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver5_1436_20250605 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            int cnt = 0;
            int num = 0;
            while(cnt!=N){
                num++;
                String strNum = Integer.toString(num);
                if(strNum.contains("666")){
                    cnt++;
                }
            }

            System.out.println(num);
        }
    }
}
