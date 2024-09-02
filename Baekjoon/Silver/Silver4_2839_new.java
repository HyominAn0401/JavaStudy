package Silver;

import java.util.Scanner;

public class Silver4_2839_new {
    public static void main(String[] args) throws Exception{

        try(Scanner scanner = new Scanner(System.in)){
            int N = scanner.nextInt();

            int [] sugar = new int[N+1];

            // i가 3보다 작을 때는 3이나 5kg으로 봉지를 만들 수 없으므로 큰 값으로 초기화
            for(int i=0; i<=N; i++){
                sugar[i] = 5001;
            }

            if(N>=3)    sugar[3] = 1;
            if(N>=5)    sugar[5] = 1;

            for(int i=6; i<=N; i++){

                if(sugar[i-3] != 5001)
                    sugar[i] = Math.min(sugar[i], sugar[i-3]+1);
                if(sugar[i-5] != 5001)
                    sugar[i] = Math.min(sugar[i], sugar[i-5]+1);
            }

            // 결과값 출력
            // 결과값이 5001이면 -1, 아니면 봉지 개수 출력
            System.out.println(sugar[N]==5001?-1:sugar[N]);

        }
    }
}
