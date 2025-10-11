package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Silver3_10974_20251011 {
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();
    static int n;
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(br.readLine());
            recur(0);
            System.out.print(sb);
        }
    }

    public static void recur(int depth){
        if(depth == n){
            for(int i : list){
                sb.append(i+" ");
            }
            sb.append("\n");
        }

        for(int i=1; i<=n; i++){
            if(list.contains(i))    continue;
            list.add(i);
            recur(depth+1);
            list.remove(list.size()-1);
        }
    }
}
