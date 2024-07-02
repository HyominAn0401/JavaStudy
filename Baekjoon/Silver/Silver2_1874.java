package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver2_1874 {

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int number = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<Integer>();
            int [] array = new int[number];
            char [] result = new char[number*2];
            //boolean possible = false;

            for(int i=0; i<number; i++){
                array[i] = Integer.parseInt(br.readLine());
            }

            int cnt = 1;
            int arrayCnt = 0;
            int resultCnt = 0;

            while(arrayCnt < number){
                if(stack.isEmpty()) {
                    stack.push(cnt);
                    result[resultCnt]='+';
                    resultCnt++;
                }

                if(array[arrayCnt] > stack.peek()) {
                    cnt++;
                    stack.push(cnt);
                    result[resultCnt]='+';
                    resultCnt++;
                }
                else if(array[arrayCnt] == stack.peek())    {
                    arrayCnt++;
                    stack.pop();
                    result[resultCnt]='-';
                    resultCnt++;
                }
                else if(array[arrayCnt] < stack.peek()){
                    System.out.println("No");
                    return;
                }
            }
            for(int i=0; i<resultCnt; i++){
                System.out.println(result[i]);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
