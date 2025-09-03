package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold4_14502 {
    // x, y축 이동 벡터
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static int N, M;
    static int [][] map;
    // 방문 여부 확인 이차원 배열
    static boolean [][] visited;

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 이차원 배열 초기화
            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    st = new StringTokenizer(br.readLine());
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


        }
    }
}
