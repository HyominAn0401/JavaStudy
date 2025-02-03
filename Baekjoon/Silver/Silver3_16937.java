package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver3_16937 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 모눈종이 크기와 스티커를 입력받고 두 개 스티커를 붙인 최대 넓이값 출력하기
        // 로직 설계
        // 1. H, W, N을 입력받고 N만큼 스티커 크기를 Sticker 객체를 생성해 stickers ArrayList에 저장
        // 2. 이중 반복문으로 모든 스티커 쌍 반복하기
        // 3. 스티커의 모든 회전하는 경우 고려해 붙이기 가능 여부를 판단하기
        // 4. 붙이는 게 가능할 경우 최대 넓이 출력하기

        try(BufferedReader br= new BufferedReader(new InputStreamReader(System.in))){
            // H, W, N값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(br.readLine());

            // Sticker 객체를 저장하는 ArrayList 초기화
            ArrayList<Sticker> stickers = new ArrayList<>();

            // R, C 입력받고 Sticker 객체로 저장
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                stickers.add(new Sticker(R, C));
            }

            // 최대 넓이를 저장할 변수 초기화
            int maxArea = 0;

            // 모든 스티커 쌍을 반복
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    Sticker sticker1 = stickers.get(i);
                    Sticker sticker2 = stickers.get(j);

                    // 회전하지 않은 경우
                    maxArea = Math.max(maxArea, getMaxArea(H, W, sticker1.getR(), sticker1.getC(), sticker2.getR(), sticker2.getC()));
                    // 두 번재 스티커만 회전한 경우
                    maxArea = Math.max(maxArea, getMaxArea(H, W, sticker1.getR(), sticker1.getC(), sticker2.getC(), sticker2.getR()));
                    // 첫 번째 스티커만 회전한 경우
                    maxArea = Math.max(maxArea, getMaxArea(H, W, sticker1.getC(), sticker1.getR(), sticker2.getR(), sticker2.getC()));
                    // 모든 스티커가 회전한 경우
                    maxArea = Math.max(maxArea, getMaxArea(H, W, sticker1.getC(), sticker1.getR(), sticker2.getC(), sticker2.getR()));

//                    int[][] rotations1 = {{sticker1.getR(), sticker1.getC()}, {sticker1.getC(), sticker1.getR()}};
//                    int[][] rotations2 = {{sticker2.getR(), sticker2.getC()}, {sticker2.getC(), sticker2.getR()}};
//
//                    for (int[] r1 : rotations1) {
//                        for (int[] r2 : rotations2) {
//                            if(Math.max(r1[0], r2[0]) <=H && r1[1] + r2[1] <= W){
//                                maxArea = Math.max(maxArea, r1[0] * r1[1] + r2[0] * r2[1]);
//                            }
//                            if((r1[0] + r2[0] <=H) && Math.max(r1[1], r2[1]) <= W){
//                                maxArea = Math.max(maxArea, r1[0] * r1[1] + r2[0] * r2[1]);
//                            }
//                        }
//                    }
                }
            }
            // 결과값 출력
            System.out.println(maxArea);
        }
    }

    // 스티커를 붙일 수 있는지 검사하는 메서드
    public static int getMaxArea(int H, int W, int h1, int w1, int h2, int w2){
        int area = 0;
        // 가로로 나란히 붙이는 경우
        if (Math.max(h1, h2) <= H && w1 + w2 <= W) {
            area = h1 * w1 + h2 * w2;
        }
        // 세로로 나란히 붙이는 경우
        if (h1 + h2 <= H && Math.max(w1, w2) <= W) {
            area = Math.max(area, h1 * w1 + h2 * w2);
        }
        return area;
    }
}

// 스티커의 가로 세로를 저장하는 클래스
class Sticker{
    int R;
    int C;

    public Sticker(int R, int C){
        this.R = R;
        this.C = C;
    }

    public int getR() {
        return R;
    }

    public int getC() {
        return C;
    }
}
