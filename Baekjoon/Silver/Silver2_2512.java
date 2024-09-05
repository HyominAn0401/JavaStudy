package Silver.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2_2512 {

    public static int N;
    public static int [] budget;
    public static void main(String[] args) throws Exception{

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            N = Integer.parseInt(br.readLine());
            budget = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                budget[i] = Integer.parseInt(st.nextToken());
            }

            int nationalbudget = Integer.parseInt(br.readLine());

            Arrays.sort(budget);

//            for(int money : budget){
//                System.out.print(money+" ");
//            }
//            System.out.println();

            int sum = 0;
            for(int i=0; i<N; i++){
                sum += budget[i];
            }

            int [] maximumPrice = new int[budget[N-1]-budget[0]+1];
            int j = 0;
            for(int i=budget[0]; i<=budget[N-1]; i++){
                maximumPrice[j] = i;
                j++;
            }
            System.out.println(sum<= nationalbudget? budget[N-1]: binarySearch(maximumPrice, nationalbudget));
        }
    }

    public static int binarySearch(int [] array, int nationalBudget){
        int start = 0;
        int end = array.length-1;

        int answer = 0;

        while(start <= end){
            int sum = 0;
            int mid = (start+end)/2;
            answer = array[mid];

            for(int i=0; i<N; i++){
                if(budget[i] >= answer){
                    sum += answer;
                }
                else{
                    sum += budget[i];
                }
            }

            if(sum > nationalBudget) {
                end = mid - 1;
                //System.out.println("end "+end);
            }
            else {
                answer = array[mid];
                start = mid+1;
                System.out.println("start "+start);
            }
        }

        return answer;
    }
}
