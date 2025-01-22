package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver3_19941_20250122 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            String line = br.readLine();

            Queue<Integer> people = new LinkedList<>();
            Queue<Integer> hamburgers = new LinkedList<>();

            for(int i=0; i<N; i++){
                char ch = line.charAt(i);
                if(ch=='P') people.add(i);
                else if(ch=='H')    hamburgers.add(i);
            }

            int count = 0;

            while(!people.isEmpty() && !hamburgers.isEmpty()){
                int person = people.peek();
                int hamburger = hamburgers.peek();

                if(Math.abs(person-hamburger) <= K){
                    people.poll();
                    hamburgers.poll();
                    count++;
                }
                else{
                    if(person > hamburger)  hamburgers.poll();
                    else people.poll();
                }
            }

            System.out.println(count);
        }



    }
}
