package AlgorithmPracticeKit.BruteForce;

import java.util.ArrayList;

public class level2_42842 {
    static ArrayList<Integer> [] graph;
    static boolean [] visited;

    public static void main(String[] args) {
        int n = 9;
        int [][] wires = {{1,3},{2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};

        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int [][] wires){
        int minValue = Integer.MAX_VALUE;

        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<wires.length; i++){
            int s = wires[i][0];
            int e = wires[i][1];
            graph[s].add(e);
            graph[e].add(s);
        }

        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];

            graph[a].remove((Integer)b);
            graph[b].remove((Integer)a);

            visited = new boolean[n+1];
            int count = dfs(1);

            int subtractCnt = Math.abs(n - count - count);
            minValue = Math.min(subtractCnt, minValue);
            graph[a].add(b);
            graph[b].add(a);
        }

//        for(int i=1; i<=n; i++){
//            if(graph[i].size()>0){
//                for(int m : new ArrayList<>(graph[i])){
//                    graph[i].remove(m);
//                    graph[m].remove(i);
//                    // dfs 실행
//                    // 방문배열 초기화
//                    visited = new boolean[n+1];
//                    int count = dfs(1);
//
//                    // 각 그래프 노드 차이
//                    int subtractCnt = Math.abs(n - count - count);
//                    minValue = Math.min(minValue, subtractCnt);
//                    graph[i].add(m);
//                    graph[m].add(i);
//                }
//            }
//        }

        return minValue;
    }

    public static int dfs(int node){
        visited[node] = true;
        int count = 1;
        for(int number : graph[node]){
            if(!visited[number]){
                count += dfs(number);
            }
        }
        return count;
    }
}
