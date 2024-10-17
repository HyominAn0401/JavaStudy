package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver5_16435 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 처음 길이에서 늘릴 수 있는 최대 길이 출력
        // 로직 설계
        // 1. 과일 개수, 스네이크버드 처음 길이 입력받고 배열 생성
        // 2. 배열에 과일 달린 높이 저장
        // 3. 배열 오름차순 정렬
        // 4. 가장 낮은 높이부터 시작해 길이 증가

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 과일 개수, 스네이크버드 처음 길이 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fruit = Integer.parseInt(st.nextToken());
            int snake = Integer.parseInt(st.nextToken());

            // 과일 높이 저장할 배열 생성
            int [] fruitsHeight = new int[fruit];

            // 배열에 높이 저장
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<fruit; i++){
                fruitsHeight[i] = Integer.parseInt(st.nextToken());
            }

            // 높이 오름차순 정렬
            Arrays.sort(fruitsHeight);

            // 과일 개수만큼 반복
            for(int i=0; i<fruit; i++){
                // 스네이크버드 길이가 과일 높이보다 크거나 같은 경우
                if(snake >= fruitsHeight[i])
                    // 증가
                    snake+=1;
                // 더 이상 증가할 수 없는 경우 종료
                else break;
            }

            // 출력
            System.out.println(snake);
        }
    }
}
