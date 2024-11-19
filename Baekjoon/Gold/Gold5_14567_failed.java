package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gold5_14567_failed {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] subjects = new ArrayList[N+1];
            int [] subjectCnt = new int[N+1];

            for(int i=1; i<=N; i++){
                subjectCnt[i] = 1;
            }

            for(int i=1; i<=N; i++){
                subjects[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                subjects[s].add(e);
            }

            for(int i=1; i<=N; i++){
                for(int num : subjects[i]){
                    //subjectCnt[num] += 1;
                    subjectCnt[num] += subjectCnt[i];
                }
            }

            for(int i=1; i<=N; i++){
                System.out.print(subjectCnt[i]+" ");
            }
        }
    }
}
