package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold5_9204_new {
    public static void main(String []args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int test = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int t=0; t<test; t++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r1 = st.nextToken().charAt(0) - 'A';
                int c1 = 8 - Integer.parseInt(st.nextToken());
                int r2 = st.nextToken().charAt(0) - 'A';
                int c2 = 8 - Integer.parseInt(st.nextToken());

                // 1. 시작과 도착값이 같음
                if(r1==r2 && c1==c2){
                    sb.append(0+" "+toStr(c1, r1)+"\n");
                    continue;
                }

                // 2. 같은 대각선 위에 있음
                if(Math.abs(r1-r2) == Math.abs(c1-c2)){
                    sb.append(1 +" "+toStr(c1, r1)+" "+toStr(c2, r2)+"\n");
                    continue;
                }

                // 3. 색이 다름
                if((r1+c1)%2 != (r2+c2)%2){
                    sb.append("Impossible"+"\n");
                    continue;
                }

                // 4. 같은 색이면서 대각선이 다름
                if(((r1+c1)%2 == (r2+c2)%2)){
                    int s1 = r1+c1;
                    int d1 = r1-c1;
                    int s2 = r2+c2;
                    int d2 = r2-c2;

                    // 첫번째 경우
                    int cM1 = (s1-d2)/2;
                    int rM1 = (s1+d2)/2;
                    int cM2 = (s2-d1)/2;
                    int rM2 = (s2+d1)/2;

                    if(cM1>=0 && cM1<8 && rM1>=0 && rM1<8){
                        sb.append(2+" "+toStr(c1, r1)+" "+toStr(cM1, rM1)+" "+toStr(c2, r2)+"\n");
                    }

                    else if(cM2>=0 && cM2<8 && rM2>=0 && rM2<8){
                        sb.append(2+" "+toStr(c1, r1)+" "+toStr(cM2, rM2)+" "+toStr(c2, r2)+"\n");
                    }
                }
            }
            System.out.print(sb.toString());
        }
    }

    // 문자열 반환
    public static String toStr(int r, int c){
        return ((char)(c+'A')+" "+(8-r));
    }
}
