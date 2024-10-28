package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_15650 {
    static int [] selected;
    static int N, M;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : N, M을 입력 받아 1-N 자연수 중 M개 수열을 오름차순 정렬
        // 로직 설계
        // 1. N, M 입력받고 M 크기의 정수 배열 초기화
        // 2. 백트래킹 메소드 생성
        // 2-1. depth==M이면 selected 배열값을 출력하고 종료
        // 2-2. 1부터 N까지의 숫자를 선택해 오름차순 수열을 저장하고 백트래킹하며 반복

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            // M 크기 배열 초기화
            selected = new int[M];
            // 1, 0 값으로 메서드 시작
            generateSequence(1, 0);

        }
    }
    // 수열 생성 메서드
    static void generateSequence(int start, int depth){
        // depth가 M값과 같으면
        // 수열 길이가 M이 되면
        if(depth==M){
            // 배열값 출력
            for(int num : selected){
                System.out.print(num+" ");
            }
            System.out.println();
            // 종료
            return;
        }
        // start부터 N값까지 반복
        for(int i=start; i<=N; i++){
            // depth 위치에 i값 저장
            selected[depth] = i;
            // 재귀
            generateSequence(i + 1, depth+1);
        }
    }
}
