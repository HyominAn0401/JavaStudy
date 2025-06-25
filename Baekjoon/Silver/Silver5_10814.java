package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Silver5_10814 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br= new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            List<Member> members= new ArrayList<>();

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int age = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                members.add(new Member(age, name, i));
            }

            Comparator<Member> byAge = (a,b) -> {
                if (a.age != b.age){
                    return a.age - b.age;
                }
                else{
                    return a.cnt - b.cnt;
                }
            };

            members.sort(byAge);

            for(int i=0; i<N; i++){
                System.out.println(members.get(i).age+" "+members.get(i).name);
            }
        }
    }

    static class Member{
        private int age;
        private String name;
        private int cnt;

        public Member(int age, String name, int cnt){
            this.age = age;
            this.name = name;
            this.cnt = cnt;
        }
    }
}


