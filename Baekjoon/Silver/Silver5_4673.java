package Silver;

public class Silver5_4673 {
    public static void main(String[] args) throws Exception{

        boolean [] isGenerated = new boolean[10001];
        for(int i=1; i<=10000; i++){
            int n = i;
            int sum = n;

            while(n!=0){
                sum += n%10;
                n /= 10;
            }

            if(sum<=10000)
                isGenerated[sum] = true;
        }
        for(int i=1; i<=10000; i++){
            if(!isGenerated[i])
                System.out.println(i);
        }

//        boolean [] isIn = new boolean[10002];
//
//        for(int i=1; i<=10001; i++){
//            int number = 0;
//            int length = String.valueOf(i).length();
//            switch (length){
//                case 1:
//                    number = i+i;
//                    break;
//                case 2:
//                    number =  i+(i/10)+(i%10);
//                    break;
//                case 3:
//                    number = i+(i/100)+(i%100/10)+(i%100%10);
//                    break;
//                case 4:
//                    number = i+i/1000+i%1000/100+i%1000%100/10+i%1000%100%10;
//                    break;
//                case 5:
//                    number = 10001;
//                    break;
//            }
//            if(number<=10001 && !isIn[number])
//                isIn[number] = true;
//        }
//
//        for(int i=1; i<=10001; i++){
//            if(!isIn[i])
//                System.out.println(i);
//        }

    }
}
