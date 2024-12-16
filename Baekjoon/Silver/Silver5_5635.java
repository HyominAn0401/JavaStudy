package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Silver5_5635 {
    static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 이름과 생일을 입력받고 가장 어린 사람과 가장 나이가 많은 사람 출력하기
        // 로직 설계
        // 1. n번 이름과 생일 입력 받기
        // 2. StringBuilder 객체에 연도+월+일 추가
        // 2-1. 월과 일이 10보다 작으면 0을 붙여서 추가하기
        // 3. ArrayList에 Student 객체로 추가
        // 4. 생일을 기준으로 오름차순 정렬해 가장 앞 객체의 이름과 마지막 객체의 이름 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 학생 수 입력받기
            int n = Integer.parseInt(br.readLine());

            // n번 반복
            for(int i=0; i<n; i++){
                // 학생 이름, 일, 월, 연도 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                String studentName = st.nextToken();
                int day = Integer.parseInt(st.nextToken());
                int month = Integer.parseInt(st.nextToken());
                int year = Integer.parseInt(st.nextToken());

                // 생일을 저장할 StringBuilder 객체
                StringBuilder sb= new StringBuilder();
                sb.append(year);
                // 10보다 작은 경우 0 붙여서 추가
                if(month<10)    sb.append("0"+month);
                else    sb.append(month);

                if(day<10)  sb.append("0"+day);
                else sb.append(day);

                // ArrayList에 Student 객체로 추가
                students.add(new Student(studentName, Integer.parseInt(sb.toString())));
            }

            // 생일 기준 오름차순 정렬
            students.sort(Comparator.comparingInt(student -> student.birthday));
            // 가장 어린 사람, 가장 나이 많은 사람 이름 출력
            System.out.println(students.get(n-1).name);
            System.out.println(students.get(0).name);
        }
    }

    // Student 클래스
    static class Student{
        // 이름, 생일 필드
        String name;
        int birthday;

        public Student(String name, int birthday){
            this.name = name;
            this.birthday = birthday;
        }
    }
}
