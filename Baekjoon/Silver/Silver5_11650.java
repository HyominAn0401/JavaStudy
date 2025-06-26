package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Silver5_11650 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            List<Dot> dots = new ArrayList<>();

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                dots.add(new Dot(x, y));
            }

            Comparator<Dot> byIncreasingX = (a,b) -> {
                if(a.x!= b.x){
                    return a.x - b.x;
                }
                else return a.y - b.y;
            };

            dots.sort(byIncreasingX);

            for(Dot dot : dots){
                System.out.println(dot.x+" " +dot.y);
            }
        }
    }

    static class Dot{
        int x;
        int y;

        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
