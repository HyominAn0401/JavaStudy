package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver3_2992 {
    static int [] selected;
    static boolean [] used;
    static int [] number;
    static StringBuilder sb = new StringBuilder();
    static int length;
    static int originalNumber;
    static int minValue;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String X = br.readLine();
            length = X.length();
            originalNumber = Integer.parseInt(X);
            minValue = Integer.MAX_VALUE;

            number = new int[length];

            for(int i=0; i<length; i++){
                number[i] = Integer.parseInt(X.split("")[i]);
            }

            used = new boolean[length];
            selected = new int[length];

            generateEqualConfiguration(0);

            //System.out.println(sb);
            if(minValue==Integer.MAX_VALUE){
                System.out.print(0);
            }
            else{
                System.out.println(minValue);
            }

        }
    }

    public static void generateEqualConfiguration(int depth){
        if(depth==length){
            for(int num : selected){
                sb.append(num);
            }
            int result = Integer.parseInt(sb.toString());
            if(result > originalNumber){
                minValue = Math.min(minValue, result);

            }
            sb.setLength(0);
            //sb.append("\n");
            return;
        }

        for(int i=0; i<length; i++){
            if(!used[i]){
                used[i] = true;
                selected[depth] = number[i];
                generateEqualConfiguration(depth+1);
                used[i] = false;
            }
        }
    }
}
