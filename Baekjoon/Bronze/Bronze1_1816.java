package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze1_1816 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int t=0; t<testCase; t++){
                long number = Long.parseLong(br.readLine());

                for(int i=2; i<=1000000; i++){
                    if(number%i==0){
                        sb.append("NO\n");
                        break;
                    }
                    if(i==1000000)  sb.append("YES\n");
                }
            }
            System.out.print(sb);
        }
    }
}
