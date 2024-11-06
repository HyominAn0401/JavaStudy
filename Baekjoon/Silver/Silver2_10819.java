package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_10819 {
    static int [] selected;
    static int [] numbers;
    static boolean [] used;
    static int maxValue = Integer.MIN_VALUE;
    static int N;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : |A[0]-A[1]| + .. + |A[N-2]-A[N-1]| 식의 최댓값 구하기
        // N 자리수에 해당하는 모든 경우의 수를 구하고 해당 식의 최대값 구하기
        // 로직 설계
        // 1. N값을 받고 배열 초기화, numbers 배열에 값 저장
        // 2. 매개변수 0 전달 재귀함수 실행
        // 3. N자리 모든 경우의 수를 구하고 최댓값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값 입력받고 배열 초기화
            N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            used = new boolean[N];
            selected = new int[N];

            // numbers 배열에 값 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // depth값 0 전달
            generateSeq(0);
            // 최댓값 출력
            System.out.println(maxValue);
        }
    }

    // 모든 경우의 수를 구하는 메서드
    public static void generateSeq(int depth){
        // depth값이 N과 같으면
        // 배열을 매개변수로 전달
        if(depth==N){
            getMaxValue(selected);
        }

        // 모든 경우의 수 구하기
        for(int i=0; i<N; i++){
            // 중복 제외
            if(!used[i]){
                // 사용함 업데이트
                used[i] = true;
                // 해당 depth 위치에 값 저장
                selected[depth] = numbers[i];
                // 재귀 실행
                generateSeq(depth+1);
                // 백트래킹
                used[i] = false;
            }
        }
    }

    // 최대값 구하는 메서드
    public static void getMaxValue(int [] array){
        // 값을 비교할 변수
        int sum = 0;
        // 모든 경우의 수에 대해 계산
        for(int i=0; i<N-1; i++){
            sum += Math.abs(array[i] - array[i+1]);
        }
        // 최댓값 비교
        maxValue = Math.max(sum, maxValue);
    }
}
