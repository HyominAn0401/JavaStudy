package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_2852 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int team1 = 0, team2=0;
            int winTeam1 = 0, winTeam2=0;

            int now = 0;
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int team = Integer.parseInt(st.nextToken());

                String str = st.nextToken();
                String [] parts = str.split(":");
                int min = Integer.parseInt(parts[0]);
                int sec = Integer.parseInt(parts[1]);
                int second = min*60+sec;


                if (team1 > team2) {
                    winTeam1 += (second - now);
                }
                else if (team1 < team2) {
                    winTeam2 += (second - now);
                }

                if(team==1) team1++;
                else if(team==2)    team2++;

                now = second;

//                System.out.println(now);
//                System.out.println(winTeam1+" "+winTeam2);
            }

            if(now < 2880){
                if(team1 < team2){
                    winTeam2 += (2880 - now);
                }
                else if(team1 > team2){
                    winTeam1 += (2880 - now);
                }
            }

            System.out.println(String.format("%02d:%02d", winTeam1 / 60, winTeam1 % 60));
            System.out.println(String.format("%02d:%02d", winTeam2 / 60, winTeam2 % 60));
        }
    }
}
