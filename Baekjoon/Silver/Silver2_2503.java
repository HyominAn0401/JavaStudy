package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_2503 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int [][] hint = new int[N][3];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++){
                    hint[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            int answer = 0;

            for(int a=1; a<=9; a++){
                for(int b=1; b<=9; b++){
                    for(int c=1; c<=9; c++){
                        if(a==b || b==c || c==a){
                            continue;
                        }
                        int cnt = 0;

                        for(int i=0; i<N; i++){
                            int number = hint[i][0];
                            int strike = hint[i][1];
                            int ball = hint[i][2];
                            int [] target = {a,b,c};
                            int [] guess = {number/100, number%100/10, number%100%10};
                            int [] strikesAndBalls = countStrikeAndBall(target, guess);

//                            int strike_cnt = strikeCount(a, b, c, number);
//                            int ball_cnt = ballCount(a, b, c, number);
//
//                            if(ball==ball_cnt && strike_cnt==strike){
//                                cnt++;
//                            }

                            if(strike==strikesAndBalls[0] && ball==strikesAndBalls[1])
                                cnt++;
                        }

                        if(cnt==N)  answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static int[] countStrikeAndBall(int[] target, int[] guess){
        int strike=0, ball=0;
        for(int i=0; i<3; i++){
            if(target[i]==guess[i]) strike++;
            else if(target[i]==guess[(i+1)%3] || target[i]==guess[(i+2)%3]) ball++;
        }
        return new int[]{strike, ball};
    }

    public static int strikeCount(int a, int b, int c, int num){
        int cnt = 0;
        if(a==num/100)
            cnt++;
        if(b==num%100/10)
            cnt++;
        if(c==num%100%10)
            cnt++;
        return cnt;
    }

    public static int ballCount(int a, int b, int c, int num){
        int cnt = 0;
        int x = num/100;
        int y = num%100/10;
        int z = num%100%10;

        if(x!=a && x==b || x==c)
            cnt++;
        if(y!=b && y==a || y==c)
            cnt++;
        if(z!=c && z==a || z==b)
            cnt++;

        return cnt;
    }
}
