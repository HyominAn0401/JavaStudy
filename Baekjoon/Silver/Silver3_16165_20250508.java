package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver3_16165_20250508 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            Map<String, List<String>> girlGroups = new HashMap<>();

            for(int i=0; i<N; i++){
                String groupName = br.readLine();
                int member = Integer.parseInt(br.readLine());

                List<String> memberList = new LinkedList<>();

                for(int j=0; j<member; j++){
                    String name = br.readLine();
                    memberList.add(name);
                }
                Collections.sort(memberList);
                girlGroups.put(groupName, memberList);
            }

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<M; i++){
                String str = br.readLine();
                int num = Integer.parseInt(br.readLine());
                // 0 : str은 그룹명, 멤버들 이름 출력하기
                if(num==0){
                    for(String members : girlGroups.get(str))
                        sb.append(members+"\n");
                }
                // 1: str은 이름, 그룹명 출력하기
                else if(num==1){
                    // list에서 해당 이름을 찾기
//                    for(String keys: girlGroups.keySet()){
//                        if(girlGroups.get(keys).equals(str)){
//                            sb.append(keys+"\n");
//                        }
//                    }
                    for(String groupname : girlGroups.keySet()){
                        List<String> members = girlGroups.get(groupname);
                        if(members.contains(str)){
                            sb.append(groupname+"\n");
                            break;
                        }
                    }
                    // list가 속한 key값 출력하기
                }
            }
            System.out.print(sb.toString());
        }
    }
}
