package Kakao.DevelopmentWinterInternship2019;

import java.util.Stack;

public class KakaoWinterIntern_64061 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int [] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int [] moves){
        Stack<Integer> stack = new Stack<>();
        int answer=0;

        for(int next : moves){
            int i =0;
            while(i < board.length && board[i][next - 1] == 0){
                i++;
            }
            if(i==board.length)
                continue;

            int num = board[i][next-1];
            board[i][next-1] = 0;

            if(!stack.isEmpty() && stack.peek() == num){
                stack.pop();
                answer+=2;
            }
            else{
                stack.push(num);
            }


        }
        return answer;
    }
}
