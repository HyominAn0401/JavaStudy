package D3;

import java.util.Scanner;

public class D3_1206 {

    public static void main(String[] args) {
        // 구현 및 해야할 것 : 테스트 케이스 번호와 조망권이 확보된 세대 수 출력하기
        // 로직 설계
        // 1. 조망권 확보 세대 수를 담을 크기 10의 배열을 생성한다.
        // 2. 3-5 단계를 테스트 케이스 10번만큼 반복한다
        // 3. 건물 개수 N과 N개의 높이를 입력받고 배열에 건물의 높이를 저장한다
        // 4. 기준값 두 칸, 한 칸 앞, 기준값 한 칸, 두 칸 뒤와의 차이를 계산한다
        // 5. 4개의 값 중 음수가 있으면 조망권이 확보되지 않으므로 0을, 음수가 없으면 가장 작은 값을 더해 total_counts에 더한다
        // 6. total_counts 값을 배열에 담아 출력한다.

        Scanner scanner = new Scanner(System.in);
        // 테스트 케이스마다 조망권이 확보된 세대 수 저장할 배열
        int [] view_units = new int[10];

        // 테스트 케이스(10: 문제 지정) 처리 반복문
        for(int testCase = 0; testCase<10; testCase++){
            // 조망권 확보 세대 총 수를 저장할 변수
            int total_counts = 0;
            // 건물 수 입력받기
            int N = scanner.nextInt();
            // 건물 수 만큼 높이를 저장할 배열
            int [] heights_array = new int[N];

            // 건물 높이 입력받아 배열에 저장
            for(int i=0; i<N; i++){
                heights_array[i] = scanner.nextInt();
            }
            // 맨 앞 2칸, 맨 뒤 2칸을 제외한 사이 건물의 조망권을 검사하는 반복문
            for(int i=2; i<N-2; i++){
                // 기준 건물과 앞 2, 1칸, 뒤 1, 2칸과 차이 계산
                int prev_height_2 = heights_array[i]- heights_array[i-2];
                int prev_height_1 = heights_array[i]- heights_array[i-1];
                int next_height_1 = heights_array[i]- heights_array[i+1];
                int next_height_2 = heights_array[i]- heights_array[i+2];

                // 하나라도 음수인 경우
                if(prev_height_2<=0||prev_height_1<=0||next_height_1<=0||next_height_2<=0){
                    // 조망권이 확보되지 않아 추가 세대 수 없음
                    total_counts += 0;
                }
                // 0 이상인 경우
                else{
                    // 최소값 생성(건물 높이는 최대 255)
                    int min= 255;
                    // 4개 값을 저장하는 배열
                    int [] find_min_array = {prev_height_2, prev_height_1, next_height_1, next_height_2};
                    // 최소값을 찾는 반복문
                    for(int j=0;j<find_min_array.length;j++) {
                        if (min > find_min_array[j])
                            min = find_min_array[j];
                    }
                    // 조망권 확보된 세대 수 추가
                    total_counts += min;
                }
            }
            // 테스트 케이스 별 계산 결과 배열에 저장
            view_units[testCase] = total_counts;
        }

        // 테스트 케이스 결과 출력
        for(int testCase = 0; testCase<10; testCase++){
            System.out.println("#"+(testCase+1)+" "+view_units[testCase]);
        }

        scanner.close();
    }
}
