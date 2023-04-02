import java.util.Scanner;
public class test09 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("원의 중심과 반지름 입력>>");
		double a = scan.nextDouble();
		double b = scan.nextDouble();
		double radius = scan.nextDouble();
		
		System.out.print("점 입력>>");
		double x = scan.nextDouble();
		double y = scan.nextDouble();
		
		double len = Math.sqrt((x-a)*(x-a)+(y-b)*(y-b));
		
		if(len<=radius)
			System.out.println("점 ("+x+", "+y+")는 원 안에 있다.");
		else
			System.out.println("점 ("+x+", "+y+")는 원 안에 없다.");
		
		scan.close();
	}

}
