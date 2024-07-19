package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Silver4_10816 {

//    private static ArrayList<Card>[] cards;
    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static int numbers [];

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());
            //cards = new ArrayList[N];
            numbers = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                int start = 0;
                int end = N-1;
                int mid = (start+end)/2;
                int median = numbers[mid];

                int findNum = Integer.parseInt(st.nextToken());
                while(start <= end){

                    if(median < findNum)    start = mid+1;
                    else if(median > findNum)   end = mid-1;
                    else if(median == findNum)  break;
                    else break;
                }


            }
        }
    }
}

//class Card{
//    int number, cnt;
//    public Card(int number, int cnt){
//        this.number = number;
//        this.cnt = cnt;
//    }
//}