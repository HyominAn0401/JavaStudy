package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver3_10973 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] numbers = new int[N];
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            StringBuilder sb = new StringBuilder();

            int i=N-1;
            // 끝에서부터 찾기
            // 처음으로 a[i-1] > a[i]인 지점 찾기
            while(true){
                if(i<1){
                    System.out.print(-1);
                    break;
                }

                if(numbers[i-1] > numbers[i]){
                    int j = N-1;
                    while(j>=i && numbers[j] >= numbers[i-1]){
                        j--;
                    }
                    numbers = swap(numbers, i-1, j);
                    numbers = reverse(numbers, i);
                    for(int n : numbers){
                        sb.append(n+" ");
                    }
                    System.out.print(sb);
                    break;
                }

                i--;
            }

        }
    }

    // swap
    public static int[] swap(int[] numbers, int i, int j){
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
        return numbers;
    }

    public static int[] reverse(int[] numbers, int i){
        int [] reverseNumbers = new int[numbers.length-i];
        for(int n=0; n<reverseNumbers.length; n++){
            reverseNumbers[n] = numbers[n+i];
        }

        Arrays.sort(reverseNumbers);

//        for(int n=reverseNumbers.length-1; n>=0; n--){
//            numbers[n+i] = reverseNumbers[n];
//        }
        for(int n=0; n<reverseNumbers.length; n++){
            numbers[i+n] = reverseNumbers[reverseNumbers.length-1-n];
        }

        return numbers;
    }
}
