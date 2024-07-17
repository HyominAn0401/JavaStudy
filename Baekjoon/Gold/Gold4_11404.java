package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold4_11404 {

    private static long [][] distance;

    public static void main(String[] args) throws IOException {

        // 구현 및 해야할 것 : 도시의 개수 및 버스 개수를 입력받고 그래프를 생성해 각 도시로 가는 데 필요한 비용의 최소값을 출력한다
        // 로직 설계
        // 1. 도시 개수, 버스 개수를 입력받고 인접 행렬을 생성한다
        // 2. 인접 행렬을 MAX값으로, 같은 인덱스의 배열값은 0으로 초기화한다
        // 3. 도시로 가는 데 필요한 최소 비용을 저장한다
        // 4. 플로이드-워셜 알고리즘으로 최솟값을 넣고 경로를 탐색한다
        // 5. 결과값이 저장된 배열을 출력한다

        // try-with-resources로 BufferedReader 관리
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 도시 개수와 버스 개수 StringTokenizer를 이용해 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            // N+1 크기의 이차원 배열 생성
            distance = new long[N+1][N+1];

            // 인접 행렬 초기화
            // MAX값으로 저장하되 i==j인 경우는 0을 저장
            for(int i=1; i<N+1; i++){
                for(int j=1; j<N+1; j++){
                    distance[i][j] = Integer.MAX_VALUE;
                    if(i==j)    distance[i][j] = 0;
                }
            }

            // 가중치 배열에 저장하기
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
//                if(distance[s][e] < v)  continue;
//                else    distance[s][e] = v;
                // 최소 비용값 넣기
                if(distance[s][e] > v)  distance[s][e] = v;
            }

            // 플로이드-워셜 알고리즘으로 최소값 넣기
            for(int k=1; k<N+1; k++){
                for(int s=1; s<N+1; s++){
                    for(int e=1; e<N+1; e++){
                        if(s==e)    distance[s][e]=0;
                        else{
//                            if(distance[s][k]==Integer.MAX_VALUE || distance[k][e]==Integer.MAX_VALUE)
//                                (distance[s][k]+distance[k][e]) = Integer.MAX_VALUE;
                            // Max_Value값 계산 불가로 인한 long 처리
                            distance[s][e] = Math.min(distance[s][e], (long)(distance[s][k]+distance[k][e]));
                        }
                        //System.out.println("k: "+k+", s: "+s+", e: "+e+" distance[s][e]: "+distance[s][e]+", distance[s][k]+distance[k][e]: "+(distance[s][k]+distance[k][e]));
                    }
                }
            }

            // 결과값 출력
            for(int i=1; i<N+1; i++){
                for(int j=1; j<N+1; j++){
                    // 저장된 값이 MAX_VALUE인 경우 => 도착할 수 없는 경로
                    if(distance[i][j]==Integer.MAX_VALUE)
                        // 0 출력하기
                        System.out.print(0+" ");
                    else System.out.print(distance[i][j]+" ");
                }
                System.out.println();
            }
        }


    }
}
