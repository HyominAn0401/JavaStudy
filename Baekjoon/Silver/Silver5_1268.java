package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver5_1268 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 같은 반을 가장 많이 한 학생 번호 출력
        // 로직 설계
        // 1. 학생 수와 NxN 크기의 이차원 배열 생성 수 반 저장
        // 2. 반복문을 돌면서 같은 반이었던 학생들의 인덱스 저장
        // 3. i+1 출력
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            // 학생 수
            int N = Integer.parseInt(br.readLine());
            int [][] classes = new int[N][N];

            // 배열에 반 저장
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    classes[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가장 큰 값
            int maxValue = 0;
            // 반장 번호
            int president = 0;

            // 반복하면서 해당 학생과 같은 반이었던 학생 인덱스 저장
            for(int i=0; i<N; i++){
                Set<Integer> students = new HashSet<>();

                for(int j=0; j<N; j++){
                    for(int k=0; k<N; k++){
                        if(i!=k && classes[i][j]==classes[k][j]){
                            students.add(k);
                        }
                    }
                }


                if(students.size() > maxValue){
                    maxValue = students.size();
                    president = i+1;
                }
            }

            // 결과 출력
            System.out.println(president);
        }
    }
}
