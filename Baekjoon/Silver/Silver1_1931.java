package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver1_1931 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 회의 시작시간과 끝나는 시간을 받아 최대 사용할 수 있는 회의 최대 개수 출력
        // 로직 설계
        // 1. 회의 시작 시간과 끝 시간 입력받기
        // 2. 끝나는 시간 기준 오름차순 정렬, 만약 끝나는 시간이 같으면 시작 시간 기준 정렬
        // 3. 다음 회의의 시작 시간이 이전 회의의 끝나는 시간보다 크면 회의 개수 증가, 다음 회의 시간의 끝나는 시간이 현재 끝나는 시간으로 업데이트
        // 4. 최종 최대 회의 개수 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 회의 수
            int N = Integer.parseInt(br.readLine());
            // 회의 정보 저장 리스트
            List<Meeting> meetings = new ArrayList<>();
            //ArrayList<Meeting> meetings = new ArrayList<>();

            // 회의 시작 시간과 끝 시간 입력받아 Meeting 객체로 저장
            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                meetings.add(new Meeting(s,e));
            }

            // 회의 끝나는 시간 기준 정렬
            meetings.sort((m1, m2)->{
                // 끝나는 시간이 같으면 시작 시간 기준으로 정렬
                if(m1.end == m2.end){
                    return Integer.compare(m1.start, m2.start);
                }
                return Integer.compare(m1.end, m2.end);
            });

            // 첫 번째 회의 끝나는 시간
            int endTime = meetings.get(0).end;

            // 초기 회의 개수는 1 -> 첫 번째 회의 가능
            int count = 1;

            // 두 번째 회의부터 확인
            for(int i=1; i<N; i++){
                // 이전 회의 끝나는 시간 이후에 시작되면
                if(endTime <= meetings.get(i).start){
                    // 회의 개수 증가
                    count++;
                    // 끝나는 시간을 현재 회의로 업데이트
                    endTime = meetings.get(i).end;
                }
            }
            // 최대 회의 개수 출력
            System.out.println(count);
        }
    }
}

// 회의 정보 저장 클래스
class Meeting{
    int start;
    int end;

    // 생성자
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}
