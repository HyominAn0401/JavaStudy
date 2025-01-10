package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze2_2587 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int [] numbers = new int[5];
            int sum = 0;

            for(int i=0; i<5; i++){
                numbers[i] = Integer.parseInt(br.readLine());
                sum += numbers[i];
            }

            Arrays.sort(numbers);

            System.out.println(sum/5);
            System.out.println(numbers[2]);
        }
    }
}
