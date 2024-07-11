package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class D3_2814_new {

    static boolean[] visited;
    static ArrayList<Integer>[] neighbors;

    static int DFS(int k){

        int num =0;

        Stack<Integer> stack = new Stack<Integer>();
        visited[k] = true;
        stack.push(k);

        while(!stack.isEmpty()){
            int x = stack.pop();
            num++;
            for(int value : neighbors[x]){
                if(!visited[value]){
                    visited[value] = true;
                    stack.push(value);
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int testCase = Integer.parseInt(st.nextToken());

            int [] results = new int[testCase];

            for(int t=0; t<testCase; t++) {

                st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                // 초기화
                visited = new boolean[N + 1];
                neighbors = new ArrayList[N + 1];

                // 인접 리스트 초기화
                for (int i = 1; i < N + 1; i++) {
                    neighbors[i] = new ArrayList<>();
                }

                // 인접 리스트에 간선 입력
                for (int i = 0; i < M; i++) {
                    st = new StringTokenizer(br.readLine());
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());
                    neighbors[s].add(e);
                    neighbors[e].add(s);
                }

                int maxValue = Integer.MIN_VALUE;
                int num = 0;

                for (int i = 1; i < N + 1; i++) {
                    if (!visited[i]) {
                        num = DFS(i);
                        if (num > maxValue) maxValue = num;
                    }
                }
                results[t] = maxValue;
            }

            for(int t=0; t<testCase; t++){
                System.out.println("#"+(t+1)+" "+results[t]);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
