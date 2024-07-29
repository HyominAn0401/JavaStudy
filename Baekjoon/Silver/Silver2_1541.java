package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver2_1541 {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String str = br.readLine();
            String []  expression = str.split("-");

            int result = Integer.parseInt(expression[0]);

            System.out.println(expression.length);

            for(int i =1; i<expression.length; i++){
                int num =0;
                for(int j=0; j<expression[i].length(); i++){
                    System.out.println(expression[i].length());
//                    if(j==0 || j%2==0)
//                        num += Integer.parseInt(expression[j]);
                }
                result -= num;
            }

            System.out.println(result);
        }
    }
}
