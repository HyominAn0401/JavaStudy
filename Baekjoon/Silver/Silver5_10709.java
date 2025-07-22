package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_10709 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br= new BufferedReader(new InputStreamReader(System.in))){
            // x : H, y ; W
            // 1분이 지날 때마다 1km씩 동쪽으로 이동 : y값 증가
            // 각 구역에 대해 지금부터 몇 분 뒤 처음으로 하늘에 구름이 오는지 구하기
            // 구름 : c, 없음 : .
            int H = Integer.parseInt(br.readLine());
            int W = Integer.parseInt(br.readLine());

            String [][] cloud = new String[H][W];
            int [][] cnt = new int[H][W];

            for(int i=0; i<H; i++){
                String str = br.readLine();
                for(int j=0; j<W; j++){
                    cloud[i][j] = str.split("")[j];
                }
            }


        }
    }
}
