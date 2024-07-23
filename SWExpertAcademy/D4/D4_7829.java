package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_7829 {
    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 각 테스트 케이스 별 입력받은 N의 약수들을 통해 N값 출력하기
        // 로직 설계
        // 1. 테스트 케이스 입력받고, 각 테스트 케이스 별 약수의 개수를 입력받고 해당 크기의 배열 생성하기
        // 2. 배열에 약수 입력 후 오름차순 정렬하기
        // 3. 약수의 개수가 짝수와 홀수일 때 나눠 결과값 구하고 출력하기

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 결과를 출력할 StringBuilder 생성
            StringBuilder sb = new StringBuilder();

            // 테스트 케이스 입력받기
            int testCase = Integer.parseInt(br.readLine());

            // 테스트 케이스만큼 반복하기
            for(int i=0; i<testCase; i++){
                // 약수의 개수 입력받기
                int N = Integer.parseInt(br.readLine());
                // 약수 개수 크기의 배열 생성하기
                int [] array = new int[N];

                // 배열에 약수 저장하기
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    array[j] = Integer.parseInt(st.nextToken());
                }

                // 배열값 오름차순 정렬
                Arrays.sort(array);
                // 결과값을 저장할 변수
                int result =0;

                // 길이가 짝수이면
                if(array.length %2==0){
                    // 첫 번째 값과 마지막 값의 곱
                    result = array[0]*array[array.length-1];
                }
                // 길이가 홀수면
                else
                    // 중앙값의 제곱값 
                    result = (int)(Math.pow(array[(0+array.length-1)/2],2));

                // 테스트 케이스 별 결과값 sb에 추가
                sb.append("#"+(i+1)+" "+result+"\n");
            }

            // 출력하기
            System.out.println(sb.toString());
        }
    }
}
