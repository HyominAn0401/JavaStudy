package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze3_14568_20250913 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int candy = Integer.parseInt(br.readLine());
            int cnt = 0;
            for(int x=0; x<candy; x++){
                for(int y=0; y<candy; y++){
                    for(int z=0; z<candy; z++){
                        if(x+y+z==candy){
                            if(z>=y+2){
                                if(x!=0 && y!=0 && z!=0){
                                    if(x%2==0){
                                        cnt++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
