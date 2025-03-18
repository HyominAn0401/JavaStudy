package AlgorithmPracticeKit.level2;

public class level2_87946 {
    static int result = 0;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 던전 탐험 순서를 정하고 탐험할 수 있는 최대 던전의 수 출력하기
        // 로직 설계
        // 1. 방문 배열 초기화 및 dfs에 매개변수로 전달
        // 2. 던전의 길이 만큼 순열 생성 -> dfs, 백트래킹
        // 3. 해당 던전을 방문하지 않았고 k가 최소 필요 피로도보다 크면 dfs 실행
        // 4. 탐험 가능 최대 던전 수 출력
        int [][] dungeons = {{80,20}, {50,40}, {30,10}};
        System.out.println(solution(80, dungeons));
    }

    public static int solution(int k, int [][] dungeons){
        // 방문 배열
        boolean [] visited = new boolean[dungeons.length];
        // 첫 dfs 실행
        return dfs(dungeons, visited, k, 0);
    }

    public static int dfs(int [][] dungeons, boolean [] visited, int k, int count){
        // 최대 던전의 수
        result = Math.max(count, result);
        // 반복
        for(int i=0; i<dungeons.length; i++){
            // 방문하지 않았고 최소 필요 피로도보다 크거나 같으면
            if(!visited[i] && k>=dungeons[i][0]){
                // 방문 업데이트
                visited[i] = true;
                // dfs 실행
                dfs(dungeons, visited, k-dungeons[i][1], count+1);
                // 백트래킹
                visited[i] = false;
            }
        }

        // 결과값 리턴
        return result;
    }
}
