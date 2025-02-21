package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver3_2659 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] num = new int[4];
            StringBuilder sb = new StringBuilder();
            Set<Integer> set = new HashSet<>();

            for(int i=0; i<4; i++){
                num[i] = Integer.parseInt(st.nextToken());
                sb.append(num[i]);
            }

            int minNum = Integer.parseInt(sb.toString());

            for(int i=0; i<3; i++){
                char first = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(first);

                int newNum = Integer.parseInt(sb.toString());
                minNum = Math.min(minNum, newNum);
            }

            StringBuilder sb2 = new StringBuilder();

            for(int i=1111; i<=9999; i++){
                int num1 = i/1000;
                int num2 = i%1000/100;
                int num3 = i%1000%100/10;
                int num4 = i%1000%100%10;

                if(num1==0 || num2==0 || num3==0 || num4==0)
                    continue;

                sb2.setLength(0);
                sb2.append(num1).append(num2).append(num3).append(num4);

                int minClock = Integer.parseInt(sb2.toString());

                for(int j=0; j<3; j++){
                    char ch = sb2.charAt(0);
                    sb2.deleteCharAt(0);
                    sb2.append(ch);
                    int newNum = Integer.parseInt(sb2.toString());
                    minClock = Math.min(newNum, minClock);
                }

                set.add(minClock);
            }

            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            int location = list.indexOf(minNum)+1;

            System.out.println(location);

        }
    }
}
