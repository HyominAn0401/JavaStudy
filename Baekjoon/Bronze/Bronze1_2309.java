package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze1_2309 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 7개 수의 합이 100이 되는 7개 수 오름차순 출력하기
        // 로직 설계
        // 1. 크기 9 배열을 생성하고 모든 합을 구하면서 배열에 값 저장
        // 2. 배열 오름차순 정렬 후 메서드에 매개변수로 전달
        // 3. 배열을 돌면서 총합에서 두 개 수를 뺐을 때 100이 되는 두 수를 찾음
        // 4. 100이 되면 두 수를 제외하고 배열에서 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 키 값을 저장할 배열
            int [] dwarfLength = new int[9];
            // 총합을 저장할 변수
            int totalSum = 0;

            // 배열에 값 저장 및 총합 저장
            for(int i=0; i<9; i++){
                dwarfLength[i] = Integer.parseInt(br.readLine());
                totalSum += dwarfLength[i];
            }

            // 오름차순 정렬
            Arrays.sort(dwarfLength);

            // 메서드 실행
            realDwarfs(dwarfLength, totalSum);

        }
    }

    // 가짜 난쟁이를 제외한 키 오름차순 출력
    public static void realDwarfs(int [] dwarfLength, int totalSum){
        // 반복문 돌면서 찾기
        for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                int originSum = totalSum;
                // 총합에서 두 개의 수 빼기
                originSum = originSum - dwarfLength[i] - dwarfLength[j];
                // 해당 값이 100인 경우
                if(originSum==100){
                    // 출력
                    for(int length : dwarfLength){
                        // 두 수는 제외
                        if(length == dwarfLength[i] || length == dwarfLength[j])
                            continue;
                        // 나머지 수 출력
                        else{
                            System.out.println(length);
                        }
                    }
                    // 찾았으니 종료
                    return;
                }
            }
        }
    }
}
