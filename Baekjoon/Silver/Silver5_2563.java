package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_2563 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int [][] people = new int[N][2];
            int [] rank = new int[N];

            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int weight = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());
                people[i][0] = weight;
                people[i][1] = height;
            }

            for(int i=0; i<N; i++){
                int count = 0;
                for(int j=0; j<N; j++){
                    if(i!=j){
                        if(people[i][0]<people[j][0] && people[i][1] < people[j][1]){
                            count++;
                        }
                    }
                }
                rank[i] = count+1;
            }

            for(int ranks : rank){
                System.out.print(ranks+" ");
            }
        }
    }
}
