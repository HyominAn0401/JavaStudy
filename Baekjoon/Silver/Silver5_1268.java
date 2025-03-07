package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver5_1268 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int N = Integer.parseInt(br.readLine());
            int [][] classes = new int[N][N];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    classes[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxValue = 0;
            int president = 0;

            for(int i=0; i<N; i++){
                Set<Integer> students = new HashSet<>();

                for(int j=0; j<N; j++){
                    for(int k=0; k<N; k++){
                        if(i!=k && classes[i][j]==classes[k][j]){
                            students.add(k);
                        }
                    }
                }


                if(students.size() > maxValue){
                    maxValue = students.size();
                    president = i+1;
                }
            }

            System.out.println(president);
        }
    }
}
