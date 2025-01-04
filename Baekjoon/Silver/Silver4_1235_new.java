package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Silver4_1235_new {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            String [] numbers = new String[N];

            for(int i=0; i<N; i++){
                numbers[i] = br.readLine();
            }

            int length = numbers[0].length();

            int k = 0;

//            String str = numbers[0].substring(6);
//            System.out.println(str);

            Set<String> set;

            //System.out.println(numbers[0]+" "+length);

            while(true){
                k+=1;
                set = new HashSet<>();

//                for(int i=0; i<N; i++){
//                    set.add(numbers[i].substring(length-k));
//                }

                for(String str : numbers){
                    if(length - k >=0) {
                        String newNum = str.substring(length - k);
                        set.add(newNum);
                    }
                }

                if(set.size()==N)
                    break;
            }

            System.out.println(k);
        }
    }
}
