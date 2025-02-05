package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver2_2210_20250205 {
    // 중복값을 제거하기 위한 HashSet 생성
    static Set<String> set = new HashSet<>();
    // x, y 인덱스
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    // 숫자판 정수 이차원 배열
    static int [][] numbers = new int[5][5];
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 이차원 배열 숫자판에서 인접한 상하좌우 방향으로 5번 이동해 만들 수 있는 6자리 수 개수 출력하기
        // 로직 설계
        // 0. 중복값을 제거하기 위한 HashSet 초기화,
        //    상하좌우 x, y 방향 인덱스 값을 저장한 배열 초기화
        // 1. 이차원 배열을 생성해 값 저장
        // 2. 이차원 배열의 각 값에 대해 dfs를 실행해 6자리 숫자 생성
        // 3. 생성된 6자리 숫자의 개수 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 숫자판에 값 저장
            for(int i=0; i<5; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<5; j++){
                    numbers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 숫자판 각 수에 대해 dfs 실행
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    // 각 반복당 StringBuilder 객체 초기화
                    StringBuilder sb = new StringBuilder();
                    // 해당 위치 값을 sb 객체에 추가하고 count를 1, 현재 i, j 를 매개변수로 전달
                    dfs(1,sb.append(numbers[i][j]), i, j);
                }
            }

            // 모든 숫자의 개수 출력
            System.out.println(set.size());

        }
    }

    // dfs 메서드
    public static void dfs(int count, StringBuilder sb, int x, int y){
        // 6자리 수가 생성되면
        if(count==6){
            // set에 해당 값을 추가
            // 중복값은 자동 추가되지 않음
            set.add(sb.toString());
            // 종료
            return;
        }

        // 상하좌우 4가지 방향에 대해 반복
        for(int i=0; i<4; i++){
            // 다음 위치 인덱스
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 숫자판 내에 위치하는 경우
            if(nx>=0 && ny>=0 && nx<5 && ny <5){
                // count값 증가, sb 객체에 해당 위치의 숫자 추가, 다음 위치 매개변수로 넘김
                dfs(count+1, sb.append(numbers[nx][ny]), nx, ny);
                // 재귀 호출 후 마지막으로 추가한 숫자 제거
                sb.setLength(sb.length()-1);
            }
        }
    }
}
