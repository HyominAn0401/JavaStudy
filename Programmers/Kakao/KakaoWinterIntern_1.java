package Kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KakaoWinterIntern_1 {

    // 인덱스 찾기
    static int findIndex(int [] array, int n){
        for(int i=0; i<array.length; i++){
            if(array[i] == n){
                return i;
            }
        }
        return -1;
    }

    // 이름으로 인덱스 찾기
    static int findIndexByName(String[] array, String name){
        for(int i=0; i<array.length; i++){
            if(array[i].equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            //String [] friends = new String[4];
            String [] friends = {"muzi", "ryan", "frodo", "neo"};
            //String [] gifts = new String[7];
            String [] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int i=0; i<4; i++){
//                friends[i] = st.nextToken();
//            }

//            st = new StringTokenizer(br.readLine());
//            for(int i=0; i<7; i++){
//                gifts[i] = st.nextToken();
//            }

            // 2차원 배열 생성
            int [][] giftsTrade = new int[friends.length][friends.length];

            for(int i=0; i< gifts.length; i++){
                // 분리
                String [] part = gifts[i].split(" ");
                String a = part[0];
                String b = part[1];

                int indexA = findIndexByName(friends, a);
                int indexB = findIndexByName(friends, b);

                giftsTrade[indexA][indexB]+=1;
            }

            // 출력 예시
            for(int i=0; i<giftsTrade.length; i++){
                for(int j=0; j<giftsTrade[0].length; j++){
                    System.out.print(giftsTrade[i][j]+" ");
                }
                System.out.println();
            }

            // 선물 지수
            int [] giftNum = new int[friends.length];

            System.out.println();
            System.out.println("선물 지수");
            // 준거 받은거 합계 계산
            for(int i=0; i<giftsTrade.length; i++){
                int sumGive = 0;
                int sumGet = 0;
                for(int j=0; j<giftsTrade[0].length; j++){
                    sumGive += giftsTrade[i][j];
                    sumGet += giftsTrade[j][i];
                }
                //giftsTrade[i][giftsTrade.length-1] = sumGive;
                //giftsTrade[giftsTrade.length-1][i] = sumGet;
                giftNum[i] = sumGive - sumGet;
                System.out.print(giftNum[i]+" ");
                //System.out.println(sumGive);
            }
            //giftsTrade[giftsTrade.length-1][giftsTrade.length-1] = 0;
            System.out.println();

            // 선물 받을 횟수
            int [] results = new int[friends.length];

            for(int i=0; i<giftsTrade.length; i++){
                for(int j=0; j<giftsTrade[0].length; j++){
                    if(i==j)    {
                        System.out.println("대각선은 제외 "+i+" "+j);
                        continue;
                    }
                    // 주고받은 기록이 없거나 주고받은 수가 같은 경우
                    if((giftsTrade[i][j]==giftsTrade[j][i])||(giftsTrade[i][j]==0 && giftsTrade[j][i]==0)){
                        System.out.println("주고받은 기록 노 또는 수가 같음");
                        int giftNum1 = giftNum[i];
                        int giftNum2 = giftNum[j];
                        if(giftNum1 > giftNum2)     {
                            results[i] += 1;
                            System.out.println(results[i]+"에 1추가");
                        }
                        else if(giftNum1 < giftNum2)   {
                            results[j] += 1;
                            System.out.println(results[j]+"에 1추가");
                        }
                        System.out.println();
                    }
                    // 주고받은 기록이 있을 때
                    else{
                        System.out.println("기록 있음");
                        if(giftsTrade[i][j] > giftsTrade[j][i]) {
                            results[i]++;
                            System.out.println(results[i]+"에 1추가");
                        }
                        else if(giftsTrade[i][j] < giftsTrade[j][i]) {
                            results[j]++;
                            System.out.println(results[j]+"에 1추가");
                        }
                        System.out.println();
                    }
                }
            }

            // 배열 새로
            int maxValue = Integer.MIN_VALUE;
            for(int result : results){
                result = result/2;
                if(result > maxValue)   maxValue=result;
            }

            System.out.println(maxValue);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
