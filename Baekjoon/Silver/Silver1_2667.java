package Silver.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Silver1_2667 {
    // 상하좌우 이동 벡터
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    // 정사각형 길이
    static int N;
    // 단지 이차원 배열
    static int [][] house;
    // 방문 이차원 배열
    static boolean [][] visited;
    // 단지 수 저장할 변수
    static int complexCnt=0;
    //static ArrayList<Integer>[] houseCnt;
    // 단지에 속하는 집의 수 오름차순 정렬할 배열
    static int [] houseCntSort;
    //static List<Integer> houseCnt;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 이차원 배열에서 dfs를 실행해 집이 있는 1이 연결된 것의 개수를 세고 각 단지에 속하는 집의 수 오름차순으로 출력하기
        // 로직 설계
        // 1. N 입력받고 이차원 배열에 0과 1 저장
        // 2. 이중for문 돌면서 방문하지 않았고 값이 1인 경우 cnt값 증가 및 dfs 실행
        // 3. 각 단지 집의 수 오름차순 정렬 및 출력

        // try-with-resoureces로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 정사각형 모형 길이 입력받기
            N = Integer.parseInt(br.readLine());

            // N값으로 아파트 단지와 방문배열 초기화
            house = new int[N][N];
            visited = new boolean[N][N];

//            for(int i=0; i<N; i++){
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                for(int j=0; j<N; j++){
//                    house[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }

            // 단지 배열에 번호 저장
            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    house[i][j] = Integer.parseInt(str.split("")[j]);
                }
            }

            // dfs 결과값을 저장할 sb 객체 생성
            StringBuilder sb = new StringBuilder();

            // 정사각형 단지 모두 탐색
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    // 값이 1이고 방문한 적 없으면 complexCnt 누적 및 dfs 실행
                    if(house[i][j]==1 && !visited[i][j]){
                        complexCnt++;
                        sb.append(dfs(i, j)+"\n");
                        //houseCnt.add(dfs(i, j));
                        //System.out.println(dfs(i, j));
                    }
                }
            }


            //houseCnt = new ArrayList[complexCnt];
            // 정렬할 배열 초기화
            houseCntSort = new int[complexCnt];

            // sb의 값 분해해서 배열에 저장
            for(int i=0; i<complexCnt; i++){
                houseCntSort[i] = Integer.parseInt(sb.toString().split("\n")[i]);
            }
            // 오름차순 정렬
            Arrays.sort(houseCntSort);

//
//            houseCntSort = new int[complexCnt];
//            int maxValue = Integer.MIN_VALUE;
//
//            int i=0;
//            for(int x : houseCnt){
//                houseCntSort[i] = Math.max(maxValue, )
//            }
            // 총 단지 수 출력
            System.out.println(complexCnt);
            //System.out.println(sb);
            //System.out.println(sb.length());
            //houseCnt = new int[complexCnt];
//            for(int x : houseCnt){
//                System.out.println(x);
//            }

//            System.out.println(houseCnt);

            // 단지 내 집의 수 오름차순 출력
            for(int x : houseCntSort){
                System.out.println(x);
            }
        }
    }

    // dfs 메서드
    // 매개변수로 현재 위치 x, y값 받기
    public static int dfs(int x, int y){
        // 방문한 적 있으면 종료
        if(visited[x][y])   return 0;
        // 방문으로 업데이트
        visited[x][y] = true;
        // 현재 위치 포함
        int cnt = 1;

        // 상하좌우 반복
        for(int i=0; i<4; i++){
            // 새로운 x, y 위치
            int cx = x + dx[i];
            int cy = y + dy[i];

            // 지도를 벗어나지 않고 방문한 적 없고 값이 1이면
            if(cx >= 0 && cx<N && cy>=0 && cy<N && !visited[cx][cy] && house[cx][cy]==1){
                // cnt 값에 누적
                cnt += dfs(cx, cy);
            }
        }

        // 값 리턴
        return cnt;
    }
}
