package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_15663 {
    static int N, M;
    static int [] selected;
    static int [] numbers;
    // 중복 방지 배열
    static boolean [] used;
    static StringBuilder sb = new StringBuilder();
    // 중복 문자열을 제거하고 저장 순서를 저장할 Set
    static Set<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : N개 자연수를 입력받아 M개 수열을 출력할 때, 중복되는 수열 제외 및 사전 순으로 증가하도록 한다.
        // 로직 설계
        // 1. N, M을 입력받고 모든 배열 초기화, N 크기 배열에 값 저장
        // 2. 수열 생성 재귀함수 실행
        // 2-1. 배열 인덱스 0부터 N까지 반복하면서 수열 생성
        // 2-2. depth가 M과 같으면 sb에 추가한 문자열을 Set에 저장해 중복값을 제외한다.
        // 3. Set에 저장된 값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M값 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            // 숫자를 저장할 정수 배열 초기화
            numbers = new int[N];
            // M 크기의 정수 배열 초기화
            selected = new int[M];
            // 중복 숫자를 검사하기 위한 boolean 배열
            used = new boolean[N];

            // 숫자값 배열에 저장
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // 배열 오름차순 정렬
            Arrays.sort(numbers);
            // 메서드 실행, 매개변수값 0 전달
            generateSeq(0);

            // 결과값 출력
            for(String str : set){
                System.out.println(str);
            }

            // StringBuilder 초기화 연습
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("1234");
//            System.out.println("stringBuilder: "+stringBuilder);
//            stringBuilder.delete(0, stringBuilder.length());
//            System.out.println("stringBuilder: "+ stringBuilder);

        }
    }

    // 수열 생성 메서드
    public static void generateSeq(int depth){
        // depth값이 M과 같으면
        if(depth==M){
            // selected 배열값들 sb 객체에 저장
            for(int num : selected){
                sb.append(num+" ");
            }
            // sb 객체를 set에 추가
            set.add(sb.toString());
            // sb 초기화
            sb.delete(0, sb.length());
            // 종료
            return;
        }

        // 0부터 N-1까지 반복
        for(int i=0; i<N; i++){
            // 해당 인덱스 값 숫자를 사용하지 않은 경우
            if(!used[i]){
                // 사용으로 업데이트
                used[i] = true;
                // depth 위치에 숫자 저장
                selected[depth] = numbers[i];
                // depth+1을 전달, 재귀함수 실행
                generateSeq(depth+1);
                // 백트래킹
                used[i] = false;
            }
        }
    }
}
