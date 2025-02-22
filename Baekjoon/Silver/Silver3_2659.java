package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver3_2659 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 카드에 입력할 숫자를 저장할 변수
            int [] num = new int[4];
            // 결과를 처리할 StringBuilder 객체
            StringBuilder sb = new StringBuilder();
            // 중복처리를 할 set
            Set<Integer> set = new HashSet<>();

            // 숫자 입력받아 배열에 저장
            for(int i=0; i<4; i++){
                num[i] = Integer.parseInt(st.nextToken());
                sb.append(num[i]);
            }

            // 가장 작은 값
            int minNum = Integer.parseInt(sb.toString());

            // sb 객체에 모든 시계수 저장
            for(int i=0; i<3; i++){
                char first = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(first);

                // 가장 작은 시계수 구하기
                int newNum = Integer.parseInt(sb.toString());
                minNum = Math.min(minNum, newNum);
            }

            StringBuilder sb2 = new StringBuilder();

            // 1111부터 9999까지 모든 경우의 수 탐색
            for(int i=1111; i<=9999; i++){
                // 천 백 십 일의 자리
                int num1 = i/1000;
                int num2 = i%1000/100;
                int num3 = i%1000%100/10;
                int num4 = i%1000%100%10;

                // 값이 하나라도 0이면 continue
                if(num1==0 || num2==0 || num3==0 || num4==0)
                    continue;

                // 길이를 0으로 업데이트
                sb2.setLength(0);
                // 이어붙이기
                sb2.append(num1).append(num2).append(num3).append(num4);

                int minClock = Integer.parseInt(sb2.toString());

                // 3번 반복
                for(int j=0; j<3; j++){
                    char ch = sb2.charAt(0);
                    sb2.deleteCharAt(0);
                    sb2.append(ch);
                    int newNum = Integer.parseInt(sb2.toString());
                    minClock = Math.min(newNum, minClock);
                }

                // set에 저장
                set.add(minClock);
            }

            // 리스트로 저장 후 정렬
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            // 인덱스 출력
            int location = list.indexOf(minNum)+1;

            System.out.println(location);

        }
    }
}
