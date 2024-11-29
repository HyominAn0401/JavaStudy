package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver5_2751 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : N개의 수를 입력받아 오름차순 정렬 출력하기
        // 로직 설계
        // 1. N을 입력받고 N 크기 배열 생성
        // 2. 배열에 숫자 입력받기
        // 3. 오름차순 정렬
        // 4. 배열 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값 입력받기
            int N = Integer.parseInt(br.readLine());
            // N 크기 배열 생성
            long [] numbers = new long[N];

            // 배열에 값 저장
            for(int i=0; i<N; i++){
                numbers[i] = Long.parseLong(br.readLine());
            }

            // 오름차순 정렬
            Arrays.sort(numbers);

            // 배열값 출력
            for(long num : numbers){
                System.out.println(num);
            }
        }
    }
}
