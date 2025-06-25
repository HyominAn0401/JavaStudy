package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Gold5_1931 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            List<Meeting> meetings = new ArrayList<>();

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                meetings.add(new Meeting(start, end));
            }

            // 끝나는 시간 오름차순
            Comparator<Meeting> byEndTime = (a,b) -> {
                if(a.end != b.end)
                    return a.end - b.end;
                else{
                    return a.start - b.start;
                }
            };
            meetings.sort(byEndTime);

            int count = 0;

            int lastEndTime = 0;
            for(Meeting meeting : meetings){
                int startTime = meeting.start;
                if(lastEndTime <= startTime){
                    count++;
                    lastEndTime = meeting.end;
                }
            }

            System.out.println(count);
        }
    }

    static class Meeting{
        int start;
        int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
