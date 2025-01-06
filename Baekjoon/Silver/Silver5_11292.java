package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver5_11292 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int testCase;
            StringBuilder sb = new StringBuilder();
            while(true){
                testCase = Integer.parseInt(br.readLine());
                if(testCase==0) break;

                ArrayList<Student> students = new ArrayList<>();

                double maxHeight = 0;

                StringTokenizer st;
                for(int i=0; i<testCase; i++){
                    st = new StringTokenizer(br.readLine());
                    String studentName = st.nextToken();
                    double studentHeight = Double.parseDouble(st.nextToken());
                    students.add(new Student(studentName, studentHeight));

                    if (studentHeight > maxHeight) {
                        maxHeight = studentHeight;
                    }
                }

                //Collections.sort(students, (a,b)-> Double.compare(b.getHeight(), a.getHeight()));
                //sb.append(students.get(0).getName()+"\n");
                for (Student student : students) {
                    if (student.getHeight() == maxHeight) {
                        sb.append(student.getName()).append(" ");
                    }
                }
                sb.append("\n");

            }
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

