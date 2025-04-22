package Kakao.BlindRecruitment2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KakaoBlindRecruitment2019_42888 {

    static class User{
        private String uid;
        private String nickname;
        private boolean isIn;

        public User(String uid, String nickname, boolean isIn){
            this.uid = uid;
            this.nickname = nickname;
            this.isIn = isIn;
        }
    }

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String record [] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

            for(String str : solution(record)){
                System.out.println(str);
            }
        }
    }

    public static String[] solution(String[] record){
        ArrayList<User> userArrayList = new ArrayList<>();
        String [] str = new String[record.length];

        for(int i=0; i<record.length; i++){
            String [] order = record[i].split(" ");
            String behavior = order[0];

            str[i] = behavior;

            String uid = order[1];
            switch (behavior) {
                case "Enter":
                    String nickname = order[2];
                    userArrayList.add(new User(uid, nickname, true));
                    break;
                case "Leave":
                    // 찾기
                    for(User user: userArrayList){
                        if(user.uid.equals(uid) && user.isIn){
                            user.isIn = false;
                        }
                    }
                    // 조건 : isIn이 true인 경우만
                    // 찾은 객체의 isIn = false로 변경
                    break;
                case "Change":
                    String changedName = order[2];
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

        ArrayList<String> answer = new ArrayList<>();

        for(int i=0; i<record.length; i++){
            StringBuilder sb = new StringBuilder();
            String uid = record[i].split(" ")[1];

            switch(str[i]){
                case "Enter":
                    sb.append(getLatestNickname(userArrayList, uid) + "님이 들어왔습니다.");
                    answer.add(sb.toString());
                    break;
                case "Leave":
                    sb.append(getLatestNickname(userArrayList, uid) + "님이 나갔습니다.");
                    answer.add(sb.toString());
                    break;
                default:
                    break;
            }
        }

        return answer.toArray(new String[0]);
    }

    private static String getLatestNickname(ArrayList<User> userList, String uid) {
        for (int i = userList.size() - 1; i >= 0; i--) {
            if (userList.get(i).uid.equals(uid)) {
                return userList.get(i).nickname;
            }
        }
        return "";
    }
}
