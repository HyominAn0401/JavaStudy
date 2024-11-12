package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D4_2819 {
    static int [][] numberboard;
    static int [] selected = new int[7];
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase = Integer.parseInt(br.readLine());
            StringBuilder resultSb = new StringBuilder();

            for(int t=1; t<=testCase; t++){
                numberboard = new int[4][4];
                for(int i=0; i<4; i++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for(int j=0; j<4; j++){
                        numberboard[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                for(int i=0; i<4; i++){
                    for(int j=0; j<4; j++){
                        dfs(i, j, 0);
                    }
                }

                resultSb.append("#"+t+" "+set.size()+"\n");
                set.clear();
            }
            System.out.print(resultSb);
        }
    }

    public static void dfs(int x, int y, int depth){
        if(depth==7){
            for(int num : selected){
                sb.append(num);
            }
            set.add(sb.toString());
            //System.out.println(set);
            sb.setLength(0);
            return;
        }
        selected[depth] = numberboard[x][y];
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<4 && ny<4){
                dfs(nx, ny, depth+1);
            }
        }
    }
}
