package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver5_1436 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            int count = 0;
            int num = 0;

            while(count != N){
                num++;
                String strNum = Integer.toString(num);
                if(strNum.contains("666")){
                    count++;
                }
            }

            System.out.println(num);
        }
    }
}
