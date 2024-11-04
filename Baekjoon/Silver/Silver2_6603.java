package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_6603{
    // 선택된 수를 저장할 배열
    static int[] selected;
    // 중복 방지 배열
    static boolean[] used;
    // 숫자를 저장할 배열
    static int[] numbers;
    // 결과를 저장할 StringBuilder 객체
    static StringBuilder sb = new StringBuilder();
    // k개 숫자
    static int k;

    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 0이 나올 때까지 숫자 입력받고 각 테스트 케이스 별 6개의 숫자를 고르는 모든 경우의 수 출력하기
        // 로직 설계
        // 1. 입력받은 값이 0일 때까지 반복
        // 2. k를 입력받고 k개 숫자를 배열에 저장, 다른 배열들도 k 크기로 초기화
        // 3. 각 테스트 케이스 별 6개 숫자 택한 모든 경우의 수 sb 객체에 저장
        // 4. sb 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 0일 때까지 입력받기
            String str = "";
            // 0이 아닐 때 반복
            while(!str.equals("0")){
                // str 입력받기
                str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);
                // k 크기로 배열 초기화
                k = Integer.parseInt(st.nextToken());
                numbers = new int[k];
                used = new boolean[k];
                // 숫자에서 6개를 고른다 했으니 6으로 크기 초기화
                selected = new int[6];

                // 배열에 숫자 저장
                for(int i=0; i<k; i++){
                    numbers[i] = Integer.parseInt(st.nextToken());
                }

                // 0, 0 매개변수로 전달
                generateLottery(0, 0);
                // 각 테스트 케이스 종료 후 줄바꿈 추가
                sb.append("\n");
            }
            // 결과값 출력
            System.out.print(sb);
        }
    }

    // 수를 고르는 모든 경우의 수 구하는 메서드
    public static void generateLottery(int start, int depth){
        // 깊이가 6이면
        if(depth==6){
            // 선택된 숫자 모두 sb에 추가
            for(int num : selected){
                sb.append(num+" ");
            }
            sb.append("\n");
            // 종료
            return;
        }

        // start부터 k-1까지 반복
        for(int i=start; i<k; i++){
            // 사용하지 않았으면
            if(!used[i]){
                // 사용으로 업데이트
                used[i] = true;
                // 해당 깊이에 숫자값 저장
                selected[depth] = numbers[i];
                // 재귀
                generateLottery(i+1, depth+1);
                // 백트래킹
                used[i] = false;
            }
        }
    }
}