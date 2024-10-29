package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_5568 {
    static int N, M;
    static int[] selected;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 길이가 M인 수열 비내림차순 출력
        // 로직 설계
        // 1. M 길이의 정수 배열
        // 2. start=1, depth=0으로 재귀 함수 실행
        // 3. 재귀 종료 시 이전 단계로 백트래킹

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M 값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            // M 크기의 배열 생성
            selected = new int[M];
            // 메서드 실행, start=1, depth=0으로 시작
            generateSeq(1, 0);
        }
    }
    // 백트래킹 메서드
    public static void generateSeq(int start, int depth){
        // 길이가 M과 같으면 출력
        if(depth == M){
            for(int num : selected){
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        }
        // depth 증가하면서 수열 생성
        for(int i=start; i<=N; i++){
            selected[depth] = i;
            generateSeq(i, depth+1);
        }
    }
}
