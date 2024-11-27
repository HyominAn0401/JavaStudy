package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver5_2751 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            long [] numbers = new long[N];

            for(int i=0; i<N; i++){
                numbers[i] = Long.parseLong(br.readLine());
            }

            Arrays.sort(numbers);

            for(long num : numbers){
                System.out.println(num);
            }
        }
    }
}
