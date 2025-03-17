package AlgorithmPracticeKit.level2;

public class level2_87946 {
    static int result = 0;
    public static void main(String[] args) throws Exception{
        int [][] dungeons = {{80,20}, {50,40}, {30,10}};
        System.out.println(solution(80, dungeons));
    }

    public static int solution(int k, int [][] dungeons){
        boolean [] visited = new boolean[dungeons.length];
        return dfs(dungeons, visited, k, 0);
    }

    public static int dfs(int [][] dungeons, boolean [] visited, int k, int count){
        result = Math.max(count, result);
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                dfs(dungeons, visited, k-dungeons[i][1], count+1);
                visited[i] = false;
            }
        }

        return result;
    }
}
