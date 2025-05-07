package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver3_16165 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();

            Map<String, List<String>> groupMap = new HashMap<>();
            Map<String, String> membersMap = new HashMap<>();

            for(int i=0; i<N; i++){
                String groupName = br.readLine();
                int members = Integer.parseInt(br.readLine());

                List<String> memberList = new ArrayList<>();
                for(int j=0; j<members; j++){
                    String name= br.readLine();
                    memberList.add(name);
                    membersMap.put(name, groupName);
                }
                Collections.sort(memberList);
                groupMap.put(groupName, memberList);
            }

            for(int i=0; i<M; i++){
                String str = br.readLine();
                int num = Integer.parseInt(br.readLine());

                if(num==0){
                    for(String member : groupMap.get(str)){
                        sb.append(member+"\n");
                    }
                }
                else if(num==1){
                    sb.append(membersMap.get(str)+"\n");
                }
            }

            System.out.print(sb.toString());
        }
    }
}
