package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze1_1816_20250606 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<testCase; i++){
                long num = Long.parseLong(br.readLine());

                for(long j=2; j<=1000000; j++){
                    if(num%j==0){
                        sb.append("NO"+"\n");
                        break;
                    }
                    if(j==1000000){
                        sb.append("YES"+"\n");
                        break;
                    }
                }

            }

            System.out.print(sb);
        }
    }
}
