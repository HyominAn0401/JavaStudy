package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver5_15720 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 버거, 사이드메뉴, 음료 개수와 가격을 입력받고 할인 적용 전후 가격을 출력하기
        // 로직 설계
        // 1. 버거, 사이드메뉴, 음료 개수 입력받고 가격 배열에 저장
        // 2. 내림차순 정렬
        // 3. 이차원 배열을 생성해 3개 모두 할인 적용하고 남은 금액 합
        // 4. 원래 가격과 할인 적용한 가격 출력

        try(BufferedReader br= new BufferedReader(new InputStreamReader(System.in))){
            // 버거, 사이드, 음료 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int burger = Integer.parseInt(st.nextToken());
            int side = Integer.parseInt(st.nextToken());
            int drink = Integer.parseInt(st.nextToken());

            // 개수에 맞는 각 배열 생성
            int [] burgers = new int[burger];
            int [] sides= new int[side];
            int [] beverages= new int[drink];

            // 처음 가격 합과 할인율 적용된 가격의 합 저장할 변수
            int firstSum = 0;
            int secondSum = 0;

            // 버거 가격 저장 및 가격 누적합
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<burger; i++){
                burgers[i] = Integer.parseInt(st.nextToken());
                firstSum += burgers[i];
            }
            // 사이드 가격 저장 및 가격 누적합
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<side; i++){
                sides[i] = Integer.parseInt(st.nextToken());
                firstSum += sides[i];
            }
            // 음료 가격 저장 및 가격 누적합
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<drink; i++){
                beverages[i] = Integer.parseInt(st.nextToken());
                firstSum += beverages[i];
            }

            // 오름차순 정렬
            Arrays.sort(burgers);
            Arrays.sort(sides);
            Arrays.sort(beverages);

            // 버거 가격 내림차순 정렬
            for(int i=0; i<burgers.length/2; i++){
                int temp = burgers[i];
                burgers[i] = burgers[burgers.length-1-i];
                burgers[burgers.length-1-i] = temp;
            }
            // 사이드 가격 내림차순 정렬
            for(int i=0; i<sides.length/2; i++){
                int temp = sides[i];
                sides[i] = sides[sides.length-1-i];
                sides[sides.length-1-i] = temp;
            }
            // 음료 가격 내림차순 정렬
            for(int i=0; i<beverages.length/2; i++){
                int temp = beverages[i];
                beverages[i] = beverages[beverages.length-1-i];
                beverages[beverages.length-1-i] = temp;
            }

            // 모든 배열을 합한 이차원 배열
            int [][] menus = new int [3][];
            menus[0] = burgers;
            menus[1] = sides;
            menus[2] = beverages;

            // 최솟값 최댓값
            int minValue = burgers.length < sides.length ? burgers.length : sides.length;
            minValue = minValue < beverages.length ? minValue : beverages.length;
            int maxValue = burgers.length > sides.length ? burgers.length : sides.length;
            maxValue = maxValue > beverages.length ? maxValue : beverages.length;

            // 할인 적용된 가격 누적
            for(int i=0; i<minValue; i++){
                secondSum += burgers[i]*0.9 + sides[i]*0.9 + beverages[i]*0.9;
            }
            // 남은 가격 저장
            int left = 0;
            for(int i=minValue; i<maxValue; i++){
                if(i < burgers.length){
                    left += burgers[i];
                }
                if(i < sides.length){
                    left += sides[i];
                }
                if(i < beverages.length){
                    left += beverages[i];
                }
            }

            // 출력
            System.out.print(firstSum+"\n"+(secondSum+left));
        }
    }
}
