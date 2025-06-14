package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bronze3_2501 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // N의 약수들 중 K번째로 작은 수 구하기
            List<Integer> numList = new ArrayList<>();
            // 1-N까지 N을 나누고 배열 아니면 List에 넣기
            for(int i=1; i<=N; i++){
                if(N%i==0){
                    numList.add(i);
                }
            }
            // 오름차순 정렬하기 -> 할 필요 없음
            // K+1번째 수 출력
            if(numList.size()<K){
                System.out.println(0);
            }
            else{
                System.out.println(numList.get(K-1));
            }
        }
    }
}
