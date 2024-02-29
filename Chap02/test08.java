package Chap02;

import java.util.Scanner;

public class test08 {

    public static boolean inRect(int x1, int y1, int x2, int y2, int rectx1, int recty1, int rectx2, int recty2){
        if(((x1>=rectx1 && x1<= rectx2) && (y1>=recty1 && y1<=recty2)) || ((x2>=rectx1 && x2<= rectx2) && (y2>=recty1 && y2<=recty2))) {
            return true;
        }
        else return false;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if(inRect(x1, y1, x2, y2, 100, 100, 200, 200))
            System.out.println("충돌합니다.");
        else System.out.println("충돌하지 않습니다.");

        scanner.close();
    }
}
