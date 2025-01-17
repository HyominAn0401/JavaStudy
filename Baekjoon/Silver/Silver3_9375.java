package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver3_9375 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int t=0; t<testCase; t++){
                Map<String, List<String>> wearings = new HashMap<>();
                int N = Integer.parseInt(br.readLine());
                for(int i=0; i<N; i++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    String cloth = st.nextToken();
                    String type = st.nextToken();

                    wearings.putIfAbsent(type, new ArrayList<>());
                    wearings.get(type).add(cloth);
                }

                int count = 1;
//                int countCase = 0;

                for(List<String> list : wearings.values()){
                    count *= (list.size()+1);
                }
                sb.append((count-1)+"\n");

//                if(wearings.size()<=1){
//                    for(List<String> list : wearings.values()){
//                        countCase += list.size();
//                    }
//                    sb.append(countCase+"\n");
//                }
//                else{
//                    for(List<String> list : wearings.values()){
//                        countCase += list.size();
//                        count *= list.size();
//                    }
//                    sb.append((count+countCase)+"\n");
//                }

            }
            System.out.print(sb);
        }
    }
}
