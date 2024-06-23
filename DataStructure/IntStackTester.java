package DataStructure;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){
            // 64개 푸시할 수 있는 스택
            IntStack s = new IntStack(64);

            while(true){
                System.out.println();
                System.out.printf("현재 데이터 개수 : %d / %d\n", s.size(), s.getCapacity());
                System.out.print("(1) Push  (2) Pop  (3) Peek  (4) Dump  (5) Delete  (6) Find Index  (0) Quit : ");

                int menu = scanner.nextInt();
                if(menu==0) break;

                int x;
                int index;
                switch(menu){
                    case 1: //push
                        System.out.print("데이터: ");
                        x = scanner.nextInt();
                        try{
                            s.push(x);
                        } catch(IntStack.OverflowIntStackException e){
                            System.out.println("Stack is full");
                        }
                        break;
                    case 2: //pop
                        try{
                            x = s.pop();
                            System.out.println("Pop data is "+x);
                        } catch (IntStack.EmptyIntStackException e){
                            System.out.println("Stack is Empty");
                        }
                        break;
                    case 3: // peek
                        try{
                            x = s.peek();
                            System.out.println("Peek data is "+x);
                        }catch (IntStack.EmptyIntStackException e){
                            System.out.println("Stack is Empty");
                        }
                        break;
                    case 4: //dump
                        s.dump();
                        break;
                    case 5:
                        s.clear();
                        break;
                    case 6:
                        System.out.print("Data : ");
                        x = scanner.nextInt();
                        try{
                            index = s.indexOf(x);
                            System.out.println("Index is "+index);
                        }catch (NoSuchElementException e){
                            System.out.println("Not Found");
                        }
                        break;
                }
            }
        }
    }
}
