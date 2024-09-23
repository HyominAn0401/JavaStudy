package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver2_2644_dfs {
    // 부모 자식 간 관계 저장할 ArrayList 배열
    static ArrayList<Integer>[] relationship;
    // 방문 배열
    static boolean [] visited;
    // 촌수(depth)를 저장할 배열
    static int [] degree;
    static int result = -1;

    public static void main(String[] args) throws Exception{

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 전체 사람의 수
            int n = Integer.parseInt(br.readLine());
            // 촌수를 구하고자 하는 두 사람의 번호
            StringTokenizer st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            // 관계의 수
            int m = Integer.parseInt(br.readLine());

            // 초기화
            relationship = new ArrayList[n+1];
            degree = new int[n+1];
            visited = new boolean[n+1];

            // 인접 리스트 초기화
            for(int i=1; i<=n; i++){
                relationship[i] = new ArrayList<>();
            }

            // 관계 저장
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                relationship[x].add(y);
                relationship[y].add(x);
            }

            DFS(person1, person2, 0);

            System.out.println(result);
        }
    }

    // DFS 메서드
    public static void DFS(int n, int target, int depth){
        visited[n] = true;

        if(n == target){
            result = depth;
            return;
        }

        for(int x : relationship[n]){
            if(!visited[x]){
                DFS(x, target, depth+1);
            }
        }
    }

}

