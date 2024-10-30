package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_15649 {
    static int N, M;
    static int [] selected;
    static boolean [] visited;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 자연수 N, M을 입력받고 중복없이 M개 수열 출력
        // 로직 설계
        // 1. M 크기의 배열 및 사용 여부를 체크할 boolean 배열 초기화
        // 2. 0값을 매개변수로 재귀함수 실행

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 선택한 숫자를 저장할 배열
            selected = new int[M];
            // 사용 여부 체크 배열
            visited = new boolean[N+1];
            // 순열 생성 함수 호출 -> 초기는 0
            generateSeq(0);

        }
    }
    // 순열 생성 재귀 함수
    public static void generateSeq(int depth){
        // 깊이가 M이면 배열 출력
        if(depth==M){
            for(int number : selected){
                System.out.print(number+" ");
            }
            System.out.println();
            // 출력 후 재귀 종료
            return;
        }
        // 1-N까지 순회하면서 숫자 택
        for(int i=1; i<=N; i++){
            // 방문하지 않은 경우
            if(!visited[i]){
                // 현재 깊이에 숫자 저장
                selected[depth]=i;
                // 방문 처리
                visited[i] = true;
                // 다음 깊이 재귀 호출
                generateSeq(depth+1);
                //selected[depth]=0;
                // 백트래킹 -> 방문 초기화
                visited[i] = false;
            }
        }
    }
}
