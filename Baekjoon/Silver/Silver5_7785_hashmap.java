package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Silver5_7785_hashmap {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            //int people = Integer.parseInt(br.readLine());
            long people = Long.parseLong(br.readLine());
            HashMap<String, String> map = new HashMap<>();
            ArrayList<String> list = new ArrayList<>();
            for(int i=0; i<people; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String enterOrLeave = st.nextToken();
                map.put(name, enterOrLeave);
                //System.out.println(map.get(name));
            }

            for(String name : map.keySet()){
                if(map.get(name).equals("enter")){
                    list.add(name);
                }
            }

            list.sort(Collections.reverseOrder());
            for(String name : list){
                System.out.println(name);
            }
        }
    }
}
