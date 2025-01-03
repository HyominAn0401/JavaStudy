package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Silver4_1235 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : N명 학생번호를 뒤에서 k자리만큼 추릴 때 N명 모두 명확하게 구분할 수 있는 최소의 k 출력하기
        // 로직 설계
        // 1. N 입력받고 해당 크기의 학생 번호를 저장할 문자열 배열과 k자리를 자른 문자열을 저장할 배열 생성
        // 2. 학생 번호 길이 저장
        // 3. k자리만큼 자르면서 비교
        // 3-1. Map에 key 값으로 k자리 자른 값 저장
        // 3-2. values 개수가 N이 아니라면 k 증가, N이면 모두 명확하게 구분됐으니 반복문 종료 후 k 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값 입력받기
            int N = Integer.parseInt(br.readLine());
            // N 크기의 학생번호를 저장할 문자열 배열 생성
            String [] numberStr = new String[N];

            // 학생 번호 배열에 저장
            for(int i=0; i<N; i++){
                numberStr[i] = br.readLine();
            }

            // 학생 번호 길이
            int length = numberStr[0].length();

            // k자리 자른 번호를 저장할 문자열 배열 생성
            String [] newNumber = new String[N];

            // k값 초기화
            int k = 0;

            // 반복문을 제어할 boolean 변수 초기화
            boolean isTrue = false;

            // 모든 학생 번호가 다를 때까지 반복
            while(!isTrue){
                // k값 증가
                k++;
                // 뒤에서 k자리만큼 자른 문자열을 배열에 저장
                for(int i=0; i<N; i++){
                    newNumber[i] = numberStr[i].substring(length-k, length);
                }

                // 자른 문자열을 key로 Map 생성 및 추가
                Map<String, Integer> map = new HashMap<>();
                for(int i=0; i<N; i++){
                    map.put(newNumber[i], map.getOrDefault(newNumber[i], 0)+1);
                }

                // values 개수
                int cnt = map.values().size();
                // values 개수가 N이라면 => 학생 번호가 모두 구분되면 반복문 종료
                if(cnt == N)    isTrue = true;
            }
            // k 출력
            System.out.println(k);
        }
    }
}
