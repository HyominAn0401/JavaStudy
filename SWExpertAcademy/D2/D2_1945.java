package D2;

import java.util.Scanner;

public class D_1945 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //TEST
        int T = scanner.nextInt();
        //numbers
        int num[] = new int [T];
        int fact[][] = new int [T][5];

        //get numbers
        for(int count = 0; count<T; count++){
            num[count] = scanner.nextInt();
        }

        //initialize
        for(int height=0;height<fact.length;height++){
            for(int width=0;width<fact[0].length;width++){
                fact[height][width] = 0;
            }
        }

        for(int i = 0; i<fact.length; i++){
            int N = num[i];
            while(true){
                if(N==1) break;
                else if(N%2==0){
                    fact[i][0]++;
                    N /= 2;
                }
                else if(N%3==0){
                    fact[i][1]++;
                    N /= 3;
                }
                else if(N%5==0){
                    fact[i][2]++;
                    N /= 5;
                }
                else if(N%7==0){
                    fact[i][3]++;
                    N /= 7;
                }
                else if(N%11==0){
                    fact[i][4]++;
                    N /= 11;
                }
                else break;
            }
        }

        for(int height=0; height<fact.length; height++){
            System.out.print("#"+(height+1)+" ");
            for(int width=0; width<fact[0].length; width++){
                System.out.print(fact[height][width]+" ");
            }
            System.out.println();
        }

        scanner.close();

//        Scanner scanner = new Scanner(System.in);
//
//        //소인수분해할 숫자
//        int N = scanner.nextInt();
//
//        int n_2 = 0, n_3 = 0, n_5 = 0, n_7 = 0, n_11 = 0;
//        int result = 0;
//        while(true){
//            if(N==1) break;
//            else if (N % 2 == 0) {
//                n_2++;
//                N = N /2;
//            }
//            else if (N % 3 == 0) {n_3++; N = N/3;}
//            else if (N % 5 == 0) {n_5++; N = N/5;}
//            else if (N % 7 == 0)    {n_7++;  N = N/7;}
//            else if (N%11==0)   {n_11++;    N = N/11;}
//            //N=13?
//            else{
//                break;
//            }
//        }
//
//        System.out.println(n_2 + " "+n_3 + " "+ n_5+" "+n_7+" "+n_11);
//
//        scanner.close();
    }
}
