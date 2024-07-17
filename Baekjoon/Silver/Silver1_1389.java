package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_1389 {

    // 인접 행렬
    private static int [][] KevinBacon;
    // 사람 수와 관계 수 저장할 배열
    static int N, M;

    public static void main(String[] args) throws IOException {
        // 구현 및 해야할 것 : 사람 수와 관계 수를 입력받고 플로이드워셜 알고리즘을 기반으로 각 사람 간 케빈 베이컨 값이 최소인 사람의 번호를 출력한다
        // 로직 설계
        // 1. 사람 수와 관계 수를 입력받고 인접 행렬을 생성한다
        // 2. 인접 행렬을 초기화한다
        // 3. 플로이드 워셜 알고리즘으로 각 사람 별 최단 거리를 구하고 배열에 저장한다
        // 4. 케빈베이컨 값이 최소인 사람의 번호를 출력한다

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 사람 수와 관계 수 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 인접행렬 생성
            KevinBacon = new int[N+1][N+1];

            // 인접행렬 초기화 1: 큰 값으로 초기화, 자기 자신은 0
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(i==j)    KevinBacon[i][j] = 0;
                    else    KevinBacon[i][j] = 10000001;
                }
            }

            // 인접 행렬 초기화 2: 값 저장
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                // 양방향
                KevinBacon[s][e] = 1;
                KevinBacon[e][s] = 1;
            }

            // 플로이드 워셜로 최단 거리 구하기
            for(int k=1; k<=N; k++){
                for(int s=1; s<=N; s++){
                    for(int e=1; e<=N; e++){
                        if(KevinBacon[s][e] > KevinBacon[s][k]+KevinBacon[k][e])
                            KevinBacon[s][e] = KevinBacon[s][k] + KevinBacon[k][e];
                    }
                }
            }

            // 각 사람의 케빈 베이컨 값을 구하고 가장 적은 단계의 사람 번호 출력하기
            int minValue = Integer.MAX_VALUE;
            int index=0;
            for(int i=1; i<=N; i++){
                int sum = 0;
                for(int j=1; j<=N; j++){
                    sum += KevinBacon[i][j];
                }
                if(sum < minValue)  {
                    minValue = sum;
                    index = i;
                }
            }

            System.out.println(index);
        }
    }
}
