package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_2343 {
    //static Long [] lesson;
    static int [] lesson;
    static int N, M;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st= new StringTokenizer(br.readLine());
//            Long lessons = Long.parseLong(st.nextToken());
//            Long blurays = Long.parseLong(st.nextToken());
//
//            lesson = new Long[lessons.intValue()];
//            Long sum = ;
//
//            st = new StringTokenizer(br.readLine());
//            for(int i=0; i<lesson.length; i++){
//                lesson[i] = Long.parseLong(st.nextToken());
//            }
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            lesson = new int[N];

            int sum =0;

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                lesson[i] = Integer.parseInt(st.nextToken());
                sum += lesson[i];
            }
            //System.out.println(lesson[N-1]+" "+ sum);
            System.out.println(binarySearch(lesson[N-1], sum));

        }
    }

    public static int binarySearch(int start, int end){
        int mid = 0;
        while(start<=end){ //9 45
            mid = (start+end)/2; // 17
            int cnt = 0, sum = 0;

            //System.out.println(N);
            for(int i=0; i<N; i++){
                if((sum + lesson[i]) > mid){
                    sum = lesson[i];
                    cnt++;
                    System.out.println("mid : "+mid+", cnt: "+cnt+", sum: "+sum);
                }
                else{
                    sum += lesson[i];
                    //System.out.println("sum: "+sum);
                }
                //System.out.println("WTF?");
            }
            if(sum <= mid)  cnt++;
            System.out.println("Result: cnt: "+cnt+", sum: "+sum);

            if(cnt > M) {
                start = mid + 1;
                System.out.println("start "+(mid+1));
            }
            else {
                end=mid-1;
                System.out.println("end "+(mid-1));
            }
        }

        return mid;
    }
}
