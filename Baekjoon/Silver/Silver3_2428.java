package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Silver3_2428 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 처리
        int n = scanner.nextInt();
        long[] fileSizes = new long[n];
        for (int i = 0; i < n; i++) {
            fileSizes[i] = scanner.nextLong();
        }

        // 파일 크기 정렬
        Arrays.sort(fileSizes);

        long count = 0;

        // 각 파일에 대해 조건에 맞는 범위 찾기
        for (int i = 0; i < n; i++) {
            long minSize = (long) Math.ceil(fileSizes[i] * 0.9); // 최소 크기 계산

            // 이분 탐색으로 minSize 이상의 첫 인덱스 찾기
            int startIdx = binarySearch(fileSizes, i + 1, n, minSize);
            if (startIdx != -1) {
                count += (n - startIdx); // 검사할 파일 개수 누적
            }
        }

        // 결과 출력
        System.out.println(count);
        scanner.close();
    }

    // 이분 탐색: 조건을 만족하는 첫 인덱스 반환
    private static int binarySearch(long[] arr, int start, int end, long target) {
        int left = start;
        int right = end - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                result = mid;
                right = mid - 1; // 왼쪽을 더 탐색
            } else {
                left = mid + 1; // 오른쪽을 더 탐색
            }
        }

        return result;
    }
}