package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Silver4_10546 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> marathon = new HashMap<>();

            for(int i=0; i<N; i++){
                String name = br.readLine();
                marathon.put(name, marathon.getOrDefault(name, 0)+1);
            }

            for(int i=0; i<N-1; i++){
                String name = br.readLine();
                marathon.put(name, marathon.get(name)-1);
            }

            for(Map.Entry<String, Integer> entry : marathon.entrySet()){
                if(entry.getValue() >0)
                    System.out.println(entry.getKey());
            }
        }
    }
}
