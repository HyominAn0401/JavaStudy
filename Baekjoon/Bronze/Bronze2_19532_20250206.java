package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze2_19532_20250206 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            printXandY(a, b, c, d, e, f);
        }
    }

    public static void printXandY(int a, int b, int c, int d, int e, int f){
        for(int x=-999; x<=999; x++){
            for(int y=-999; y<=999; y++){
                if(a*x+b*y==c && d*x+e*y==f) {
                    System.out.println(x + " " + y);
                    return;
                }
            }
        }
    }
}
