package AlgorithmPracticeKit.level3;

import java.util.ArrayList;

public class level3_43162 {
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    public static void main(String[] args) throws Exception{
        int n = 3;
        //int [][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        int [][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int [][] computers){
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                if(i!=j && computers[i][j]==1){
                    graph[i+1].add(j+1);
                    graph[j+1].add(i+1);
                }
            }
        }

        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited[i+1]){
                dfs(i+1);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int num){
        visited[num] = true;
        for(int n : graph[num]){
            if(!visited[n]){
                visited[n] = true;
                dfs(n);
            }
        }
    }
}
