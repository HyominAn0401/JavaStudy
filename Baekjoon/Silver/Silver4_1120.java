package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_1120 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            int lengthA = A.length();
            int lengthB = B.length();
            int subStract = lengthB - lengthA+1;

            int minCount = Integer.MAX_VALUE;
            for(int i=0; i<subStract; i++){
                String str = B.substring(i, i+lengthA);
                int count = 0;
                for(int j=0; j<str.length(); j++){
                    if(A.charAt(j) != str.charAt(j)){
                        count++;
                    }
                }
                minCount = Math.min(count, minCount);
            }

            System.out.println(minCount);
        }
    }
}
