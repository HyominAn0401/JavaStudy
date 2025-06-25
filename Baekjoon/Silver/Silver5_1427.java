package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Silver5_1427 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String number = br.readLine();
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<number.length(); i++){
                list.add(Integer.parseInt(number.split("")[i]));
            }

            list.sort(Collections.reverseOrder());
            for(int n : list){
                System.out.print(n);
            }
        }
    }
}
