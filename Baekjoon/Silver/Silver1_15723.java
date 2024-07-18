package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver1_15723 {
    //private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : n개의 전제를 입력받고 m개의 결론이 참인지 거짓인지 출력하기
        // 로직 설계
        // 1. n 입력받고 소문자 개수 크기의 인접 행렬 생성
        // 2. 인접 행렬 초기화 : 자기 자신은 0, 그 외의 경우 INF 저장
        // 3. 전제를 토큰으로 분해해 정수화 및 인접 행렬에 값 저장
        // 4. 플로이드 워셜로 최소값 계산해 인접 행렬 업데이트
        // 5. m 입력받고 m개의 전제 입력받아 결론 출력하기

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st;
            // StringBuilder 생성
            StringBuilder sb = new StringBuilder();

            // n 입력받기
            int n = Integer.parseInt(br.readLine());
            // 다른 수 대비 큰 값을 저장할 변수
            int INF = 10000001;
            //.out.println((int)'a');

            //int N = list.size();
            // 인접 행렬 생성 -> 소문자 개수 크기
            int [][] distance = new int[26][26];

            // 인접 행렬 초기화
            for(int i=0; i<26; i++){
                for(int j=0; j<26; j++){
                    // 자기 자신의 경우 0 저장
                    if(i==j)    distance[i][j] = 0;
                    // 그 외는 INF 저장
                    else    distance[i][j] = INF;
                }
            }

            // 인접 행렬에 전제값 저장
            for(int i=0; i<n; i++){
                // 토큰으로 분해
                st = new StringTokenizer(br.readLine());
                // 연산자와 피연산자 입력받기
                // 정수값으로 변환
                int op1 = st.nextToken().charAt(0)-'a';
                st.nextToken();
                int op2 = st.nextToken().charAt(0)-'a';
//                if(!list.contains(op1))
//                    list.add(op1);
//                if(!list.contains(op2))
//                    list.add(op2);
                // 인접 행렬에 1로 저장
                distance[op1][op2] = 1;
            }

            // 플로이드 워셜 알고리즘으로 최소값 저장
            for(int k=0; k<26; k++){
                for(int s =0; s<26; s++){
                    for(int e=0; e<26; e++){
                        if(distance[s][e] > (distance[s][k]+distance[k][e]))
                            distance[s][e] = (distance[s][k]+distance[k][e]);
                    }
                }
            }

            // m 입력받기
            int m = Integer.parseInt(br.readLine());
            // m만큼 반복하면서 결론 입력받기
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int op1 = st.nextToken().charAt(0)-'a';
                st.nextToken();
                int op2 = st.nextToken().charAt(0)-'a';
                // 해당 값이 INF가 아니고 0보다 큰 값일 경우
                if(distance[op1][op2]!=INF && distance[op1][op2]>0)
                    sb.append("T\n");
                // 그 외의 경우
                else sb.append("F\n");
            }

            // 결과값 출력
            System.out.print(sb);

        }
    }
}
