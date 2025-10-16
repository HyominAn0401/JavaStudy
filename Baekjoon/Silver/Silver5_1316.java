package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Silver5_1316 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것: N개 단어를 입력받고 각 단어에서 문자가 연속되어 나타나는 그룹 단어의 개수 출력
        // 로직 설계
        // 1. 단어의 개수 N을 입력받고 N만큼 반복문 실행
        // 2. 입력받은 단어를 Character 배열로 분해, 문자를 저장할 List 생성
        // 3. Character 배열 순차적으로 검사
        // 3-1. 만약 해당 문자가 List에 존재하지 않는다면 List에 추가
        // 3-2. 존재한다면
        // 3-2-1. 리스트에 존재하지만 바로 앞 칸과 같은 값인 경우는 pass
        // 3-2-2. 앞 칸과 값이 다른 경우 -> 그룹단어가 아님. break
        // 4. 플래그가 배열 탐색 전과 같다면 그룹 단어이므로 count 값 누적
        // 5. 결과값 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 단어의 개수 입력받기
            int N = Integer.parseInt(br.readLine());
            // 그룹단어에 해당하는 단어의 개수를 카운트할 변수
            int count = 0;

            // 단어별 반복문
            for(int n = 0; n<N; n++){
                // 단어 입력받기
                String str = br.readLine();
                // 해당 단어를 배열로 분해
                char [] charArray = str.toCharArray();

                // 문자를 저장할 리스트 생성
                List<Character> characterList = new ArrayList<>();
                // 그룹 단어 판단 플래그
                boolean isDifferent = false;
                // 배열 탐색
                for(int i=0; i<charArray.length; i++){
                    // 리스트에 존재하지 않는 경우 -> 아예 새로운 문자인 경우
                    // 추가하고 끝
                    if(!characterList.contains(charArray[i])){
                        characterList.add(charArray[i]);
                    }
                    // 리스트에 존재하는 경우
                    else {
                        // 리스트에 존재하고 이전값과 같은 경우 그대로 반복
                        if (characterList.contains(charArray[i]) && charArray[i] == charArray[i - 1])
                            continue;
                            // 리스트에 존재하지만 앞칸과 값이 다른 경우
                        else {
                            // 플래그 변경
                            isDifferent = true;
                        }
                    }
                    // 플래그 변경 시 탐색 종료
                    if(isDifferent) break;
                }
                // 플래그가 변경되지 않았으면 그룹 단어 -> 누적
                if(!isDifferent)    count++;
            }
            System.out.println(count);

//            int N = Integer.parseInt(br.readLine());
//            int count = 0;
//            for(int n =0; n<N; n++){
//                String s = br.readLine();
//                if(isGroupWord(s))  count++;
//            }
//            System.out.println(count);
        }
    }

    private static boolean isGroupWord(String s){
        boolean [] seen = new boolean[26]; // a ~ z
        char prev = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c!=prev) { //블록이 끊김
                int idx = c - 'a';
                if(seen[idx]){
                    // 이전에 한 번 나온 적 있는 문자 다시 등장
                    return false;
                }
                seen[idx] = true; // 이 문자는 본 것임
                prev = c;
            }

        }
        return true;
    }
}
