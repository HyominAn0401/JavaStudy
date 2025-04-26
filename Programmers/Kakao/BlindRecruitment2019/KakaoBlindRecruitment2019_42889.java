package Kakao.BlindRecruitment2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KakaoBlindRecruitment2019_42889 {

    public static void main(String[] args) {
        int N = 4;
        int [] stages = {4,4,4,4,4};
        int [] answers = solution(N, stages);
        for(int n : answers){
            System.out.println(n);
        }
    }

    public static int[] solution(int N, int [] stages){
        int playersCnt = stages.length;
        int count = 0;
        List<Pair> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            int numCnt = 0;
            for(int j=0; j<playersCnt; j++){
                if(stages[j]==i){
                    numCnt++;
                }
            }
            //list.add(new Pair(i, ((float)numCnt/(playersCnt-count))));
            if (playersCnt - count == 0) {
                list.add(new Pair(i, 0f));
            } else {
                list.add(new Pair(i, ((float)numCnt/(playersCnt-count))));
            }
            count += numCnt;
        }
        Collections.sort(list, (a,b)-> Float.compare(b.rate, a.rate));
        int [] answer = new int[N];

        for(int i=0; i<N; i++){
            answer[i] = list.get(i).stage;
        }

        return answer;
    }

    static class Pair{
        private int stage;
        private float rate;

        public Pair(int stage, float rate){
            this.stage = stage;
            this.rate = rate;
        }
    }
}
