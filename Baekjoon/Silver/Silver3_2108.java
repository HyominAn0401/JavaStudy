package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Silver3_2108 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int [] array = new int[N];
            Map<Integer, Integer> map = new HashMap<>();

            int sum = 0;
            for(int i=0; i<N; i++){
                int num = Integer.parseInt(br.readLine());
                sum += num;
                array[i] = num;
                map.put(num, map.getOrDefault(num, 0)+1);
            }

            int cnt = 1;
            int frequency = 0;
            for(int i=0; i<N; i++){
                if(cnt < map.get(array[i])){
                    cnt = map.get(array[i]);
                    frequency = array[i];
                }
            }

            if(cnt==1){
                Arrays.sort(array);
                if(array.length>1) {
                    frequency = array[1];
                } else frequency = array[0];
            }

            Arrays.sort(array);

            System.out.println(Math.floorDiv(sum, N));
            System.out.println(array[N/2]);
            System.out.println(frequency);
            System.out.println(array[N-1] - array[0]);
        }
    }
}
