package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_15651 {
    // 배열값을 저장하고 마지막에 출력할 StringBuilder
    static StringBuilder sb = new StringBuilder();
    // 결과값을 저장할 배열
    static int [] selected;
    // N, M값 저장 변수
    static int N, M;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 1-N 자연수 중 M개 골라 수열 출력하기
        // 로직 설계
        // 1. M 크기의 정수 배열 초기화
        // 2. depth를 매개변수로 재귀함수 실행
        // 3. depth 길이가 M과 같으면 배열값을 sb에 저장 후 종료
        // 4. depth 위치 배열에 i값 저장, depth+1를 매개변수로 재귀

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            //StringBuilder sb = new StringBuilder();
            // M 크기의 정수 배열 초기화
            selected = new int[M];

            //generateSeq(0, sb);
            // 재귀함수 실행
            generateSeq(0);
            // 결과값 출력
            System.out.print(sb);
        }
    }

    // 수열 생성 메서드
    public static void generateSeq(int depth){
        // depth 길이가 M과 같으면
        if(depth==M){
            //System.out.print(stringBuilder.toString());
            //System.out.println();
            // 배열값 sb에 저장
            for(int num : selected){
                sb.append(num+" ");
            }
            //System.out.println();
            sb.append("\n");
            // 종료
            return;
        }

        // 반복, 백트래킹
        for(int i=1; i<=N; i++){
            selected[depth]= i ;
            generateSeq(depth+1);
        }
    }
}
