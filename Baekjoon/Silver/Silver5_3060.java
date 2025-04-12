package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_3060 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int t = 0; t < T; t++) {
                long N = Long.parseLong(br.readLine());
                long[] feed = new long[6];
                long[] nextFeed = new long[6];

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < 6; i++) {
                    feed[i] = Integer.parseInt(st.nextToken());
                }

                int day=0;
                long total = 0;
                for (long f : feed)
                    total += f;

                if (total > N) {
                    sb.append("1\n");
                    continue;
                }

                while (true) {
                    for(int i=0; i<6; i++){
                        nextFeed[i] =feed[i]+feed[(i+1)%6] + feed[(i+5)%6] + feed[(i+3)%6];
                    }

                    total = 0;
                    for(int i = 0; i < 6; i++){
                        feed[i] = nextFeed[i];
                        total += nextFeed[i];
                    }

                    day++;
                    if (total > N){
                        sb.append((day + 1)).append("\n");
                        break;
                    }
                }
            }
            System.out.print(sb);
        }
    }
}
