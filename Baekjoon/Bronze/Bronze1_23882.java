package Bronze;

import java.util.Scanner;

public class Bronze1_23882 {

    // 배열의 원소를 교환하는 swap 메소드
    static void swap(int array[], int x, int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    // 배열의 전체 원소를 출력하는 printArray 메소드
    static void printArray(int []array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {
        // 구현 및 해야할 것 : 선택 정렬 알고리즘을 구현하고 입력받은 교환 횟수의 배열을 출력한다. 아닐 경우 -1을 출력한다.
        // 로직 설계
        // 1. 배열 크기와 교환 시점을 입력받는다
        // 2. 배열에 값을 입력받아 저장한다
        // 3. 선택 정렬 알고리즘에서 교환이 발생할 때마다 교환 횟수를 증가한다
        // 4. 교환 횟수가 K가 되면 배열을 출력하고 종료하고, K보다 교환 횟수가 작으면 -1을 출력한다

        // try-with-resources로 Scanner 객체 관리
        try(Scanner scanner = new Scanner(System.in)){
            // 배열 크기 입력받기
            int N = scanner.nextInt();
            // K번째 교환값 입력받기
            int K = scanner.nextInt();
            int [] A = new int[N];
            int cnt = 0;

            // 배열에 값 입력받아 저장
            for(int i=0; i<N; i++){
                A[i] = scanner.nextInt();
            }

            // 선택 정렬 알고리즘으로 배열 정렬
            for(int i=N-1; i>0; i--){
                // 현재 최대값 인덱스 i로 초기화
                int max = i;
                // last에 현재 위치 저장
                int last = max;
                // 최대값 인덱스 찾기
                for(int j=i-1; j>=0; j--){
                    if(A[j] > A[max])
                        max = j;
                } //max 찾기
                //System.out.println("MAX: "+max);

                // 최대값이 현재 위치 값과 다를 때
                if(max != last) {
                    // 교환
                    swap(A, max, i);
                    cnt++;
                    // K면 배열을 출력
                    if (cnt == K) {
                        printArray(A);
                        return;
                    }
                }
            }
            System.out.println(-1);
        }
    }
}
