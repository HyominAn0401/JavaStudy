package level0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class level0_340205 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int number = Integer.parseInt(br.readLine());
            int answer = 0;

            for(int i=0; i<5; i++){
                answer += number%100;
                number /= 100;
            }

            System.out.println(answer);
        }
    }
}
