package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver4_2839 {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int originN = N;

            int [] bags = {5,3};
            int cnt = 0;
            int newCnt =0;

            for(int bag : bags){
                cnt += N/bag;
                N = N%bag;

                System.out.println("bag: "+bag+", cnt: "+cnt+", N: "+N);
            }

            if(N==0)
//                cnt = -1;
                System.out.println(cnt);
            else if(N!=0)   {
                cnt =-1;
                System.out.println(cnt);
                for(int bag: bags){
                    if(originN % bag==0)

                }
            }

           // System.out.println(cnt);
        }
    }
}
