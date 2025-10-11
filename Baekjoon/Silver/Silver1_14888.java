package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver1_14888 {
    // 구현 및 해야할 것 : 숫자와 연산자가 주어질 때 계산값의 최댓값과 최솟값 출력하기
    // 로직 설계
    // 1. 숫자와 연산자 개수 입력받아 저장
    // 2. 각 연산자 개수에 따라 리스트에 연산자 저장
    // 3. depth 값이 연산자 개수가 될 때까지 백트래킹 실행
    // 4. 최댓값과 최솟값 출력

    // 숫자를 저장할 배열 초기화
    static int [] numArray;
    // 연산자 인덱스 저장 리스트
    static List<Integer> operator = new ArrayList<>();
    // 연산자 저장 리스트
    static List<Character> charList = new ArrayList<>();
    // 최댓값과 최솟값 초기화
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 수의 개수
            int N = Integer.parseInt(br.readLine());
            numArray = new int[N];

            // 배열에 숫자 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                numArray[i] = Integer.parseInt(st.nextToken());
            }

            // N 값이 1이면 출력 후 종료
            if(N==1){
                System.out.print(numArray[0]+"\n"+numArray[0]);
            }
            // N이 1이 아닌 경우
            else{
                st = new StringTokenizer(br.readLine());
                // 리스트에 연산자 추가
                for(int i=0; i<4; i++){
                    int count = Integer.parseInt(st.nextToken());
                    if(i==0 && count!=0){
                        for(int j=0; j<count; j++){
                            charList.add('+');
                        }
                    }
                    else if(i==1 && count!=0){
                        for(int j=0; j<count; j++){
                            charList.add('-');
                        }
                    }
                    else if(i==2 && count!=0){
                        for(int j=0; j<count; j++){
                            charList.add('*');
                        }
                    }
                    else if(i==3 && count!=0){
                        for(int j=0; j<count; j++){
                            charList.add('/');
                        }
                    }
                }

                // 백트래킹 실행
                recur(0, N-1);
                // 최대 최솟값 출력
                System.out.print(maxValue+"\n"+minValue);
            }
        }
    }

    // 재귀함수
    public static void recur(int depth, int sum){
        // depth가 연산자 개수와 같은 경우
        if(depth == sum){
            int result = numArray[0];
            // 계산
            for(int i=0; i<sum; i++){
                result = calculate(result, charList.get(operator.get(i)), numArray[i+1]);
            }
            // 최대최솟값 비교
            maxValue = Math.max(result, maxValue);
            minValue = Math.min(result, minValue);
        }

        // 연산자 개수만큼 반복
        for(int i=0; i<sum; i++){
            // 인덱스가 이미 리스트에 존재하면 -> 중복
            if(operator.contains(i))    continue;
            // 리스트에 인덱스 추가
            operator.add(i);
            // 재귀
            recur(depth+1, sum);
            // 마지막 인덱스 제거
            operator.remove(operator.size()-1);
        }

    }

    // 계산 메서드
    public static int calculate(int n, char op, int m){
        int result = 0;
        switch (op){
            case '+':
                result = n+m;
                break;
            case '-':
                result = n-m;
                break;
            case '*':
                result = n*m;
                break;
            case '/':
                if(n<=0)    result = -((-n)/m);
//                if(n<0 || m<0)
//                    result = -Math.abs(n/m);
                else result = n/m;
                break;
        }
        return result;
    }
}
