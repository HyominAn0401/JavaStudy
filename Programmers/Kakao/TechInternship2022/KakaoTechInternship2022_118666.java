package Kakao.TechInternship2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class KakaoTechInternship2022_118666 {
    // 구현 및 해야할 것 : 점수 반영해 성격유형 검사 출력하기
    // 로직 설계
    // 1. survey 길이만큼 반복
    // 2. choices 값이 4보다 큰 경우와 작은 경우 분기
    // 3. 작은 경우 비동의이므로 앞 문자로 점수 집계 후 map에 누적
    // 3-1. 큰 경우 동의이므로 뒷 문자로 점수 집계 후 map에 누적
    // 4. 결과값 출력

    // 각 유형별 점수를 저장할 Map
    static Map<Character, Integer> types = new HashMap<>();
    public static void main(String[] args) throws Exception{
        try(BufferedReader br= new BufferedReader(new InputStreamReader(System.in))){
            String[] survey = {"TR","RT","TR"};
            int[] choices = {7,1,3};
            System.out.print(solution(survey, choices));
        }

    }

    public static String solution(String[] survey, int[] choices){
        // 최종 성격 유형 결과를 저장할 StringBuilder 객체
        StringBuilder answer = new StringBuilder();
        // survey 원소 반복
        for(int i=0; i<survey.length; i++){
            // 앞, 뒤 문자 분해
            String[] sur = survey[i].split("");
            // 비동의 문자
            char first = sur[0].toCharArray()[0];
            // 동의 문자
            char second = sur[1].toCharArray()[0];

            // choice 값이 4보다 작은 경우
            if(choices[i] < 4){
                // 비동의 : 앞 문자 전달
                checkType(first, returnNum(choices[i]));
            }
            // choice 값이 4보다 큰 경우
            else if(choices[i] > 4){
                // 동의 : 뒷 문자 전달
                checkType(second, returnNum(choices[i]));
            }
        }
        // 각 페어별 점수 비교하고 StringBuilder 객체에 추가
        if(types.getOrDefault('R',0)>=types.getOrDefault('T',0)){
            answer.append('R');
        }
        else
            answer.append('T');

        if(types.getOrDefault('C',0)>=types.getOrDefault('F',0)){
            answer.append('C');
        }
        else answer.append('F');

        if(types.getOrDefault('J',0)>=types.getOrDefault('M',0)){
            answer.append('J');
        }
        else answer.append('M');

        if(types.getOrDefault('A',0)>=types.getOrDefault('N',0))  answer.append('A');
        else answer.append('N');

        // 결과값 문자열로 변환
        return answer.toString();
    }

    // 타입별 점수 누적
    // 없으면 0
    public static void checkType(char ch, int num){
        switch(ch){
            case 'A':
                types.put('A', types.getOrDefault('A',0)+num);
                break;
            case 'C':
                types.put('C', types.getOrDefault('C', 0)+num);
                break;
            case 'F':
                types.put('F', types.getOrDefault('F', 0)+num);
                break;
            case 'J':
                types.put('J', types.getOrDefault('J', 0)+num);
                break;
            case 'M':
                types.put('M', types.getOrDefault('M', 0)+num);
                break;
            case 'N':
                types.put('N', types.getOrDefault('N', 0)+ num);
                break;
            case 'R':
                types.put('R', types.getOrDefault('R', 0)+num);
                break;
            case 'T':
                types.put('T', types.getOrDefault('T', 0)+num);
                break;
        }
    }

    // choices 기반 점수 반환
    public static int returnNum(int choice){
        switch(choice){
            case 1: case 7:
                return 3;
            case 2: case 6:
                return 2;
            case 3: case 5:
                return 1;
            case 4:
                return 0;
        }
        return -1;
    }
}
