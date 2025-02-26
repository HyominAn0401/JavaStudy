package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver5_5800 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : K개 반 성적 중 최대 최소 가장큰 점수 차이를 출력한다.
        // 로직 설계
        // 1. K 크기의 ArrayList 배열을 생성하고 초기화한다.
        // 2. K번 반복하면서 ArrayList 배열을 오름차순 정렬하고, 최대, 최소 점수를 구한다.
        // 3. 오름차순으로 정렬된 배열에서 가장 큰 점수 차이를 구하고 출력한다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // K 입력받기
            int K = Integer.parseInt(br.readLine());
            // K 크기의 ArrayList 배열 생성
            ArrayList<Integer> [] arrayLists = new ArrayList[K];
            // 결과를 저장할 StringBuilder 객체
            StringBuilder sb = new StringBuilder();

            // K번 반복
            for(int i=0; i<K; i++){
                // ArrayList 배열 초기화
                arrayLists[i] = new ArrayList<>();
                // 점수 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                // 학생 수
                int count = Integer.parseInt(st.nextToken());
                // 학생 수만큼 성적 입력받아 ArrayList 배열에 저장
                for(int j=0; j<count; j++){
                    arrayLists[i].add(Integer.parseInt(st.nextToken()));
                }

                // 오름차순 정렬
                Collections.sort(arrayLists[i]);

                // 최대 최솟값 구하기
                int maxValue = arrayLists[i].get(count-1);
                int minValue = arrayLists[i].get(0);
                int gap = 0;

                // 가장 큰 점수 차이 구하기 위한 배열 탐색
                for(int j=0; j<count-1; j++){
                    // 가장 큰 점수 차이 저장
                    gap = Math.max((arrayLists[i].get(j+1)-arrayLists[i].get(j)), gap);
                }

                // sb 객체에 저장
                sb.append("Class "+(i+1)+"\n"+"Max "+maxValue+", Min "+minValue+", Largest gap "+gap+"\n");
            }

            // 결과 출력
            System.out.print(sb);
        }
    }
}
