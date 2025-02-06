package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_2529 {
    static int k;
    static char [] inequalitySign;
    static boolean [] used;
    static String minValue = "9999999999";
    static String maxValue = "0000000000";
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 부등호를 만족하는 k+1자리 모두 다른 숫자 중 최댓값과 최솟값 출력하기
        // 로직 설계
        // 1. k를 입력받고 해당 크기의 부등호를 저장하는 배열과 0-9까지 숫자의 사용 유무를 저장할 boolean 배열 초기화
        // 2. 각 부등호를 배열에 저장
        // 3. 0부터 10까지 각 숫자에 대해 dfs 실행
        // 4. 부등호 조건을 만족하는 숫자의 최댓값과 최솟값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // k 입력받아 해당 크기의 배열 초기화
            k = Integer.parseInt(br.readLine());
            inequalitySign = new char [k];
            // 숫자 사용 유무를 저장할 배열
            used = new boolean[10];

            // 부등호 입력받아 배열에 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<k; i++){
                inequalitySign[i] = st.nextToken().charAt(0);
            }

            // 부등호 배열 인덱스 변수
            int index = 0;
            // 각 숫자별 dfs 실행
            for(int i=0; i<10; i++){
                // dfs에 사용할 StringBuilder 객체 생성
                StringBuilder sb = new StringBuilder();
                // 첫 숫자, 깊이, 부등호배열 인덱스, 첫 숫자를 추가한 StringBuilder 객체 전달
                dfs(i, 1, index, sb.append(i));
            }

            // 최댓값과 최솟값 출력
            System.out.println(maxValue+"\n"+minValue);
        }
    }

    // dfs 메서드
    public static void dfs(int num, int depth, int index, StringBuilder sb){
        // 깊이가 k+1이 되면
        if(depth==k+1){
            // 최댓값, 최솟값 비교하기
            String result = sb.toString();
            if(result.compareTo(minValue) <0)   minValue = result;
            if(result.compareTo(maxValue) >0)   maxValue = result;
            return;
        }

        // 해당 숫자 사용 업데이트
        used[num] = true;

        // 0-9까지의 숫자에 대해 반복
        for(int i=0; i<10; i++){
            // 사용하지 않는 숫자면
            if(!used[i]){
                // 부등호 판별
                if(inequalitySign[index]=='>'){
                    // 조건에 만족하면
                    if(num > i) {
                        // dfs 실행
                        dfs(i, depth + 1, index + 1, new StringBuilder(sb).append(i));
                        //sb.setLength(sb.length()-1);
                    }
                }
                else if(inequalitySign[index]=='<'){
                    if(num < i) {
                        dfs(i, depth + 1, index + 1, new StringBuilder(sb).append(i));
                        //sb.setLength(sb.length()-1);
                    }
                }
            }
        }

        // 백트래킹
        used[num] = false;
    }
}
