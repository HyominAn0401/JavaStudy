package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze_1816_20250913 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int cnt = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int t=0; t<cnt; t++){
                long num = Long.parseLong(br.readLine());
                for(int i=2; i<=1000000; i++){
                    if(num%i==0){
                        sb.append("NO"+"\n");
                        break;
                    }
                    if(i==1000000){
                        sb.append("YES"+"\n");
                    }
                }
            }

            System.out.print(sb);
        }
    }
}
