package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gold5_10026 {
    // 구역의 길이
    static int N;
    // 색약이 아닌 경우의 구역 배열
    static char [][] color;
    // 적록색약인 경우 구역 배열
    static char [][] rgColor;
    // 색약 아닌 경우 방문 배열
    static boolean [][] colorVisited;
    // 색약인 경우 방문 배열
    static boolean [][] rgColorVisited;
    // 이동 벡터
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : dfs로 적록색약과 아닌 사람이 보는 구역의 개수 출력하기
        // 로직 설계
        // 1. N값 입력받고 두 개의 이차원 배열 생성, 방문배열 생성
        // 2. 배열에 값 저장, 적록색약 배열의 경우 G를 R로 변환
        // 3. 배열의 모든 값 돌면서 dfs 실행 -> 각각의 개수 출력

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값 입력받기
            N = Integer.parseInt(br.readLine());

            // 적록색약과 아닌 경우 이차원 배열 생성
            color = new char[N][N];
            rgColor = new char[N][N];

            // 각각의 방문배열 생성
            colorVisited = new boolean[N][N];
            rgColorVisited = new boolean[N][N];

            // char값 저장
            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    char col = str.toCharArray()[j];
                    color[i][j] = col;
                    rgColor[i][j] = col;
                    // 적록색약에서 G는 R로 대체
                    if(col=='G')    rgColor[i][j] = 'R';
                }
            }

//            for(int i=0; i<N; i++){
//                for(int j=0; j<N; j++){
//                    System.out.print(color[i][j]+" ");
//                }
//                System.out.println();
//            }
//
//            System.out.println("RG");
//            for(int i=0; i<N; i++){
//                for(int j=0; j<N; j++){
//                    System.out.print(rgColor[i][j]+" ");
//                }
//                System.out.println();
//            }
            // 영역 개수를 저장할 변수
            int colorCnt = 0;
            int rgColorCnt = 0;

            // 각 배열을 돌면서 dfs 실행
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    // 방문한 적 없으면 cnt증가 및 dfs 실행
                    if(!colorVisited[i][j]){
                        colorCnt++;
                        colorDfs(i, j);
                    }
                    // 마찬가지로 방문한 적 없으면 cnt증가 및 dfs 실행
                    if(!rgColorVisited[i][j]){
                        rgColorCnt++;
                        rgColorDfs(i, j);
                    }
                }
            }

            // 결과값 출력
            System.out.println(colorCnt+" "+rgColorCnt);
        }
    }

    // 색약이 아닌 경우 dfs 메서드
    public static void colorDfs(int x, int y){
        // 방문한 적 있으면 종료
        if(colorVisited[x][y])   return;
        // 아니면 방문으로 업데이트
        colorVisited[x][y] = true;

        // 현재 위치 색깔 저장
        char chColor = color[x][y];

        // 상하좌우 반복
        for(int i=0; i<4; i++){
            // 다음 x, y 위치
            int cx = x + dx[i];
            int cy = y + dy[i];

            // 다음 위치가 0보다 크거나 같고 N보다 작으면서 방문한 적 없고 현재 위치와 같은 색깔인 경우
            if(cx>=0 && cx<N && cy>=0 && cy<N && !colorVisited[cx][cy] && chColor==color[cx][cy]){
                // dfs 실행
                colorDfs(cx, cy);
            }
        }
    }

    // 적록색약인 경우 dfs 메서드
    public static void rgColorDfs(int x, int y){
        // 방문한 적 있으면 종료
        if(rgColorVisited[x][y])   return;
        // 아니라면 방문으로 업데이트
        rgColorVisited[x][y] = true;

        // 현재 위치 색깔 저장
        char chRgColor = rgColor[x][y];

        // 상하좌우 반복
        for(int i=0; i<4; i++){
            // 다음 x, y 위치
            int cx = x + dx[i];
            int cy = y + dy[i];

            // 다음 위치가 0보다 크거나 같고 N보다 작고 방문한 적 없으며 현재 위치 색깔과 같은 경우
            if(cx>=0 && cx<N && cy>=0 && cy<N && !rgColorVisited[cx][cy] && chRgColor==rgColor[cx][cy]){
                // dfs 실행
                rgColorDfs(cx, cy);
            }
        }

    }
}
