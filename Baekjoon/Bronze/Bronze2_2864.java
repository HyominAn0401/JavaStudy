package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze2_2864 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String strA = st.nextToken();
            String strB = st.nextToken();

            long maxValue_A=0, minValue_A=0;
            long maxValue_B=0, minValue_B=0;
            StringBuilder A = new StringBuilder();
            StringBuilder B = new StringBuilder();

            int [] numA = new int[strA.length()];
            int [] numB = new int[strB.length()];

            // A의 최솟값
            for(int i=0; i<strA.length(); i++){
                numA[i] = strA.charAt(i)-'0';
                if(numA[i]==6){
                    // 최소값
                    numA[i] = 5;
                }
                A.append(numA[i]);
            }
            minValue_A = Long.parseLong(A.toString());
            A.setLength(0);

            // 최대값
            for(int i=0; i<strA.length(); i++){
                numA[i] = strA.charAt(i)-'0';
                if(numA[i]==5){
                    numA[i] = 6;
                }
                A.append(numA[i]);
            }
            maxValue_A = Long.parseLong(A.toString());

            // B의 최솟값
            for(int i=0; i<strB.length(); i++){
                numB[i] = strB.charAt(i)-'0';
                if(numB[i]==6){
                    // 최소값
                    numB[i] = 5;
                }
                B.append(numB[i]);
            }
            minValue_B = Long.parseLong(B.toString());
            B.setLength(0);

            // 최대값
            for(int i=0; i<strB.length(); i++){
                numB[i] = strB.charAt(i)-'0';
                if(numB[i]==5){
                    numB[i] = 6;
                }
                B.append(numB[i]);
            }
            maxValue_B = Long.parseLong(B.toString());

            System.out.println((minValue_A+minValue_B)+" "+(maxValue_B+maxValue_A));
        }
    }
}
