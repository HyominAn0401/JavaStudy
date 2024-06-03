package D2;

import java.util.Scanner;

public class D2_1959 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        int results [] = new int [T];

        for(int t=0; t<T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int A[] = new int[N];
            int B[] = new int[M];
            int s = Math.abs(N - M) + 1;

            for (int a = 0; a < N; a++) {
                A[a] = scanner.nextInt();
            }

            for (int b = 0; b < M; b++) {
                B[b] = scanner.nextInt();
            }

            int result = 0;

            if (N <= M) {
                for (int i = 0; i < s; i++) {
                    int sum = 0;
                    for (int j = 0; j < N; j++) {
                        sum += A[j] * B[i + j];
                    }
                    if (sum > result) result = sum;
                }
            } else {
                for (int i = 0; i < s; i++) {
                    int sum = 0;
                    for (int j = 0; j < M; j++) {
                        sum += A[i + j] * B[j];
                    }
                    if (sum > result) result = sum;
                }
            }
            results[t] = result;
        }
        for(int i=0; i<results.length;i++){
            System.out.println("#"+(i+1)+" "+results[i]);
        }

        scanner.close();
    }
}
