package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze3_14568 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : N개 사탕을 조건에 맞게 3명에게 나눠줄 수 있는 경우의 수 구하기 - 브루트 포스
        // 로직 설계
        // 1. N을 입력받고 a,b,c 초기화
        // 2. c에 2부터 시작하고 N보다 작은 짝수값을 넣어주면서 반복
        // 3. N-c 값이 4보다 작으면 종료 -> a는 b보다 무조건 2개 이상 많아야 하고 b는 1 이상이므로
        // 4. b는 1부터 시작하고 N보다 작은 값들을 넣어주면서 반복
        // 5. a는 (N-c)-j값, a-2가 b보다 크거나 같으면 조건에 만족하므로 경우의 수 증가
        // 6. 반복문 종료 시 결과값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
//            // 사탕의 개수 N 입력받기
//            int N = Integer.parseInt(br.readLine());
//            // 3명에게 나눠줄 사탕 개수를 저장할 변수
//            int a=0, b=0, c=0;
//
//            // 경우의 수를 저장할 변수
//            int count = 0;
//            // c에 N보다 작은 짝수를 넣어가며 반복
//            for(int i=2; i<N; i+=2){
//                c = i;
//                // a+b가 4보다 작으면 종료
//                if(N-c < 4){
//                    break;
//                }
//                // b에 1부터 N보다 작은 수를 넣어가며 반복
//                for(int j=1; j<N; j++){
//                    b = j;
//                    a = (N-c)-j;
//                    // a-2>= b 조건에 만족하면 경우의 수 증가
//                    if(a-2 >= b)
//                        count++;
//                }
//            }
//            // 결과값 출력
//            System.out.println(count);

            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            for(int i=0; i<=N; i++){
                for(int j=0; j<=N; j++){
                    for(int k=0; k<=N; k++){
                        if(i+j+k==N){
                            if(i >= j+2){
                                if(i!=0 && j!=0 && k!=0) {
                                    if (k % 2 == 0) {
                                        answer++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
