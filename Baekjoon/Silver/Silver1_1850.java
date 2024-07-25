package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_1850 {

    static long gcd(long A, long B){
        if(B==0)    return A;
        else{
            return gcd(B, A%B);
        }
    }

    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 자연수 A, B를 입력받고 A와 B의 최대공약수를 출력한다
        // 로직 설계
        // 1. A와 B의 1의 개수를 각각 입력받는다
        // 2. 두 수의 최대 공약수를 구한다
        // 3. 최대공약수 길이만큼 1을 출력한다

        // BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // A와 B의 1의 개수 입력받기
            StringTokenizer st= new StringTokenizer(br.readLine());
//            int cntA = Integer.parseInt(st.nextToken());
//            int cntB = Integer.parseInt(st.nextToken());
            long cntA = Long.parseLong(st.nextToken());
            long cntB = Long.parseLong(st.nextToken());

            // StringBuilder 생성
            StringBuilder sb = new StringBuilder();

//            StringBuilder sbA = new StringBuilder();
//            StringBuilder sbB = new StringBuilder();
//
//            for(int i=0; i<cntA; i++){
//                sbA.append(1);
//            }
//
//            for(int i=0; i<cntB; i++){
//                sbB.append(1);
//            }
//
//            System.out.println(gcd(Long.parseLong(sbA.toString()), Long.parseLong(sbB.toString())));

            // 최대 공약수 구하기
            long result = gcd(cntA, cntB);

            // 결과값 만큼 1 추가
            for(int i=0; i<result; i++){
                sb.append(1);
            }
            // 결과값 출력하기
            System.out.println(sb);

        }
    }
}
