package level0;

public class level0_0309 {
    public static void main(String[] args) throws Exception{
        solution(580000);
    }

    public static int solution(int price){
        int answer = 0;
        int sale = 0;
        if(price>=500000)
            sale = 20;
        else if(price>=300000)
            sale = 10;
        else if(price>=100000)
            sale = 5;

        answer = price*(100-sale)/100;
        return answer;
    }
}
