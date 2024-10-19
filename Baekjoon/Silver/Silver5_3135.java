package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_3135 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : A->B로 이동할 때 가장 적은 수
        // 로직 설계
        // 1. A, B, N을 입력받고 N개의 숫자를 배열에 저장
        // 2. |A-B| 값과 |배열값-B|+1 크기를 비교
        // 3. 가장 적은 값을 cnt에 저장 후 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // A, B 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // N 입력받아 배열 생성 후 값 저장
            int N = Integer.parseInt(br.readLine());
            int [] buttons = new int[N];
            for(int i=0; i<N; i++){
                buttons[i] = Integer.parseInt(br.readLine());
            }

            // cnt 변수 초기화
            int cnt = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                // |A-B|보다 |배열값-B|+1값이 더 작으면 해당 배열값으로 이동(+1) 후 1씩 증가
                if(Math.abs(A-B) >= Math.abs(buttons[i]-B)+1){
                    cnt = Math.min(Math.abs(buttons[i]-B)+1, cnt);
                }
                // |A-B|가 더 작으면 그만큼 이동
                else{
                    cnt = Math.min(Math.abs(A-B), cnt);
                }
            }

            System.out.print(cnt);
        }
    }
}
