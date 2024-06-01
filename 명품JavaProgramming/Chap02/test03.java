import java.util.Scanner;
public class test03 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("금액을 입력하시오>>");
		int money = scan.nextInt();
		int m_50000 = money/50000;
		int m_10000 = money%50000/10000;
		int m_1000 = money%50000%10000/1000;
		int m_100 = money%50000%10000%1000/100;
		int m_50 = money%50000%10000%1000%100/50;
		int m_10 = money%50000%10000%1000%100%50/10;
		int m_1 = money%50000%10000%1000%100%50%10;
		
		System.out.println("오만원권 "+m_50000+"매");
		System.out.println("만원권 "+m_10000+"매");
		System.out.println("천원권 "+m_1000+"매");
		System.out.println("백원 "+m_100+"개");
		System.out.println("오십원 "+m_50+"개");
		System.out.println("십원 "+m_10+"개");
		System.out.println("일원 "+m_1+"개");
		
		scan.close();
	}

}
