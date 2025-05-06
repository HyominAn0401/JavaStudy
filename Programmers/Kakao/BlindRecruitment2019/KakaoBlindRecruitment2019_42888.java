package Kakao.BlindRecruitment2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KakaoBlindRecruitment2019_42888 {

    // User 클래스
    static class User{
        private String uid;
        private String nickname;
        private boolean isIn;

        // 생성자
        public User(String uid, String nickname, boolean isIn){
            this.uid = uid;
            this.nickname = nickname;
            this.isIn = isIn;
        }
    }

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 기록
            String record [] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

            for(String str : solution(record)){
                System.out.println(str);
            }
        }
    }

    public static String[] solution(String[] record){
        // User 객체 저장 ArrayList
        ArrayList<User> userArrayList = new ArrayList<>();
        // 닉네임 저장 Map
        Map<String, String> nicknameMap = new HashMap<>();
        String [] str = new String[record.length];

        // record 길이만큼 반복
        for(int i=0; i<record.length; i++){
            // 문자열 분리
            String [] order = record[i].split(" ");
            // 행동
            String behavior = order[0];

            str[i] = behavior;

            String uid = order[1];
            // 행동 분류
            switch (behavior) {
                // 입장인 경우
                case "Enter":
                    // 닉네임
                    String nickname = order[2];
                    // 추가
                    nicknameMap.put(uid, nickname);
                    // 입장으로 추가
                    userArrayList.add(new User(uid, nickname, true));
                    break;
                    // 나간 경우
                case "Leave":
                    // 찾기
                    for(User user: userArrayList){
                        // uid가 같고 있는 경우
                        if(user.uid.equals(uid) && user.isIn){
                            user.isIn = false;
                        }
                    }
                    // 조건 : isIn이 true인 경우만
                    // 찾은 객체의 isIn = false로 변경
                    break;
                    // 상태 변경
                case "Change":
                    // 바꾼 이름
                    String changedName = order[2];
                    nicknameMap.put(uid, changedName);
                    // 찾기
                    for(User user : userArrayList){
                        if(user.uid.equals(uid) && user.isIn){
                            // 이름 변경하기
                            user.nickname = changedName;
                        }
                    }
                    break;
            }
        }

        // 정답 ArrayList
        ArrayList<String> answer = new ArrayList<>();

        for(int i=0; i<record.length; i++){
            // 입력받기
            StringBuilder sb = new StringBuilder();
            String uid = record[i].split(" ")[1];

            switch(str[i]){
                case "Enter":
                    sb.append(nicknameMap.get(uid) + "님이 들어왔습니다.");
                    answer.add(sb.toString());
                    break;
                case "Leave":
                    sb.append(nicknameMap.get(uid) + "님이 나갔습니다.");
                    answer.add(sb.toString());
                    break;
                default:
                    break;
            }
        }

        // 반환
        return answer.toArray(new String[0]);
    }

}
