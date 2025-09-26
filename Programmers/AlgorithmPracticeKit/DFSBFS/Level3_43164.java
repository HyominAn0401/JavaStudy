package AlgorithmPracticeKit.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Level3_43164 {
    static boolean [] visited;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String [][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
            String [] answer = solution(tickets);
            for(String a : answer){
                System.out.print(a+" ");
            }
        }
    }

    public static String[] solution(String[][] tickets){
        visited = new boolean[tickets.length];
        DFS(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        return answer;
    }

    public static void DFS(int cnt, String airport, String word, String[][] tickets){
        if(cnt==tickets.length){
            list.add(word);
        }
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(airport)){
                visited[i] = true;
                DFS(cnt+1, tickets[i][1], word+" "+tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }

//    public static String[] solution(String[][] tickets){
//        // 1. List에 없으면 City, num 추가 => index와 도시를 연결지어 보기 위한 list임
//        List<String> cityNames = new ArrayList<>();
//        for(int i=0; i<tickets.length; i++){
//            for(int j=0; j<tickets[0].length; j++){
//                String name = tickets[i][j];
//                if(!cityNames.contains(name)){
//                    cityNames.add(name);
//                }
//            }
//        }
//        flights = new ArrayList[cityNames.size()];
//        List<City> cities = new ArrayList<>();
//        // City 추가
//        for(int i=0; i<cityNames.size(); i++){
//            cities.add(new City(cityNames.get(i), i));
//        }
//
//        // 2. ArrayList 초기화
//        for(int i=0; i<flights.length; i++){
//            flights[i] = new ArrayList<>();
//        }
//
//        for(int i=0; i<tickets.length; i++){
//            String depart = tickets[i][0];
//            String arrive = tickets[i][1];
//            flights[findCityNo(cities, depart)].add(new City(arrive, findCityNo(cities, arrive)));
//        }
//
//        answer = new String[tickets.length+1];
//        answer[0] = "ICN";
//
//        visited = new boolean[cities.size()];
//
//        dfs(0, 0, cities);
//
//        for(int i=1; i<cities.size(); i++){
//            answer[i] = answerList.get(i-1);
//        }
//        return answer;
//    }
//
//    // 번호 찾기
//    public static int findCityNo(List<City> cities, String cityName){
//        for(City city : cities){
//            if(city.cityName.equals(cityName)){
//                return city.number;
//            }
//        }
//        return -1;
//    }
//
//    public static void dfs(int depth, int number, List<City> cities){
//        if(depth==ticket){
//            return;
//        }
//
//        for(City city : flights[number]){
//            int num = city.number;
//            String cityName = city.cityName;
//            if(visited[num])    continue;
//            visited[num] = true;
//            answerList.add(cityName);
//            dfs(depth+1, num, cities);
//            answerList.remove(answerList.size()-1);
//            visited[num] = false;
//        }
//    }
//
//    public static class City{
//        private String cityName;
//        private int number;
//
//        public City(String cityName, int number){
//            this.cityName = cityName;
//            this.number = number;
//        }
//    }
}
