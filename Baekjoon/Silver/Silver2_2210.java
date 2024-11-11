package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver2_2210 {
    // 숫자 저장 숫자판 배열
    static int [][] numberBoard = new int[5][5];
    // 중복 방지
    static Set<String> set = new HashSet<>();
    // 숫자 조합 저장할 StringBuilder 객체
    static StringBuilder sb = new StringBuilder();
    // 6자리 수를 저장할 배열
    static int [] selected = new int[6];
    // x, y 인덱스
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0 ,-1, 1};

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 숫자판 임의의 위치에서 상하좌우 네 방향 5번 이동해 만들 수 있는 6자리 숫자의 개수 출력하기
        // 로직 설계
        // 1. 숫자값 입력받아 숫자판 배열에 저장
        // 2. 5x5 숫자판 배열값에 대해 dfs 실행
        // 3. 사방향 값이 조건에 맞으면 depth값 증가시키고 dfs 재귀
        // 4. depth 값이 6이면 selected 배열에 저장된 값 set에 저장 후 종료
        // 5. 중복을 제거한 값들의 개수 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 숫자판 배열에 값 저장
            for(int i=0; i<5; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<5; j++){
                    numberBoard[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 완전 탐색으로 dfs 실행
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    dfs(i, j, 0);
                }
            }

            // 숫자의 개수 출력
            System.out.println(set.size());
        }
    }

    // dfs 메서드
    public static void dfs(int x, int y, int depth){
        // depth 값이 6이면 set에 저장 후 종료
        if(depth==6){
            // selected에 저장된 숫자 sb 객체에 저장
            for(int num : selected){
                sb.append(num);
            }
            // set에 string으로 변환해 저장
            set.add(sb.toString());
            // 초기화
            sb.setLength(0);
            // 종료
            return;
        }

        // depth 인덱스에 현재 숫자판 배열값 저장
        selected[depth] = numberBoard[x][y];
        // 상하좌우 값
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 조건에 맞으면 다음 x, y값과 depth+1을 매개변수로 재귀 실행
            if(nx>=0 && ny>=0 && nx<5 && ny< 5){
                //if(!visited[nx][ny]){
                    //visited[nx][ny] = true;
                    dfs(nx, ny, depth+1);
                //}
            }
        }
    }
}
