package D2;

import java.util.Scanner;

public class D2_1926 {

    public static void main(String[] args) {

        // 구현 및 해야할 것 : 숫자를 입력받고 1부터 숫자까지 입력하되 3, 6, 9가 포함된 횟수만큼 - 으로 출력한다
        // 로직 설계
        // 1. 숫자를 입력받는다
        // 2. 숫자 크기의 배열을 생성하고 입력받은 숫자의 자릿값을 구한다
        // 3. 배열에 1부터 숫자를 넣고 3, 6, 9가 들어가는 횟수 만큼 - 을 대신 넣는다
        // 4. 숫자를 출력한다.

        Scanner scanner = new Scanner(System.in);

        // 숫자 입력받기
        int N = scanner.nextInt();
        // 숫자 크기의 배열 생성, 1부터 입력받는 숫자까지 문자열 형식으로 담는 배열
        String [] number = new String[N];
        // 숫자의 자릿수 구하기
        int digit = Integer.toString(N).length();

        // 1부터 숫자까지 반복문 구현
        for(int i=1; i<=N; i++){
            // 3, 6, 9 나오는 횟수를 위한 변수
            int count = 0;

            // 배열에 숫자값 넣기
            number[i-1] = Integer.toString(i);

            // 한 자리 수인 경우
            if(digit==1){
                // 3, 6, 9 이면 배열에 "-" 넣기
                if(i%10==3 || i%10==6 || i%10==9){
                    count += 1;
                }
            }
            // 두 자리 수인 경우
            else if(digit==2){
                // 십의 자리가 3, 6, 9인 경우
                if(i/10==3||i/10==6||i/10==9){
                    // 일의 자리도 3, 6, 9인 경우
                    if(i%10==3||i%10==6||i%10==9)
                        // 3, 6, 9가 두 번
                        count += 2;
                    // 일의 자리는 3, 6, 9가 아닌 경우 1번
                    else    count += 1;
                }
                // 십의 자리가 3, 6, 9가 아닌 경우
                else if(i/10!=3||i/10!=6||i/10!=9){
                    // 일의 자리는 3, 6, 9인 경우
                    if(i%10==3||i%10==6||i%10==9)
                        // 2번
                        count += 1;
                }
            }
            // 세 자리 수인 경우
            else if(digit==3){
                // 백의 자리가 3, 6, 9인 경우
                if(i/100==3||i/100==6||i/100==9){
                    // 십의 자리도 3, 6, 9인 경우
                    if(i%100/10==3||i%100/10==6||i%100/10==9){
                        // 일의 자리도 3, 6, 9인 경우
                        if(i%100%10==3||i%100%10==6||i%100%10==9){
                            // 3번
                            count += 3;
                        }
                        // 일의 자리는 아닌 경우 2번
                        else count += 2;
                    }
                    // 십의 자리가 3, 6, 9가 아닌 경우
                    else{
                        // 일의 자리가 3, 6, 9인 경우 2번
                        if(i%100%10==3||i%100%10==6||i%100%10==9)   count += 2;
                        // 일의 자리는 아닌 경우 1번
                        else    count += 1;
                    }
                }
                // 백의 자리가 3, 6, 9가 아닌 경우
                else{
                    // 십의 자리가 3, 6, 9인 경우
                    if(i%100/10==3||i%100/10==6||i%100/10==9){
                        // 일의 자리도 3, 6, 9인 경우 2번
                        if(i%100%10==3||i%100%10==6||i%100%10==9)   count += 2;
                        // 일의 자리는 아닌 경우 1번
                        else    count += 1;
                    }
                    // 십의 자리가 3, 6, 9가 아닌 경우
                    else{
                        // 일의 자리가 3, 6, 9 인 경우
                        if(i%100%10==3||i%100%10==6||i%100%10==9)   count += 1;
                    }
                }
            }

            // count 값 횟수에 따른 배열 값 변경
            if(count==1)   number[i-1] = "-";
            else if(count==2)   number[i-1] = "--";
            else if(count==3)   number[i-1] = "---";

        }

        // 배열 값 출력하는 반복문
        for(int i=0; i<N;i++){
            System.out.print(number[i]+" ");
        }

        scanner.close();

//        Scanner scanner = new Scanner(System.in);
//
//        int N = scanner.nextInt();
//
//        String numberStr = Integer.toString(N);
//        // 자릿수
//        int digit = numberStr.length();
//        // 입력값 크기만큼의 배열
//        char [] number = new char [N];
//
//        for(int i=1; i<=N;i++){
//            number[i-1] = (char)i;
//
//            switch (digit){
//                case 1:
//                    if(number[i-1]==3 || number[i-1]==6 || number[i-1]==9){
//                        number[i-1]='-';
//                    }
//                case 2:
//                    int digit_10 = number[i-1]/10;
//                    int digit_1 = number[i-1]%10;
//                    if((digit_10==3||digit_10==6||digit_10==9)&&(digit_1==3||digit_1==6||digit_1==9)){
//                        number[i-1]=='--';
//                    }
//                    else if((digit_10==3||digit_10==6||digit_10==9)&&(digit_1!=3||digit_1!=6||digit_1!=9))
//            }
//        }
//
//

    }
}
