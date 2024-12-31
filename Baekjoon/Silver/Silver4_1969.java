package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_1969 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int [] count = new int[4];
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<N; i++){
                String str = br.readLine();
                char [] dna = str.toCharArray();

                for(int j=0; j<dna.length; j++){
                    switch (dna[j]){
                        case 'A': count[0]++; break;
                        case 'C': count[1]++; break;
                        case 'G': count[2]++; break;
                        case 'T': count[3]++; break;
                    }
                }


            }
        }
    }
}
