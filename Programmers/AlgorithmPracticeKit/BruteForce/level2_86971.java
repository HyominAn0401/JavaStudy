package AlgorithmPracticeKit.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class level2_86971 {
    static ArrayList<Integer> [] tower;
    static boolean [] visited;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = 9;
            int [][] wires = {{1,3},{2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
            System.out.print(solution(n, wires));
        }
    }

    public static int solution(int n, int [][] wires){
        int minValue = Integer.MAX_VALUE;

        for(int i=0; i<wires.length; i++){
            tower = new ArrayList[n+1];
            visited = new boolean[n+1];
            for(int j=1; j<=n; j++){
                tower[j] = new ArrayList<>();
            }

            for(int j=0; j<wires.length; j++){
                if(i==j)    continue;
                int s = wires[j][0];
                int e = wires[j][1];
                tower[s].add(e);
                tower[e].add(s);
            }

            int result = dfs(wires[i][0]);
            int left = n-result;

            minValue = Math.min(Math.abs(left-result), minValue);
        }
        return minValue;
    }

    public static int dfs(int n){
        int count = 1;
        visited[n] = true;
        for(int t : tower[n]){
            if(!visited[t]){
                count += dfs(t);
            }
        }
        return count;
    }
}
