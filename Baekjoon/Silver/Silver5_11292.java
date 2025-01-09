package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver5_11292 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 각 테스트 케이스 별 가장 키가 큰 학생 이름 출력, 여러 명인 경우 입력 순서대로 출력하기
        // 로직 설계
        // 1. 테스트 케이스 입력받고 0 입력 전까지 학생 이름, 키 입력받기
        // 2. 클래스 배열에 저장, 가장 키가 큰 학생 키 저장, 학생 이름 sb 객체에 저장
        // 3. 해당 키와 같은 키의 학생들이 있는 경우 sb 객체에 이름 저장
        // 4. 출력

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // 테스트 케이스 저장 변수
            int testCase;
            // 결과 저장 StringBuilder 객체
            StringBuilder sb = new StringBuilder();
            // 0 입력 전까지 반복
            while(true){
                // 테스트 케이스 입력받기
                testCase = Integer.parseInt(br.readLine());
                // 0이면 반복문 종료
                if(testCase==0) break;

                // 학생 클래스 ArrayList
                ArrayList<Student> students = new ArrayList<>();

                // 가장 큰 키 저장 변수
                double maxHeight = 0;

                StringTokenizer st;
                // 각 테스트 케이스 별 학생 이름과 키 입력받기
                for(int i=0; i<testCase; i++){
                    st = new StringTokenizer(br.readLine());
                    String studentName = st.nextToken();
                    double studentHeight = Double.parseDouble(st.nextToken());
                    // 추가
                    students.add(new Student(studentName, studentHeight));

                    // 학생 키가 maxHeight 보다 크면 갱신
                    if (studentHeight > maxHeight) {
                        maxHeight = studentHeight;
                    }
                }

                // 학생들 검토
                for (Student student : students) {
                    // 같은 키 학생이 있는 경우
                    if (student.getHeight() == maxHeight) {
                        // 이름 추가
                        sb.append(student.getName()).append(" ");
                    }
                }
                sb.append("\n");

            }
            // 결과값 출력
            System.out.print(sb);
        }
    }

}
class Student{
    private String name;
    private double height;

    public Student(String name, double height){
        this.name = name;
        this.height= height;
    }

    public String getName(){
        return name;
    }

    public double getHeight(){
        return height;
    }
}

