package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bronze1_1526 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br= new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            // 금민수 : 4와 7로만 이루어진 수
            // 은민이는 4와 7외 나머지 숫자 싫어함
            // N보다 작거나 같은 금민수 중 가장 큰 숫자 출력하기

            // 모든 경우의 수를 다 따지고 가장 가까운 금민수 출력하기
            // 거꾸로 계산하는 게 나을지도
            for(int i=N; i>=4; i--){
                String strN = String.valueOf(i);
                for(char c : strN.toCharArray()){
                    if(c!='4' && c!='7') {
                        System.out.println(strN);
                        break;
                    }
                }
            }
        }
    }
}
