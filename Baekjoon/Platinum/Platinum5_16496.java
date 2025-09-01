package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Platinum5_16496 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            String[] numbers= new String[N];
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numbers[i] = st.nextToken();
            }

            // compare 
            Arrays.sort(numbers, (a,b)-> (b+a).compareTo(a+b));

            if(numbers[0].equals("0"))
                sb.append("0");
            else{
                for(String num : numbers){
                    sb.append(num);
                }
            }

            System.out.println(sb.toString());
        }
    }
}
