package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Silver4_1302 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> books = new HashMap<>();

            for(int i=0; i<N; i++){
                String title = br.readLine();
                books.put(title, books.getOrDefault(title,0)+1);
            }

            String maxKey=null;
            int maxValue = Integer.MIN_VALUE;
            for(String key : books.keySet()){
                int value = books.get(key);
                if(value > maxValue || (value == maxValue && key.compareTo(maxKey)<0)){
                    maxValue = value;
                    maxKey = key;
                }
            }
            System.out.print(maxKey);
        }
    }
}
