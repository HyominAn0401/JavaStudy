package Kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KaKao2023_150368 {

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
//            int [][] users = {{40,2900}, {23,10000}, {11,5200}, {5,5900}, {40,3100}, {27,9200}, {32,6900}};
//            int [] emoticons = {1300, 1500,1600, 4900};

            int [][] users = {{40,10000}, {25,10000}};
            int [] emoticons = {7000,9000};

            int enrollCnt = 0;
            int totalAmount = 0;
            int [] answer = {0, 0};

            // 사람 수
            int n = users.length;
            int m = emoticons.length;

//            int maxDiscount = Integer.MIN_VALUE;
//            int maxIndex = -1;
//            // 최대 할인 비율 찾기
//            for(int i=0; i<users.length; i++){
//                if(users[i][0] >= maxDiscount){
//                    maxDiscount = users[i][0];
//                    maxIndex = i;
//                }
//            }

            int [] discountRatio = {40, 30, 20, 10};
            // 사람별 임티 구매 총액 저장
            //int [] userAmount = new int[n];

            // 할인 비율
            int [] ratio = {40, 30, 30, 40};

            generateDiscountCombinations(0, new int[m], discountRatio, users, emoticons, answer);

            // 결과값 출력
            for(int answers : answer){
                System.out.print(answers+" ");
            }

        }
    }

    public static void generateDiscountCombinations(int index, int [] ratio, int [] discountRatio, int[][] users, int []emoticons, int[] answer){
        if(index==emoticons.length){
            calculate(users, emoticons, ratio, answer);
            return;
        }

        for(int discount : discountRatio){
            ratio[index] = discount;
            generateDiscountCombinations(index+1, ratio, discountRatio, users, emoticons, answer);
        }
    }

    public static void calculate(int [][] users, int[] emoticons, int[] ratio, int[] answer){
        int enrollCnt = 0;
        int totalAmount = 0;

        // 사람 수
        int n = users.length;
        int m = emoticons.length;

        int [] userAmount = new int[n];

        // 비율 검사
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(ratio[i] >= users[j][0]){
                    userAmount[j] += emoticons[i]*(100-ratio[i])/100;
                }
            }
        }

        // 이모티콘 총구매 비용 및 가입자 수
        for(int i=0; i<n; i++){
            if(userAmount[i] >= users[i][1]){
                userAmount[i] = 0;
                enrollCnt++;
            }
            totalAmount += userAmount[i];
        }

        // 최대 가입자수 비교해 answer에 저장
        if(enrollCnt > answer[0]){
            answer[0] = enrollCnt;
            answer[1] = totalAmount;
        }
        else if(enrollCnt == answer[0]){
            if(totalAmount > answer[1]){
                answer[1] = totalAmount;
            }
        }
    }
}