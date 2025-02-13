package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Silver1_1713 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 사진틀에 추천받은 학생들을 올리고 내릴 때 최종 후보 번호 오름차순 정렬해 출력하기
        // 로직 설계
        // 1. N, 학생 수, 추천받은 학생 수를 입력받고 배열을 생성한다. 학생은 최대 100명이므로 100크기의 배열을 생성해 추천 횟수만큼 증가한다.
        // 2. 추천받은 학생에 따라 사진틀에 존재여부에 따라 횟수를 늘리거나, 가장 오래된 학생을 빼고 새로 추가한다.
        // 3. 최종 학생의 번호를 오름차순 정렬해 출력한다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 사진틀 개수 입력받기
            int N = Integer.parseInt(br.readLine());
            //int [] pic = new int[N];
            // 추천 횟수를 누적할 전체 학생 배열
            int [] recommendCnt = new int[101];
            // 추천받은 학생 수 입력받기
            int R = Integer.parseInt(br.readLine());
            // Student 객체를 저장하는 리스트 초기화
            List<Student> students = new ArrayList<>();

            // 오래된 순을 저장하기 위한 변수
            int depth = 0;

            // 추천받은 학생 입력받고 각 학생 번호에 따라 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<R; i++){
                // 추천받은 학생
                int number = Integer.parseInt(st.nextToken());

                // 학생이 사진틀에 존재하지 않는 경우, 새로 추가해야 하는 경우
                if(recommendCnt[number]==0){
                    // 사진틀에 자리가 있는 경우
                    if(students.size() < N){
                        // 추천 횟수 증가
                        recommendCnt[number]++;
                        // 사진틀에 추가
                        students.add(new Student(number, recommendCnt[number], depth));
                    }
                    // 사진틀에 자리가 없음
                    else{
                        // 최솟값 비교를 위한 변수
                        int min = Integer.MAX_VALUE;
                        // 인덱스 저장 변수
                        int index = -1;
                        // 가장 오래된 학생을 사진틀에서 빼고 새로운 학생 넣기
                        for(int l=0; l< students.size(); l++){
                            if(students.get(l).cnt < min){
                                min = students.get(l).cnt; //최솟값 구하기
                                // 최솟값의 인덱스
                                index = l;
                            }
                            // 만약 2명 이상인 경우
                            else if(students.get(l).cnt == min){
                                // 더 오래된 학생 구하기
                                if(students.get(l).depth < students.get(index).depth){
                                    index = l;
                                }
                            }
                        }
                        // 빠진 수의 추천 횟수 0으로 업데이트
                        recommendCnt[students.get(index).num] = 0;
                        // 해당 학생 사진틀에서 빼기
                        students.remove(index);
                        // 새로운 학생 추가
                        recommendCnt[number]++;
                        students.add(new Student(number, recommendCnt[number], depth));
                    }
                }
                else{ // 리스트에 존재하면
                    recommendCnt[number]++;
                    for(int l=0; l<students.size(); l++){
                        if(students.get(l).num==number){
                            students.get(l).cnt = recommendCnt[number];
                            break;
                        }
                    }
                }
                // 순서 증가
                depth++;
            }

            // 사진틀에 학생 번호 저장
            int [] pic = new int[students.size()];
            for(int i=0; i<students.size(); i++){
                pic[i] = students.get(i).num;
            }

            // 사진틀 오름차순 출력
            Arrays.sort(pic);
            for(int p : pic){
                System.out.print(p+" ");
            }
        }
    }

    // 학생 클래스
    public static class Student{
        // 학생 번호
        int num;
        // 추천 받은 횟수
        int cnt;
        // 오래된 순
        int depth;

        public Student(int num, int cnt, int depth){
            this.num = num;
            this.cnt = cnt;
            this.depth = depth;
        }
    }
}


