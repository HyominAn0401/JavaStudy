package Kakao.BlindRecruitment2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KakaoBlindRecruitment2022_92341 {
    public static void main(String[] args) throws Exception{
        int [] fees = {180, 5000, 10, 600};
        String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int [] answer = solution(fees, records);
        for(int num : answer){
            System.out.println(num);
        }
    }

    public static int [] solution(int []fees, String[] records){
        int [] answer;
        Map<Integer, Car> carsList = new HashMap<>();

        for(int i=0; i<records.length; i++){
            String [] sp = records[i].split(" ");
            int carNumber = Integer.parseInt(sp[1]);

            if(sp[2].equals("IN")){
                Car car = carsList.getOrDefault(carNumber, new Car(carNumber));
                car.setInTime(sp[0]);
                carsList.put(carNumber, car);
            }
            else if(sp[2].equals("OUT")){
                Car car = carsList.get(carNumber);
                car.setOutTime(sp[0]);
            }
        }

        answer = new int[carsList.size()];

        for(Car car : carsList.values()){
            if (car.getInTime() != null) {
                car.setOutTime("23:59");
            }
            int totalTime = car.getTotalTime();
            int totalFee = fees[1];
            if(totalTime > fees[0]){
                totalFee += Math.ceil((double)(totalTime - fees[0]) / fees[2]) * fees[3];
            }

            car.setTotalFee(totalFee);
        }

        ArrayList<Car> sort = new ArrayList<>(carsList.values());

        sort.sort((c1, c2) -> Integer.compare(c1.getCarNumber(), c2.getCarNumber()));

        for (int i = 0; i < sort.size(); i++) {
            answer[i] = sort.get(i).getTotalFee();
        }
        return answer;
    }
}
class Car{
    private int carNumber;
    private String inTime;
    private String outTime = "23:59";
    private int totalFee = 0;
    private int totalTime = 0;

    public Car(int carNumber){
        this.carNumber = carNumber;
    }

    public void setInTime(String inTime){
        this.inTime = inTime;
    }

    public void setOutTime(String outTime){
        this.outTime = outTime;
        String [] in = this.inTime.split(":");
        String [] out = this.outTime.split(":");
        int inMin = Integer.parseInt(in[0])*60 + Integer.parseInt(in[1]);
        int outMin = Integer.parseInt(out[0])*60 + Integer.parseInt(out[1]);
        this.totalTime += (outMin-inMin);
        this.inTime = null;
    }

    public int getCarNumber(){
        return carNumber;
    }

    public String getInTime() {
        return inTime;
    }

    public String getOutTime(){
        return outTime;
    }

    public void setTotalFee(int totalFee){
        this.totalFee = totalFee;
    }

    public int getTotalFee(){
        return totalFee;
    }

    public int getTotalTime(){
        return totalTime;
    }
}
