package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_2108 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            int [] numbers = new int[N];

            Map<Integer, Integer> map = new HashMap<>();

            double sum = 0;
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(br.readLine());
                if(map.containsKey(numbers[i]))
                    map.put(numbers[i], map.get(numbers[i])+1);
                else map.put(numbers[i], 1);
                sum += numbers[i];
            }

            Arrays.sort(numbers);

            // 평균
            double avg = sum / N;

            // 중앙값
            int index = N/2;
            int middle = numbers[index];

            // 최빈값
            int maxCount = Collections.max(map.values());
            List<Integer> modes = new ArrayList<>();

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() == maxCount){
                    modes.add(entry.getKey());
                }
            }
            Collections.sort(modes);
            int mode = (modes.size() > 1) ? modes.get(1) : modes.get(0);

            // 범위
            int range = numbers[N-1]-numbers[0];

            sb.append(Math.round(avg)+"\n"+middle+"\n"+mode+"\n"+range);
            System.out.print(sb);
        }
    }
}
