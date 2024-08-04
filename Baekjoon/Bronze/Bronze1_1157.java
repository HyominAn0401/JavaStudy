package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze1_1157 {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int [] alpha = new int[26]; //초기화

//            char ch = String.valueOf(br.readLine()).charAt(0);
//            int ch_int = ch-'A';
//            System.out.println(ch+" "+ch_int);

            String word = br.readLine();
            word = word.toUpperCase();

            for(String s : word.split("")){
                int index = s.charAt(0)-'A';
                alpha[index]++;
                //System.out.println(s+", "+(s.charAt(0)-'A'));
            }
            int max = Integer.MIN_VALUE;
            int index_ch =0;
            for(int i=0; i<alpha.length; i++){
                if(alpha[i] > max) {
                    max = alpha[i];
                    index_ch = i;
                }
            }
            int num = 0;

            for(int i=0; i<alpha.length; i++){
                if(max == alpha[i])
                    num++;
            }

            if(num>1)
                System.out.println("?");
            else System.out.println((char)(index_ch+'A'));
        }
    }
}
