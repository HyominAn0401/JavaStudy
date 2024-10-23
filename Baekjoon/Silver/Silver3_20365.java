package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver3_20365 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            long N = Long.parseLong(br.readLine());
            String colors = br.readLine();

            int operations = 1;

            char firstColor = colors.charAt(0);

            for(int i=1; i<N; i++){
                char nextColor = colors.charAt(i);
                if(nextColor != firstColor)
                    operations++;
                firstColor = nextColor;
            }

            System.out.println((operations/2)+1);
        }
    }
}
