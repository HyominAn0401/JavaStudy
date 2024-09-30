package Silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_1912 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int [] num = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            int currentSum = num[0];
            int maxValue = currentSum;

            for(int i=1; i<N; i++){
                currentSum = Math.max(currentSum+num[i], num[i]);
                maxValue = Math.max(currentSum, maxValue);
            }

            System.out.println(maxValue);
        }
    }
}
