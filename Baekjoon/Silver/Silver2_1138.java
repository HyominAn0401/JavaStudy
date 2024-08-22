package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_1138 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int N = Integer.parseInt(br.readLine());

            int [] result = new int[N];
            int [] line = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                line[i] = Integer.parseInt(st.nextToken());
            }

            int pt = 0;

            /*
            for(int i=0; i<N; i++){
                pt = line[i];
                while(true){
                    if(result[pt]==0){
                        result[pt] = (i+1);
                        pt = 0;
                        break;
                    }
                    else{
                        int cntZero = 0;
                        int pt2= 0;
//                        while(cntZero <= pt){
//                            if(result[pt2] == 0)
//                                cntZero++;
//                            pt2++;
//                        }
                        while(true){
                            if(result[pt2]==0){
                                cntZero++;
                            }
                            if(cntZero > pt){
                                break;
                            }
                            pt2++;
                        }
                        pt = pt2;
                    }
                }
            }*/

            for(int i=0; i<N; i++){
                int count = line[i];
                for(int j=0; j<N; j++){
                    if(result[j]==0 && count==0){
                        result[j] = (i+1);
                        break;
                    }
                    else if(result[j]==0){
                        count--;
                    }
                }
            }

            for(int height : result)
                System.out.print(height+" ");
        }
    }
}
