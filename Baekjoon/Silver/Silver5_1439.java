package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver5_1439 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 0, 1로 이루어진 문자열을 뒤집어 모두 같은 숫자로 만들 때 뒤집는 최소한의 횟수
        // 로직 설계
        // 1. 문자열을 입력받고 분해해 배열에 저장
        // 2. 배열의 두 값을 비교하며 0과 1의 묶음 수 계산
        // 3. 두 묶음 수 중 작은 값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 문자열 입력받기
            String str = br.readLine();
            // 바이트 배열 생성
            byte [] binary = new byte[str.length()];
            // 문자열을 분해해 바이트 배열에 값 저장
            for(int i=0; i<str.length(); i++){
                binary[i] = (byte) (str.charAt(i)-'0');
            }
            // 포인터 역할 변수 초기화
            int i=0, j=1;
            // 0과 1 묶음을 각각 저장할 변수
            int zeroCnt = 0, oneCnt = 0;

            // 문자열 길이만큼 반복
            while(true){
                // j가 문자열 길이보다 커지면
                if(j>= binary.length){
                    // 마지막 값이 0과 1일때
                    if(binary[i]==0)  zeroCnt++;
                    else oneCnt++;
                    break;
                }
                // i 위치와 j 위차값이 다를 때
                if(binary[i] != binary[j]){
                    // i 위치값이 0이거나 1일때 각 변수 증가
                    if(binary[i] ==0)   zeroCnt++;
                    else oneCnt++;
                }
                // i, j 증가
                i++; j++;
//                // i 위치와 j 위치값이 같을 때
//                if(binary[i] == binary[j]){
//                    // 포인터 위치 증가
//                    i++; j++;
//                }
//                // 값이 다를때
//                else{
//                    // i 위치 값이 0이면
//                    if(binary[i] ==0)
//                        zeroCnt++;
//                    else oneCnt++;
//                    //
//                    i++; j++;
//                }
            }
            // 더 작은 값 출력
            int minValue = Math.min(zeroCnt, oneCnt);
            System.out.println(minValue);
        }
    }
}
