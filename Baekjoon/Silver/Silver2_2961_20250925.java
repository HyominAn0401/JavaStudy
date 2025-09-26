package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_2961_20250925 {
    static int [][] ingre;
    static int N;
    static int minValue = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            N = Integer.parseInt(br.readLine());

            ingre = new int[N][2];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                ingre[i][0] = Integer.parseInt(st.nextToken());
                ingre[i][1] = Integer.parseInt(st.nextToken());
            }

            // 재료를 사용할때마다 use 하나씩 증가
            recur(0, 0, 1, 0);
        }
    }

    // 재료의 인덱스 번호
    public static void recur(int index, int dan, int zzan, int use){

        if(index==N){
            if(use==0) //아무 재료도 사용하지 않음
                return;
            int result = Math.abs(dan-zzan);
            minValue = Math.min(minValue, result);
            return;
        }
        //재료를 사용함 -> 값 추가
        recur(index+1, dan+ingre[index][0], zzan*ingre[index][1], use+1);

        // 재료를 사용하지 않음 -> 유지
        recur(index+1, dan, zzan, use);
    }
}
