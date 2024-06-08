package D1;

import java.util.Scanner;

public class D1_2056 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        // 개행문자 필요
        scanner.nextLine();
        String [] dates = new String[testCase];

        for(int i=0; i<testCase; i++){
            String dateStr = scanner.nextLine();
            String yearStr = dateStr.substring(0,4);
            String monthStr = dateStr.substring(4,6);
            String dayStr = dateStr.substring(6,8);
            //int month = Integer.parseInt(monthStr);
            int day = Integer.parseInt(dayStr);
            boolean rightDate = true;

            switch (monthStr){
                case "01": case "03": case "05": case "07": case "08": case "10": case "12":
                    if (day>31)     rightDate = false;
                    break;
                case "02":
                    if(day>28)      rightDate = false;
                    break;
                case "04": case "06": case "09": case "11":
                    if(day>30)      rightDate = false;
                    break;
                default:
                    rightDate = false;
                    break;
            }

            if(rightDate)
                dates[i] = yearStr+"/"+monthStr+"/"+dayStr;
            else dates[i] = "-1";
        }

        for(int i=0; i<testCase; i++){
            System.out.println("#"+(i+1)+" "+dates[i]);
        }

        scanner.close();
    }
}
