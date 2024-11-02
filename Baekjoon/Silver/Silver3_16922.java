package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Silver3_16922 {
    // 선택된 숫자를 저장할 배열
    static int [] selected;
    static int N;
    // 로마 숫자를 저장할 배열
    static int [] numbers = {1, 5, 10, 50};
    // 만든 숫자의 합을 저장할 변수
    static int sum=0;
    // 중복값을 제거할 set
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 4개의 문자 중 N개를 선택해 만들 수 있는 서로 다른 수의 개수 출력하기
        // 로직 설계
        // 1. N을 입력받고 N 크기의 selected 배열 초기화
        // 2. 매개변수로 0, 0 전달, 재귀 실행
        // 3. 배열값을 순회하면서 숫자 선택
        // 4. N값과 depth가 같으면 값의 합을 구해 set에 저장
        // 5. set의 size 출력해 서로 다른 수의 개수 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N 입력받고 selecte 배열 초기화
            N = Integer.parseInt(br.readLine());
            selected = new int[N];
            // start=0, depth=0 매개변수 전달
            generateRomanNumbers(0, 0);
            // 개수 출력
            System.out.println(set.size());
        }
    }

    // 숫자 생성 메서드
    public static void generateRomanNumbers(int start, int depth){
        // depth와 N값이 같으면
        if(depth==N){
            // selected 배열값 누적합 구하기
            for(int num : selected){
                sum += num;
            }
            // set에 누적합 저장
            set.add(sum);
            // 0으로 값 초기화
            sum = 0;
            // 종료
            return;
        }

        // 배열 순회
        for(int i=start; i<numbers.length; i++){
            // depth 위치에 숫자값 저장
            selected[depth] = numbers[i];
            // 재귀 실행
            generateRomanNumbers(i, depth+1);
        }
    }
}
