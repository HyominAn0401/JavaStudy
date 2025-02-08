package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Silver1_14247 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 그리디 알고리즘으로 n일간 하루에 한 그루를 자를 때 n일 후 자른 나무의 최대 양 구하기
        // 로직 설계
        // 1. 나무 개수, 첫날 길이, 성장 길이 저장
        // 2. Tree를 저장하는 ArrayList에 나무의 인덱스와 나무의 성장 길이 저장
        // 3. 성장 속도를 기반으로 오름차순 정렬
        // 4. 성장 속도가 느린 순서대로 나무를 자르고 sum에 누적합
        // 5. n일 후 최대 나무 양 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 나무의 개수
            int N = Integer.parseInt(br.readLine());
            // Tree를 저장하는 ArrayList 생성
            ArrayList<Tree> trees = new ArrayList<>();

            // 나무의 길이 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] length = new int[N];
            for(int i=0; i<N; i++){
                length[i] = Integer.parseInt(st.nextToken());
            }

            // 나무의 성장 길이 저장
            int [] grows = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int growth = Integer.parseInt(st.nextToken());
                grows[i] = growth;
                // ArrayList에 Tree 인스턴스로 저장
                trees.add(new Tree(i, growth));
            }

            // 성장 길이 기반으로 정렬
            trees.sort(Comparator.comparingInt(t->t.growth));

            // n일 후 나무양을 저장할 변수
            long sum = 0;

            // n일 동안 반복
            for(int i=0; i<N; i++){
                // i날 나무 자른 것 누적
                sum += length[trees.get(i).getIndex()];
                // 0으로 길이 초기화
                length[trees.get(i).getIndex()] = 0;
                // 다음날 나무 성장
                for(int j=0; j<N; j++){
                    length[j] += grows[j];
                }
            }

            // 결과 출력
            System.out.println(sum);

        }
    }

    // 인덱스와 성장 길이를 저장할 클래스
    public static class Tree{
        int index;
        int growth;

        public Tree(int index, int growth){
            this.index = index;
            this.growth = growth;
        }

        public int getIndex() {
            return index;
        }
    }
}

