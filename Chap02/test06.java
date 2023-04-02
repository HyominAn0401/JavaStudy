import java.util.Scanner;

public class test06 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점(x,y)의 좌표를 입력하시오>>");
		int x = scan.nextInt();
		int y = scan.nextInt();
		boolean isThere;
		
		if(x>=100 && x<=200) {
			if(y<=200 && y>=100)
				isThere = true;
			else
				isThere = false;
		}
		else
			isThere = false;
		
		if(isThere)
			System.out.println("("+x+","+y+")는 사각형 안에 있습니다.");
		else
			System.out.println("("+x+","+y+")는 사각형 안에 없습니다.");
	}

}
