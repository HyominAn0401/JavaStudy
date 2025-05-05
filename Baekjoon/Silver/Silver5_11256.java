package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver5_11256 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 :
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스트 케이스 입력받기
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            // 각 테스트 케이스 반복
            for(int t=0; t<testCase; t++){
                // 사탕과 박스 개수 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                int candy = Integer.parseInt(st.nextToken());
                int box = Integer.parseInt(st.nextToken());

                // 박스 사이즈를 저장할 배열
                int [] boxSize = new int[box];
                // 상자 가로세로 입력받기
                for(int i=0; i<box; i++){
                    st = new StringTokenizer(br.readLine());
                    int height = Integer.parseInt(st.nextToken());
                    int width = Integer.parseInt(st.nextToken());
                    // 배열에 사이즈 저장
                    boxSize[i] = height*width;
                }

                // 오름차순 정렬
                Arrays.sort(boxSize);

                int count = 0;
                int i=box-1;
                while(candy > 0){
                    candy -= boxSize[i];
                    count++;
                    i--;
                }

                sb.append(count+"\n");
            }

            System.out.print(sb);
        }
    }
}
