package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Silver4_1302 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 해싱 이용해 가장 큰 값의 key값 출력하기
        // 로직 설계
        // 1. N 입력받고 N번 책 제목 입력받기
        // 2. map에 책 이름과 팔린 횟수 저장, 처음이면 0으로 저장
        // 3. 값이 가장 큰 key 출력하기. 값이 같으면 사전순 앞에 있는 key 출력하기

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 책 권수 입력받기
            int N = Integer.parseInt(br.readLine());
            // 책 제목 및 권수 map
            Map<String, Integer> books = new HashMap<>();

            // N번 반복
            for(int i=0; i<N; i++){
                // 책 제목 입력받기
                String title = br.readLine();
                // map에 저장
                books.put(title, books.getOrDefault(title,0)+1);
            }

            // key를 저장할 변수
            String maxKey=null;
            // 가장 큰 값 저장할 변수
            int maxValue = Integer.MIN_VALUE;
            // 가장 큰 값 찾기
            for(String key : books.keySet()){
                int value = books.get(key);
                // 값 비교, 만약 값이 같으면 사전순으로 앞에 오는 값
                if(value > maxValue || (value == maxValue && key.compareTo(maxKey)<0)){
                    maxValue = value;
                    maxKey = key;
                }
            }
            // 출력
            System.out.print(maxKey);
        }
    }
}
