package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D3_5431 {
    public static void main(String[] args) {
        // 구현 및 해야할 것 : 학생 수 및 제출한 학생 수와 번호를 입력받고 제출하지 않은 학생 번호 출력하기
        // 로직 설계
        // 1. 전체 학생 수, 제출한 학생 수, 제출한 학생 번호 입력받기
        // 2. 제출, 미제출 학생을 가리기 위한 boolean 배열 생성하기
        // 3. 제출한 경우 boolean 값 true로 갱신
        // 4. 각 테스트 케이스 별 boolean 값이 false인 번호 출력하기

        // try-with-resources로 Scanner 인스턴스 관리
        try(Scanner scanner = new Scanner(System.in)){

            // 테스트 케이스 입력받기
            int testCase = scanner.nextInt();
            // 결과값을 저장할 results 배열 생성
            String [] results = new String[testCase];

            // 테스트 케이스만큼 반복
            for(int t=0; t<testCase; t++){

                // StringBuilder 생성
                StringBuilder sb = new StringBuilder();

                // 전체 학생 수와 제출한 학생 수 입력받기
                int students = scanner.nextInt();
                int submits = scanner.nextInt();

                // 전체 학생 수 + 1 크기의 boolean 배열 생성
                boolean [] bool = new boolean[students+1];

                // 제출한 학생 번호를 받아 boolean 값 갱신
                for(int i=0; i<submits; i++){
                    bool[scanner.nextInt()] = true;
                }

                // 값이 false인 경우 sb에 번호 추가하기
                for(int i=1; i<students+1; i++){
                    if(!bool[i])
                        sb.append(i).append(" ");
                }
                // 배열에 값 저장하기
                results[t] = sb.toString();
            }

            // 테스트 케이스 별 결과값 출력
            for(int t=0; t<testCase; t++){
                System.out.println("#"+(t+1)+" "+results[t]);
            }
        }

//        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int students = Integer.parseInt(st.nextToken());
//            int submits = Integer.parseInt(st.nextToken());
//
//            boolean [] bool = new boolean[students+1];
//
//            for(int i=0; i<submits; i++){
//                st = new StringTokenizer(br.read());
//                int x = Integer.parseInt(st.nextToken());
//                bool[x] = true;
//            }
//
//            for(int i=1; i<students+1; i++){
//                System.out.println(bool[i]);
//            }

//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int testCase = Integer.parseInt(st.nextToken());
//            //StringBuilder sb = new StringBuilder();
//            int [][] results = new int[testCase][];
//
//            for(int t=0; t<testCase; t++){
//                st = new StringTokenizer(br.readLine());
//                int students = Integer.parseInt(st.nextToken());
//                int submits = Integer.parseInt(st.nextToken());
//
//                boolean [] booleans = new boolean[students+1];
//
//                for(int i=0; i<submits; i++){
//                    st = new StringTokenizer(br.readLine());
//                    int x = Integer.parseInt(st.nextToken());
//                    booleans[x] = true;
//                }
//
//                for(int i=0; i<students+1; i++){
//                    System.out.println(booleans[i]);
//                }
//
//                for(int i=1; i<=students; i++){
//                    if(!booleans[i])
//                        //results[testCase][]
//                        System.out.println(i);
//                }
//            }

//        } catch (IOException e){
//            e.printStackTrace();
//        }
    }

//    public static void main(String[] args) {
//
//        try(Scanner scanner = new Scanner(System.in)){
//            int students = scanner.nextInt();
//            int submitStudents = scanner.nextInt();
//
//            int [] studentsArray = new int[submitStudents];
//            Queue<Integer> queue = new LinkedList<Integer>();
//
//            for(int i=1; i<=students; i++){
//                queue.add(i);
//            }
//
//            for(int i=0; i<submitStudents; i++){
//                studentsArray[i] = scanner.nextInt();
//            }
//
//            for(int i=0; i<submitStudents; i++){
//                if(studentsArray[i] == queue.peek()){
//                    queue.poll();
//                }
//                else{
//                    queue.add(queue.poll());
//                }
//            }
//
//            System.out.println(queue.size());
////            for(int value : queue){
////                System.out.print(value+" ");
////            }
//        }
//    }
}
