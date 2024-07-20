package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver4_1920 {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            int [] numbers = new int[N];


            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);

            int M = Integer.parseInt(br.readLine());

            boolean [] foundOrNot = new boolean[M];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                int x = Integer.parseInt(st.nextToken());
                int start =0, end=N-1, mid=0;
                while(start <= end){
                    mid = (start+end)/2;
                    if(x < numbers[mid])
                        end = mid-1;
                    else if(x > numbers[mid])
                        start = mid+1;
                    else {//찾음
                        foundOrNot[i] = true;
                        break;
                    }
                }
            }
            for(int i=0; i<M; i++){
                if(foundOrNot[i])
                    sb.append("1\n");
                else sb.append("0\n");
            }
            System.out.println(sb);
        }
    }
}
