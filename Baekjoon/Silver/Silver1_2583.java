package Silver.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver1_2583 {
    // 방문 여부를 체크할 방문배열
    static boolean [][] visited;
    // 영역을 저장할 이차원 배열
    static int [][] rectangle;
    // N, M, K값 저장할 변수
    static int N, M, K;
    // dfs 횟수를 저장할 변수
    static int cnt;
    // 이동 벡터
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 직사각형을 칠하고 내부를 제외한 나머지 부분의 넓이를 dfs로 구해 오름차순으로 출력하기
        // 로직 설계
        // 1. M, N, K값 입력받고 종이와 방문배열 초기화 -> 종이는 모두 1로 초기화
        // 2. 직사각형 영역을 종이에 0으로 업데이트 -> K번 반복
        // 3. 종이의 모든 인덱스를 방문한 적 없고 값이 1이면 cnt 증가, dfs 실행
        // 4. cnt 크기만큼 영역의 넓이를 구하고 오름차순 정렬 및 출력

        // try-with-resources로 BufferedReader
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // M, N, K값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 종이 및 방문배열 초기화
            rectangle = new int[M][N];
            visited = new boolean[M][N];

            // rectangle 모두 1로 초기화
            // 그래야 직사각형을 0으로 업데이트하고 영역의 넓이를 계산할 수 있으므로
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    rectangle[i][j] = 1;
                }
            }

            // 직사각형 영역을 0으로 업데이트 하는 과정을 K번 반복
            for(int i=0; i<K; i++){
                // 좌표 입력받기
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
//                int X = y2-y1;
//                int Y = x2-x1;
//                int a=3, b;
//                for(int x=0; x<X; x++){
//                    b = 4;
//                    for(int y=0; y<Y; y++){
//                        rectangle[a][b] = 0;
//                        b++;
//                    }
//                    a++;
//                }
                // 좌표를 배열 인덱스로 변경
                // 직사각형 영역을 0으로 업데이트
                for(int x=x1; x<x2; x++){
                    for(int y=y1; y<y2; y++){
                        rectangle[M-y-1][x] = 0;
                    }
                }
            }

//            for(int i=0; i<M; i++){
//                for(int j=0; j<N; j++){
//                    System.out.print(rectangle[i][j]+" ");
//                }
//                System.out.println();
//            }
//
            // 결과값을 저장할 StringBuilder 객체 생성
            StringBuilder sb =new StringBuilder();

            // 종이 배열을 돌면서 dfs 실행
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    // 방문하지 않았고 값이 1이면
                    if(!visited[i][j] && rectangle[i][j]==1){
                        // 누적
                        cnt++;
                        //System.out.println(dfs(i, j));
                        // dfs 실행한 값을 sb에 추가
                        sb.append(dfs(i,j)+"\n");
                    }
                }
            }

            // 영역 넓이를 저장할 배열 생성
            int [] resultArea = new int[cnt];
            // sb에서 값을 추출해 배열에 값 저장
            for(int i=0; i<cnt; i++){
                resultArea[i] = Integer.parseInt(sb.toString().split("\n")[i]);
            }

            // 오름차순 정렬
            Arrays.sort(resultArea);
            // 영역의 개수 출력
            System.out.println(cnt);
            // 오름차순 정렬된 영역의 넓이 출력
            for(int x : resultArea){
                System.out.print(x +" ");
            }
        }
    }

    // dfs 메서드
    // 현재 인덱스 위치 매개변수로 전달
    public static int dfs(int x, int y){
        // 방문한 적이 있다면 종료
        if(visited[x][y])   return 0;
        // 방문으로 업데이트
        visited[x][y] = true;

        // 현재 위치 포함해야 하므로 1로 초기화
        int area = 1;

        // 상하좌우 고려
        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            // 종이를 벗어나지 않고 방문한 적 없으며 값이 1이면
            if(cx >=0 && cx<M && cy >=0 && cy<N && !visited[cx][cy] && rectangle[cx][cy]==1){
                // area에 dfs 값 누적
                area += dfs(cx, cy);
                //System.out.println(area);
            }
        }
        // area값 리턴
        return area;
    }
}
