package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_19941 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 사람과 햄버거가 나열되어 있을 때 K 거리 이하의 햄버거를 먹을 수 있는 사람의 최대 수 구하기
        // 로직 설계
        // 1. 문자열을 입력받고 문자 배열로 분리, 같은 크기의 bool 배열 생성
        // 2. 배열 완전 탐색하면서 값이 P인 경우 거리가 K 이하인 배열값 조건 확인
        // 3. K 거리 이내 배열값이 H이고 bool값이 F인 경우 먹을 수 있는 햄버거이므로 사람 수 증가 및 bool 배열 업데이트
        // 4. 사람의 최대 수 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N과 K 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 문자열을 문자로 분해해 저장하기 위한 배열
            char [] hamburgerLine;
            // 먹을 수 있는 햄버거 유무를 확인하기 위한 bool 배열
            boolean [] isOut = new boolean[N];

            // 문자열 입력받기
            String line = br.readLine();

            // 문자열을 배열에 문자로 분해
            hamburgerLine = line.toCharArray();

            // 최대 사람 수를 누적 합 하기 위한 변수
            int cnt = 0;

            // 문자 배열 완전 탐색
            for(int l=0; l<N; l++){
                // 배열 값이 P 인 경우
                if(hamburgerLine[l]=='P'){
//                    System.out.println("현재위치: "+l);
                    // 왼쪽 오른쪽 K번 반복
                    for(int i=0; i<K*2; i++){
                        // 인덱스 변수를 두고 배열값 확인
                        int index = -1;
                        // 현재 위치보다 배열 왼쪽인 경우
                        if(i<K){
                            index = l - (K-i);
                        }
                        // 현재 위치보다 오른쪽인 경우
                        else{
                            index = l + (i-K)+1;
                        }
                        // 배열 내 조건
                        if(index>=0 && index<N) {
                            // 배열값이 H이고 먹을 수 있는 햄버거인 경우
                            if (hamburgerLine[index] == 'H' && !isOut[index]) {
                                // true로 업데이트
                                isOut[index] = true;
                                // 사람 수 증가
                                cnt++;
//                                System.out.println(index+" 위치 조건 성립, cnt: "+cnt);
                                // 햄버거를 먹을 수 있으므로 반복문 break
                                break;

                            }
                        }
//                        System.out.println("index: "+index);
                    }
                }
            }

            // 결과값 출력
            System.out.println(cnt);
        }
    }
}
