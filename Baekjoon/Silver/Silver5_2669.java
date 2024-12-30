package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver5_2669 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String him = br.readLine();
            String her = br.readLine();
            char [] hisName = him.toCharArray();
            char [] herName = her.toCharArray();
            int length = her.length();

            char [] names = new char[length*2];
            int [] match = new int[length*2];

            for(int i=0; i<length; i++){
                names[i*2] = hisName[i];
                names[i*2+1] = herName[i];
            }

            for(int i=0; i<length*2; i++){
                match[i] = getStrokes(names[i]);
            }

            for(int i=0; i<names.length-2; i++){
                for(int j=0; j<names.length-1-i; j++){
                    int sum = match[j] + match[j+1];
                    if(sum >= 10)   sum -= 10;
                    match[j] = sum;
                }
//                for(int matches : match){
//                    System.out.print(matches+" ");
//                }
//                System.out.println();
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<2; i++){
                sb.append(match[i]);
            }
            System.out.println(sb.toString());
        }
    }

    public static int getStrokes(char ch){
        switch (ch){
            case 'C': case 'L': case 'O': case 'S': case 'U': case 'V': case 'W': case 'Z':
                return 1;
            case 'B': case 'D': case 'G': case 'J': case 'K': case 'M': case 'N': case 'P': case 'Q': case 'R': case 'T': case 'X': case 'Y':
                return 2;
            case 'A': case 'E': case 'F': case 'H': case 'I':
                return 3;
        }
        return -1;
    }
}
