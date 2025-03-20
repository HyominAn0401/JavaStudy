package Kakao.BlindRecruitment2018;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KakaoBlindRecruitment2018_17680 {
    public static void main(String[] args) throws Exception{
        int cacheSize = 2;
        String [] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities){
        int pointer = 0;
        if(cacheSize==0){
            return cities.length*5;
        }

        //String [] cache = new String[cacheSize];
        List<String> cache = new ArrayList<>();
//        for(int i=0; i<cacheSize; i++){
//            cache[i] = "";
//        }
        int time = 0;

        for(String city : cities){
            city = city.toLowerCase();

            if(cache.contains(city)){
                cache.remove(city);
                time += 1;
            }
            else{
                if(cache.size() == cacheSize){
                    cache.remove(0);
                }
                time += 5;
            }
            cache.add(city);
//            if(!isInArray(cache, city)){
//                cache[pointer] = city;
//                time += 5;
//                pointer = (pointer+1)%cacheSize;
//            }
//            else{
//                time += 1;
//            }
        }

        return time;
    }

    public static boolean isInArray(String[] cache, String city){
        for(String c : cache){
            if(!c.isEmpty() && c.equals(city))
                return true;
        }
        return false;
    }
}
