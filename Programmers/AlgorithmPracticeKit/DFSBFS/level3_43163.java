package AlgorithmPracticeKit.DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class level3_43163 {
    static ArrayList<String>[] wordList;
    static boolean [] used;
    static int [] dist;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String [] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.print(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words){
        // target이 words 안에 없을 때 -> 종료
        int cnt = 0;
        int targetIndex = -1;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                cnt++;
                targetIndex = i+1;
            }
        }
        if (cnt==0) return 0;

        // 존재하는 경우
        // begin 추가해서 새로운 list 생성
        String[] newWords = new String[words.length+1];
        newWords[0] = begin;
        for(int i=1; i<newWords.length; i++){
            newWords[i] = words[i-1];
        }

        int len = newWords.length;
        wordList = new ArrayList[len];
        used = new boolean[len];
        dist = new int[len];
        Arrays.fill(dist, -1);

        for(int i=0; i<len; i++){
            wordList[i]= new ArrayList<>();
        }

        for(int i=0; i<newWords.length; i++){
            char [] w = newWords[i].toCharArray();
            for(int j=0; j<newWords.length; j++){
                char [] w1 = newWords[j].toCharArray();
                int count = 0;
                for(int k=0; k<w.length; k++){
                    if(w[k]==w1[k])
                        count++;
                }
                if(count==w.length-1 && !wordList[i].contains(newWords[j])){
                    wordList[i].add(newWords[j]);
                }
            }
        }

        int answer = BFS(begin, newWords, targetIndex);

        return answer;
    }

    public static int BFS(String begin, String[] words, int targetIndex){
        Queue<String> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
//        int counts = 0;
        queue.add(begin);
        used[0] = true;
        dist[0] = 0;

        while(!queue.isEmpty()){
            String str = queue.poll();
            sb.append(str+" ");

            int idx = findIndex(str, words);

            for(String s : wordList[idx]){
                int wordIndex = findIndex(s, words);
                if(!used[wordIndex]){
                    used[wordIndex] = true;
                    dist[wordIndex] = dist[idx]+1;
                    if(wordIndex == targetIndex)
                        return dist[wordIndex];
                    queue.add(s);
                }
            }
        }

        //for(String s : sb.toString().split(" "))
        System.out.println(sb.toString());

        return 0;

    }

    public static int findIndex(String str, String[] words){
        for(int i=0; i<words.length; i++){
            if(words[i].equals(str))
                return i;
        }
        return -1;
    }
}
