package Kakao.BlindRecruitment2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KakaoBlindRecruitment2022_92341_20250325 {
    public static void main(String[] args) throws Exception{
        int [] fees = {180, 5000, 10, 600};
        String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int [] answer = solution(fees, records);
        for(int num : answer){
            System.out.println(num);
        }
    }

    public static int [] solution(int[] fees, String[] records){
        Map<Integer, Car> carMap = new HashMap<>();
        for(int i=0; i<records.length; i++){
            String[] rec = records[i].split(" ");
            int carNum = Integer.parseInt(rec[1]);
            if(rec[2].equals("IN")){
                Car car = carMap.getOrDefault(carNum, new Car(carNum));
                car.setInTime(rec[0]);
                carMap.put(carNum, car);
            }
            else if(rec[2].equals("OUT")){
                Car car = carMap.get(carNum);
                car.setOutTime(rec[0]);
            }
        }

        for(Car car : carMap.values()){
            int totalTime = car.getTotalTime();
            int totalFee = fees[1];
            if(totalTime > fees[0]){
                totalFee += Math.ceil((double)(totalTime - fees[0]) / fees[2]) * fees[3];
            }
            car.setTotalFee(totalFee);
        }

        List<Car> sortedCars = new ArrayList<>(carMap.values());
        sortedCars.sort((a,b)-> Integer.compare(a.carNumber, b.carNumber));
        int [] answer = new int[carMap.size()];
        for(int i=0; i<sortedCars.size(); i++){
            answer[i] = sortedCars.get(i).getTotalFee();
        }
        return answer;
    }

    public static class Car{
        int carNumber;
        int totalFee=0;
        int totalTime =0;
        String inTime;
        String outTime="23:59";

        public Car(int carNumber){
            this.carNumber = carNumber;
        }

        public int getTotalTime(){
            return totalTime;
        }

        public int getTotalFee(){
            return totalFee;
        }

        public void setInTime(String inTime){
            this.inTime = inTime;
        }

        public void setOutTime(String outTime){
            this.outTime = outTime;
            checkTotalTime();
            // 출차했으니 입차 시간 초기화
            this.inTime = null;
        }

        public void setTotalFee(int totalFee){
            this.totalFee = totalFee;
        }

        public int checkTotalTime(){
            String[] in_time = inTime.split(":");
            int in = 60*Integer.parseInt(in_time[0]) + Integer.parseInt(in_time[1]);
            String[] out_time = outTime.split(":");
            int out = 60 * Integer.parseInt(out_time[0]) + Integer.parseInt(out_time[1]);
            totalTime = out - in;
            return totalTime;
        }
    }
}
