package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver3_13414 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            Set<String> students = new LinkedHashSet<>();
            for(int i=0; i<L; i++){
                String studentNumber = br.readLine();
                students.remove(studentNumber);
                students.add(studentNumber);
            }

            int count=0;
            for(String studentNumber : students){
                if(count++ == K)
                    break;
                System.out.println(studentNumber);
            }

            Map<String, Integer> students = new HashMap<>();

            int num = 0;
            for(int i=-0; i<L; i++){
                String studentNumber = br.readLine();
                students.put(studentNumber, num);
                num++;
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(students.entrySet());
            Collections.sort(list, Map.Entry.comparingByValue());

            for(int i=0; i<K && i<list.size(); i++){
                System.out.println(list.get(i).getKey());
            }
        }
    }
}
