package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze2_19532_20250606 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            for(int x=-999; x<=999; x++){
                for(int y=-999; y<=999; y++){
                    if(x*a+y*b==c && x*d+y*e==f) {
                        System.out.println(x + " " + y);
                        break;
                    }
                }
            }
        }
    }
}
