package level1;

import java.util.Arrays;

public class level1_42748 {
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : 배열에서 i-j번재 숫자를 자르고 정렬 후 k번째 수를 저장한 배열 반환
        // 로직 설계
        // 1. 반복 횟수 구하기
        // 2. 횟수만큼 반복해 i~j까지 자르고 정렬해 result 배열에 k번째 수 저장하고 반환하기

        int [] array = {1,5,2,6,3,7,4};
        int [][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        solution(array, commands);
        for(int num : solution(array, commands))
            System.out.print(num+" ");
    }

    public static int [] solution(int[] array, int[][] commands){
        // 반복할 횟수
        int count = commands.length;
        // 결과를 저장할 배열 초기화
        int [] result = new int[count];

        // 반복하면서 k번째 수 구하기
        for(int l=0; l<count; l++){
            // i, j, k값
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];

            // 자른 배열 내 숫자의 개수
            int size = j-i+1;
            // 새로운 배열 초기화
            int [] newArray = new int[size];

            // 새로운 배열에 값 저장
            int cnt = 0;
            for(int m=i-1; m<j; m++){
                newArray[cnt] = array[m];
                cnt++;
            }

            // 새로운 배열 정렬
            Arrays.sort(newArray);
            // 결과배열에 k번째 수 저장
            result[l] = newArray[k-1];
        }
        // 반환
        return result;
    }
}
