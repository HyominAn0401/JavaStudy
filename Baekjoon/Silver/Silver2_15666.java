package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_15666 {
    static int [] selected;
    static int [] numbers;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            numbers = new int[N];
            selected = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);

            generateSeq(0, 0);

            for(String str : set){
                System.out.println(str);
            }
        }
    }

    public static void generateSeq(int start, int depth){
        if(depth==M){
            for(int num : selected){
                sb.append(num+" ");
            }
            set.add(sb.toString());
            sb.delete(0, sb.length());
            return;
        }

        for(int i=start; i<N; i++){
            selected[depth] = numbers[i];
            generateSeq(i, depth+1);
        }
    }
}
