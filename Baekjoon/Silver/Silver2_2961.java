package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_2961 {
    static int N;
    // 신맛, 쓴맛 값 저장 배열
    static long [] S;
    static long [] B;
    // 사용여부 체크 배열
    static boolean [] used;
    // 선택한 숫자 저장 배열
    static int [] selected;
    static int selectCnt = 1;
    static long sour=1, bitter=0;
    static long minValue = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : N개 재료 중 몇 개를 골라 가장 작은 신맛 쓴맛 차 구하기
        // 로직 설계
        // 1. N값을 입력받고 S, B 배열에 각 값을 저장한다.
        // 2. N가지 재료 중 선택할 수 있는 모든 경우의 수에서 가장 작은 신맛 쓴맛의 차를 구한다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값 입력받기
            N = Integer.parseInt(br.readLine());
            // N+1 크기의 S, B 배열 초기화
            S = new long[N+1];
            B = new long[N+1];
            // 중복값 사용 막기 위한 배열
            used = new boolean[N+1];

            // 1부터 N 순회
            // N개 재료 중 선택할 수 있는 모든 경우의 수 : N개 재료 중 1, 2, 3 ... N개 선택
            for(int i=1; i<=N; i++){
                // S, B 값을 입력받아 각 배열에 저장
                StringTokenizer st = new StringTokenizer(br.readLine());
                S[i] = Long.parseLong(st.nextToken());
                B[i] = Long.parseLong(st.nextToken());
            }

            // 1부터 N까지 반복
            for(selectCnt=1; selectCnt<=N; selectCnt++){
                // selected 배열을 초기화하고 메서드 실행
                int cnt = selectCnt;
                selected = new int[selectCnt];
                generateMinvalue(1, 0, cnt);
            }

            // 최솟값 출력
            System.out.println(minValue);
        }
    }

    // 가장 작은 신맛쓴맛 차이값을 구하는 메서드
    public static void generateMinvalue(int start, int depth, int cnt){
        // 깊이가 같아지면
        if(depth==cnt){
            // selected 배열을 순회해 신맛과 쓴맛 값 구하기
            for(int num : selected){
                sour *= S[num];
                bitter += B[num];
            }
            // 최솟값 저장
            minValue = Math.min(Math.abs(sour-bitter), minValue);
            // 신맛쓴맛 초기화
            sour=1; bitter=0;
            // 종료
            return;
        }

        // start값부터 N까지 반복
        for(int i=start; i<=N; i++){
            // 이전에 사용하지 않았다면
            if(!used[i]){
                // true로 업데이트 -> 사용으로 업데이트
                used[i] = true;
                // 해당 깊이에 i값 저장
                selected[depth]=i;
                // start, depth 값 증가시켜 재귀 실행
                generateMinvalue(i+1, depth+1, cnt);
                // 백트래킹
                used[i] = false;
            }
        }
    }
}
