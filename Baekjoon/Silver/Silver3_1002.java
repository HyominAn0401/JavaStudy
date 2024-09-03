package Silver.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_1002 {
    public static int x1, y1, r1, x2, y2, r2;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for(int t=0; t<T; t++) {

                StringTokenizer st = new StringTokenizer(br.readLine());
                x1 = Integer.parseInt(st.nextToken());
                y1 = Integer.parseInt(st.nextToken());
                r1 = Integer.parseInt(st.nextToken());
                x2 = Integer.parseInt(st.nextToken());
                y2 = Integer.parseInt(st.nextToken());
                r2 = Integer.parseInt(st.nextToken());

                // 중점 사이의 거리
                //double distance1 = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
                double distance1 = Math.pow((x2-x1),2) + Math.pow((y2-y1), 2);

                // -1인 경우
                //if(x1==x2 && y1==y2 && r1==r2){
                if(distance1==0 && r1==r2){
                    sb.append(-1+"\n");
                }
                //else if(distance1 < (r1+r2) && distance1>0){
                else if(distance1 < Math.pow((r1+r2),2) && distance1 > Math.pow((r1-r2),2)){
                    sb.append(2+"\n");
                }
                //else if(distance1==(r1+r2) || distance1==Math.abs(r2-r1)){
                else if(distance1 == Math.pow((r1+r2),2) || distance1 == Math.pow((r1-r2),2)){
                    sb.append(1+"\n");
                }
                else{
                    sb.append(0+"\n");
                }

//                if((x1==x2)&&(y1==y2)&&(r1==r2))
//                    sb.append(-1+"\n");
//                // 원이 만나지 않을 때
//                else if (((Math.pow((x2-x1),2) + Math.pow((y2-y1), 2)) > Math.pow((r1+r2), 2)) || ((Math.pow((x2-x1),2) + Math.pow((y2-y1), 2)) >= Math.pow((r1-r2), 2)) || ((x1==x2)&&(y1==y2))&&(r1!=r2)){
//
//                    sb.append(0 + "\n");
//                }
//
//                // 교점이 2개일 때
//                else if((Math.pow((x2-x1),2) + Math.pow((y2-y1), 2)) < Math.pow((r1+r2), 2)) {
//
//                    sb.append(2 + "\n");
//                }
//
//                // 두 원이 접할 때
//                else if(((Math.pow((x2-x1),2) + Math.pow((y2-y1), 2)) == Math.pow((r1+r2), 2)) ||  ((Math.pow((x2-x1),2) + Math.pow((y2-y1), 2)) == Math.pow((r1-r2), 2))){
//
//                    sb.append(1 + "\n");
//                }
//                else sb.append(-1+"\n");

            }

            System.out.print(sb);
        }
    }
}
