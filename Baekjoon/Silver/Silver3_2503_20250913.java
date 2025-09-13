package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_2503_20250913 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 완전탐색으로 모든 세 자리 수에 대해 스트라이크/볼 조건에 맞는 경우의 수 출력하기
        // 로직 설계
        // 1. N개 질문에 대한 숫자, 스트라이크, 볼 값 정보를 이차원 배열에 저장
        // 2. 모든 세 자리 숫자에 대해 반복 (0, 중복 조건 제외)
        // 3. 각 숫자에 대해 모든 조건의 스트라이크, 볼 조건이 만족하는 지 확인하고 모두 만족하는 경우 수를 증가
        // 4. 결과값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 질문 수
            int N = Integer.parseInt(br.readLine());
            // 이차원 배열 (숫자, 스트라이크, 볼)
            int [][] question = new int[N][3];

            // 질문 수 만큼 숫자, 스트라이크, 볼 값 저장
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                question[i][0] = Integer.parseInt(st.nextToken());
                question[i][1] = Integer.parseInt(st.nextToken());
                question[i][2] = Integer.parseInt(st.nextToken());
            }

            // 모든 세 자리 수의 각 값을 저장할 배열
            int [] num = new int[3];
            // 조건값의 각 값을 저장할 배열
            int [] compareNum = new int[3];

            // 결과값 저장 변수
            int result = 0;

            // 모든 세 자리 수에 대해 반복
            for(int i=100; i<1000; i++){
                // 각 자릿수 저장
                num[0] = i/100;
                num[1] = i%100/10;
                num[2] = i%100%10;

                // 0 조건, 중복 조건 제거
                if (num[0]==0 || num[1]==0 || num[2]==0) continue;
                if (num[0]==num[1] || num[1]==num[2] || num[2]==num[0]) continue;

                int cnt = 0;

                // 질문 수만큼 반복
                for(int j=0; j<N; j++){
                    // 숫자의 각 위치값 저장
                    compareNum[0] = question[j][0]/100;
                    compareNum[1] = question[j][0]%100/10;
                    compareNum[2] = question[j][0]%100%10;

                    // 스트라이크, 볼 값
                    int strike = question[j][1];
                    int ball = question[j][2];

                    // 스트라이크, 볼 값 비교할 변수
                    int s_cnt=0, b_cnt = 0;

//                    for(int k=0; k<3; k++){
//                        if(num[k] == compareNum[k]) s_cnt++;
//                    }
//
//                    for(int k=0; k<3; k++){
//                        for(int l=0; l<3; l++){
//                            if(num[k] == compareNum[l])
//                                b_cnt++;
//                        }
//                    }
//
//                    b_cnt -= s_cnt;

                    // 해당 숫자에 대한 스트라이크 개수
                    s_cnt = strike_cnt(num, compareNum);
                    // 해당 숫자에 대한 볼 개수
                    b_cnt = ball_cnt(num, compareNum);

                    // 두 값이 같은 경우 +1
                    if(s_cnt==strike && b_cnt==ball)
                        cnt++;
                }

                // cnt값이 모든 질문 수와 같으면 +1
                if(cnt == N)
                    result++;
            }

            // 결과값 출력
            System.out.println(result);
        }
    }

    // 스트라이크 값 출력
    public static int strike_cnt(int [] num, int [] compareNum){
        int cnt = 0;
        for(int i=0; i<3; i++){
            // 숫자와 위치가 같은 경우
            if(num[i] == compareNum[i]) cnt++;
        }
        return cnt;
    }

    // 볼 값 출력
    public static int ball_cnt(int [] num, int [] compareNum){
        int cnt = 0;
        // 위치는 다르지만 숫자가 같은 경우
        if(num[0]!=compareNum[0] && (num[0]==compareNum[1] || num[0]==compareNum[2]))   cnt++;
        if(num[1]!=compareNum[1] && (num[1]==compareNum[0] || num[1]==compareNum[2]))   cnt++;
        if(num[2]!=compareNum[2] && (num[2]==compareNum[0] || num[2]==compareNum[1]))   cnt++;

        return cnt;
    }
}
