package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Silver4_1026 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : N개의 수 A, B를 각 입력받고 A를 재배열해 최솟값 만들기
        // 로직 설계
        // 1. N개 크기의 A 배열 생성 후 값 배열에 값 저장
        // 2. ArrayList를 생성해 인덱스와 B값 저장
        // 3. value 값 기반으로 내림차순 정렬
        // 4. A를 오름차순 정렬해 value 값과 계산 후 결과 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N값 입력받기
            int N = Integer.parseInt(br.readLine());

            // N 크기의 A 배열 생성
            int [] A = new int[N];

            // Num 클래스 ArrayList 생성
            ArrayList<Num> nums = new ArrayList<>();

            // A 배열에 값 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            // index 값 포함 ArrayList 값 저장
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                nums.add(new Num(i, Integer.parseInt(st.nextToken())));
            }

            // A 배열 오름차순 정렬
            Arrays.sort(A);

            // value 기반 ArrayList 정렬
            nums.sort((n1, n2)-> Integer.compare(n2.getValue(), n1.getValue()));

            // 결과값 초기화
            int sum = 0;
            // 정렬한 배열 원소 계산
            for(int i=0; i<N; i++){
                sum += (nums.get(i).getValue() * A[i]);
            }

            // 결과값 출력
            System.out.println(sum);
        }
    }
}

class Num{
    private int index;
    private int value;

    public Num(int index, int value){
        this.index = index;
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public int getIndex(){
        return index;
    }
}
