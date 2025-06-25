package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver4_10610 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String num = br.readLine();
            int sum = 0;

            StringBuilder sb = new StringBuilder();

            String [] numbers = num.split("");
            for(int i=0; i<numbers.length; i++){
                sum += Integer.parseInt(numbers[i]);
            }

            if(sum%3!=0 || !num.contains("0")){
                System.out.println(-1);
            }
            else {
                Arrays.sort(numbers, (a,b)-> (b+a).compareTo(a+b));
                for(String n : numbers){
                    sb.append(n);
                }
                System.out.println(sb.toString());
            }
        }
    }
}
