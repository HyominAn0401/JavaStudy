package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_1969 {
    static int count = 0;
    static int N;
    public static void main(String[] args) throws Exception{
        // 구현 및 해야할 것 : N개 문자열을 입력받고 Hamming Distance 합이 가장 작은 DNA와 그 합을 출력한다
        // 로직 설계
        // 1. N과 M을 입력받고 이차원 배열에 문자로 분해해 저장한다.
        // 2. 문자열의 각 자릿수로 가장 빈도수가 큰 문자를 반환해 sb객체에 저장한다.
        // 3. Hamming Distance 합을 출력한다. 선택된 문자가 아닌 문자의 합을 구한다. 여기선 N에서 가장 빈도수가 큰 문자의 빈도수를 빼는 식으로 계산했다.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // N, M값 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 문자를 저장할 이차원 배열 생성
            char [][] dna = new char[N][M];

            // 이차원 배열에 문자 저장
            for(int i=0; i<N; i++){
                String str = br.readLine();
                dna[i] = str.toCharArray();
            }

            // 결과값을 저장할 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // 문자열의 각 자릿수별 가장 빈도수가 큰 문자 반환
            for(int i=0; i<M; i++){
                // 자릿수별 문자를 저장할 배열
                char [] letter = new char[N];
                // 배열에 저장
                for(int j=0; j<N; j++){
                    letter[j] = dna[j][i];
                }
                // 메서드로 가장 빈도수가 큰 문자를 반환해 sb 객체에 추가
                sb.append(getMajorCharacter(letter));
            }

            // 결과값 출력 : DNA와 Hamming Distance
            System.out.println(sb);
            System.out.println(count);
        }
    }

    // 빈도수가 가장 큰 문자 반환 메서드
    public static char getMajorCharacter(char [] character){
        // A, C, G, T 순서로 빈도수를 저장할 배열
        int [] cnt = new int[4];
        // 문자 배열에서 A, C, G, T 빈도수 계산해 cnt 배열에 누적
        for(int i=0; i<character.length; i++){
            switch (character[i]){
                case 'A': cnt[0]++; break;
                case 'C': cnt[1]++; break;
                case 'G': cnt[2]++; break;
                case 'T': cnt[3]++; break;
            }
        }

        // 빈도수가 가장 큰 문자를 가리키는 인덱스
        int maxIndex = 0;

        // maxIndex 구하기
        for(int i=1; i<cnt.length; i++){
            // 같은 경우 사전순으로 앞서는 것 선택
            if(cnt[i] > cnt[maxIndex])
                maxIndex = i;
        }

        // 가장 큰 빈도수
        int maxValue = Integer.MIN_VALUE;
        // 가장 큰 값 계산
        for(int value : cnt){
            maxValue = Math.max(value, maxValue);
        }

        // Hamming Distance 계산을 위해 N에서 최댓값 빼기
        count += (N-maxValue);

        // 반환할 문자 초기화
        char returnChar = ' ';

        // 인덱스별 문자 반환
        if(maxIndex==0) returnChar= 'A';
        else if(maxIndex==1)    returnChar= 'C';
        else if(maxIndex==2)    returnChar= 'G';
        else if(maxIndex==3)    returnChar= 'T';

        // 반환
        return returnChar;
    }
}
