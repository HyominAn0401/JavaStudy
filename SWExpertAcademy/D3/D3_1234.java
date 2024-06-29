package D3;

import java.util.Scanner;
import java.util.Stack;

public class D3_1234 {

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {
            int [][] results = new int[10][];

            for (int testCase = 0; testCase < 10; testCase++) {
                int capacity = scanner.nextInt();
                String numbers = scanner.next();

                //System.out.println(capacity + " " + numbers);

                Stack<Integer> stack = new Stack<>();

                for (int i = 0; i < capacity; i++) {
                    int x = Integer.parseInt(String.valueOf(numbers.charAt(i)));

                    if (!stack.isEmpty() && stack.peek() == x) {
                        stack.pop();
                        //System.out.println("pop함");
                    } else {
                        stack.push(x);
                        //System.out.println(x+"를 push함");
                    }
                }

                int size = stack.size();
                int[] stk = new int[size];
                //System.out.println("스택에 담긴 원소 수: " + stack.size());
//            for(int i=0; i<stack.size(); i++){
//                System.out.println(stack.pop());
//            }

                int cnt = 0;
                while (!stack.isEmpty()) {
                    stk[cnt] = stack.pop();
                    cnt++;
                }

                int [] reverse = new int[stk.length];

                for(int i=0; i<stk.length; i++){
                    reverse[i] = stk[stk.length-1-i];
                }

                results[testCase] = reverse;
            }

            for(int testCase=0; testCase<10; testCase++){
                System.out.print("#"+(testCase+1)+" ");
                for(int i=0; i<results[testCase].length;i++){
                    System.out.print(results[testCase][i]);
                }
                System.out.println();
            }
        }
    }
}
