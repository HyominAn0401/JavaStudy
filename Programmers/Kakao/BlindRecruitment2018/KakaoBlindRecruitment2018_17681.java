package Kakao.BlindRecruitment2018;

public class KakaoBlindRecruitment2018_17681 {
    static int [][] newArr1;
    static int [][] newArr2;
    public static void main(String[] args) throws Exception{
        int n = 5;
        int [] arr1 = {9, 20, 28, 18, 11};
        int [] arr2 = {30, 1, 21, 17, 28};
        String [] answer = solution(n, arr1, arr2);
        for(int i=0; i<n; i++){
            System.out.println(answer[i]);
        }
    }

    public static String[] solution(int n, int []arr1, int [] arr2){
        String [] answer = new String[n];
        newArr1 = new int[n][n];
        newArr2 = new int[n][n];
        toBinary(arr1, newArr1);
        toBinary(arr2, newArr2);

        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(newArr1[i][j]==0 && newArr2[i][j]==0)
                    sb.append(" ");
                else sb.append("#");
            }
            answer[i] = sb.toString();
        }

//        for(int i=0; i<n; i++){
//            int val = arr1[i] | arr2[i];
//            String binary = String.format("%"+n+"s", Integer.toBinaryString(val));
//            binary = binary.replace('1', '#').replace('0', ' ');
//            answer[i] = binary;
//        }

        return answer;
    }

    public static void toBinary(int [] arr, int [][] newArr){
        for(int i=0; i<arr.length; i++){
            int [] num = new int[arr.length];
            int cnt = arr.length-1;
            while(arr[i]>=2){
                num[cnt] = arr[i]%2;
                arr[i] /= 2;
                cnt -=1;
            }
            num[cnt] = arr[i];
            newArr[i] = num;
        }
    }
}
