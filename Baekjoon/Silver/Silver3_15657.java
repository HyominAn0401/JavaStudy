package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver3_15657 {
    static int N, M;
    static int [] selected;
    static int [] numbers;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            selected = new int[M];
            numbers = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(numbers);

            generateSeq(0,0);
            System.out.print(sb);
        }
    }

    public static void generateSeq(int start, int depth){
        if(depth==M){
            for(int num : selected){
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<N; i++){
            selected[depth] = numbers[i];
            generateSeq(start,depth+1);
            start = i+1;
        }
    }
}
