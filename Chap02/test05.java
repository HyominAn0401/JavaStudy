import java.util.Scanner;
public class test05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("1~99 사이의 정수를 입력하시오>>");
		int num = scan.nextInt();
		
		//10의 자리
		int num_10 = num/10;
		//1의 자리
		int num_1 = num%10;
		
		if((num_10==3||num_10==6||num_10==9) && (num_1==3||num_1==6||num_1==9)) {
			System.out.println("박수짝짝");
		}
		else if((num_10==3||num_10==6||num_10==9) || (num_1==3||num_1==6||num_1==9))
			System.out.println("박수짝");
		else
			System.out.println("박수 없음");
	}

}
