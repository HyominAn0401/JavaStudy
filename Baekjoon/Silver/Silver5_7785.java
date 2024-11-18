package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver5_7785 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            long people = Long.parseLong(br.readLine());
            HashSet<String> set = new HashSet<>();
            for(int i=0; i<people; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String enterOrLeave = st.nextToken();

                if(enterOrLeave.equals("enter")){
                    set.add(name);
                }
                else if(enterOrLeave.equals("leave")){
                    set.remove(name);
                }
            }

            ArrayList<String> list = new ArrayList<>(set);
            list.sort(Collections.reverseOrder());

            for(String name : list){
                System.out.println(name);
            }
        }
    }
}
