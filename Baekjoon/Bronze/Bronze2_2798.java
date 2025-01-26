package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze2_2798 {
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int [] numArray = new int[N];

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++){
                numArray[i] = Integer.parseInt(st.nextToken());
            }

            int result = numResult(numArray);

            System.out.println(result);
        }
    }

    public static int numResult(int [] numArray){
        int maxSum = 0;
        for(int i=0; i<=N-3; i++){
            for(int j=i+1; j<=N-2; j++){
                for(int k=j+1; k<=N-1; k++){
                    int sum = numArray[i] + numArray[j] + numArray[k];
                    if(sum<=M && sum> maxSum)
                        maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}
