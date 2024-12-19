package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Silver5_1181 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            Words [] words = new Words[N];

            for(int i=0; i<N; i++){
                String str = br.readLine();
                int len = str.length();
                words[i] = new Words(str, len);
            }

            Arrays.sort(words, (a,b)->{
                if(a.length != b.length){
                    return Integer.compare(a.length, b.length);
                }
                return a.word.compareTo(b.word);
            });

            StringBuilder sb = new StringBuilder();
            String alreadyHaveWord = "";
            for(Words w : words){
                if(!w.word.equals(alreadyHaveWord)){
                    sb.append(w.word).append("\n");
                    alreadyHaveWord = w.word;
                }
            }

            System.out.println(sb.toString());

        }
    }

}

class Words{
    int length;
    String word;

    public Words(String word, int length){
        this.word = word;
        this.length = length;
    }
}
