package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_5212 {
    // 상 하 좌 우 이동 인덱스
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    // 이차원 배열
    static char [][] map;
    static char [][] newMap;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 이차원 배열의 각 값을 확인하고 상하좌우 바다가 3 이상인 경우 섬이 가라앉는 것을 적용한 50년 후 지도 출력하기
        // 로직 설계
        // 1. R, C를 입력받아 배열을 생성하고 50년 후의 상황을 저장할 이차원 배열을 생성해 두 배열에 값을 저장한다.
        // 2. 이차원 배열을 돌면서 섬의 상하좌우가 3개 이상 바다이거나 지도를 벗어나는 경우 값을 바다로 저장한다.
        // 3. 사각형의 인덱스를 구해 모든 섬을 포함한 가장 작은 직사각형을 출력한다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // R, C 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            // 이차원 배열 생성
            map = new char[R][C];
            newMap = new char[R][C];

            // 값 저장
            for(int i=0; i<R; i++){
                String str = br.readLine();
                map[i] = str.toCharArray();
                newMap[i] = str.toCharArray();
            }

            // 모든 칸 반복하면서 메서드 전달
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j]=='X')
                        after50YearsNewMap(i, j);
                }
            }

            // 50년 후 X의 최대 최소 범위 찾기 변수
            int minX = R, maxX = 0, minY = C, maxY = 0;
            boolean isFound = false;

            // 이차원 배열 완전탐색
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    // 섬인 경우
                    if(newMap[i][j]=='X'){
                        // 최대최소 범위 찾기
                        minX = Math.min(minX, i);
                        maxX = Math.max(maxX, i);
                        minY = Math.min(minY, j);
                        maxY = Math.max(maxY, j);

                        isFound = true;
                    }
                }
            }

            // 가장 최소한의 직사각형 출력
            if(isFound){
                for(int i=minX; i<=maxX; i++){
                    for(int j=minY; j<=maxY; j++){
                        System.out.print(newMap[i][j]);
                    }
                    System.out.println();
                }
            }
        }
    }

    // 각 칸의 사면을 확인하는 메서드
    public static void after50YearsNewMap(int x, int y){
        int count = 0;
        // 상하좌우 확인
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
//            if(nx>=0 && ny>=0 && nx< map.length && ny<map[0].length){
            if(nx<0 || ny <0 || nx >= map.length || ny >= map[0].length || map[nx][ny]=='.'){
                count++;
            }
        }
        // 3 이상인 경우 가라앉음
        if(count >= 3){
            newMap[x][y] = '.';
        }

    }
}
