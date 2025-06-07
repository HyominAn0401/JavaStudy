package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver3_4375 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringBuilder sb = new StringBuilder();

            String str;
            while ((str = br.readLine()) != null && !str.equals("")){
                int num = Integer.parseInt(str);

                int cnt = 1;
                int val = 1;

                while(true){
                    if(val % num ==0){
                        sb.append(cnt+"\n");
                        break;
                    }
                    val = (val*10+1)%num;
                    cnt++;
                }
//                while(true){
//                    num = num * cnt;
//                    if(num%2!=0 && num%5!=0){
//                        int an= 0;
//                        char[] numbers = String.valueOf(num).toCharArray();
//                        for(int i=0; i<numbers.length; i++){
//                            if(numbers[i]!='1') break;
//                            else an++;
//                        }
//                        if(an==numbers.length){
//                            sb.append(an+"\n");
//                            break;
//                        }
//                    }
//                    cnt++;
//                }
            }
            System.out.println(sb);
        }
    }
}
