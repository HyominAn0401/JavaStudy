package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze3_14568_20250606 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int N= Integer.parseInt(br.readLine());
            int count = 0;

            for(int a=0; a<N; a++){
                for(int b=0; b<N; b++){
                    for(int c=0; c<N; c++){
                        if(a+b+c==N){
                            if(a>=b+2){
                                if(a!=0 && b!=0 && c!=0){
                                    if(c%2==0)
                                        count++;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(count);

//            int N = Integer.parseInt(br.readLine());
//            int cnt = 0;
//
//            int x=0, y=0, z=0;
//            for(x=1; x<=N; x++){
//                if(x%2==0){
//                    for(y=1; y<=N-x; y++){
//                        if((N-x-y)>=y+2 && N-x-y!=0){
//                            cnt++;
//                        }
//                    }
//                }
//            }
//
//            System.out.println(cnt);
        }
    }
}
