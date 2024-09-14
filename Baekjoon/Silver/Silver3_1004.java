package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_1004 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 각 테스트 케이스 별 출발점, 도착점을 받고 도착점까지 원을 통과할 최소한의 횟수를 출력한다.
        // 로직 설계
        // 1. 각 테스트 케이스를 입력받(고 해당 크기의 결과 배열을 생성하거나 stringbuilder 객체를 생성한다)는다.
        // 2. 출발점, 도착점, n값을 입력받고 n번만큼 행성의 중심점과 반지름을 입력받는다.
        // 3. 출발점과 도착점이 행성 안에 있는지 확인하고 있다면 값을 증가한다.
        // 4. 행성을 통과한 횟수를 더해 출력한다.

        // try-with-resources
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // testCase 입력받기
            int testCase = Integer.parseInt(br.readLine());
            // 결과를 저장할 StringBuilder 객체나 testCase 크기의 배열 생성
            //StringBuilder sb = new StringBuilder();
            int [] test = new int[testCase];

            // 테스트 케이스만큼 반복
            for (int t = 0; t < testCase; t++) {
                // 출발점, 도착점 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                // n값 입력받기
                int n = Integer.parseInt(br.readLine());

                // 출발점과 도착점이 통과하는 횟수 누적할 변수
                int departCnt = 0;
                int arriveCnt = 0;

                // n번 반복
                for (int i = 0; i < n; i++) {
                    // 원의 중점과 반지름 입력받기
                    st = new StringTokenizer(br.readLine());
                    int cx = Integer.parseInt(st.nextToken());
                    int cy = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
//                    if (isInCircle(x1, y1, cx, cy, r))
//                        departCnt++;
//                    if (isInCircle(x2, y2, cx, cy, r))
//                        arriveCnt++;
                    // 두 점 모두 한 원 안에 있을 때
                    if(isInCircle(x1, y1, cx, cy, r) && isInCircle(x2, y2, cx, cy, r)){
                        departCnt+=0;
                    }
                    // 두 점 모두 한 원 안에 없는 경우
                    else if(!isInCircle(x1, y1, cx, cy, r) && !isInCircle(x2, y2, cx, cy, r))
                        departCnt+=0;
                    // 그 외
                    else{
                        // 출발점만 원 안에 있는 경우
                        if(isInCircle(x1, y1, cx, cy, r))
                            departCnt++;
                        // 도착점만 원 안에 있는 경우
                        else if(isInCircle(x2, y2, cx, cy, r))
                            arriveCnt++;
                    }
                }
                // 결과값 저장
                test[t] = (departCnt+arriveCnt);
                //sb.append((departCnt+arriveCnt)+"\n");
            }
            // 출력
            //System.out.println(sb);
            for(int num: test){
                System.out.println(num);
            }
        }
    }

    // 점이 원 안에 있는지 검사하는 메서드
    public static boolean isInCircle(int x, int y, int cx, int cy, int r){
        // 중점과 점 사이의 거리
        double length = Math.sqrt(Math.pow((double)cx-x, 2) + Math.pow((double)cy-y, 2));
        // 거리가 반지름 크기보다 작거나 같으면 true 반환
        if(length <= r)
            return true;
        // 아니면 false 반환
        else return false;
//        int up = cy + r;
//        int down = cy - r;
//        int left = cx -r;
//        int right = cx +r;
//
//        if((x > left && y > down) && (x<right && y<up)){
//            return true;
//        }
//        else return false;
    }
}
