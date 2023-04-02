import java.util.Scanner;
public class test02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		//2번
		System.out.print("2자리 정수 입력(10~99)>>");
		int num = scan.nextInt();
		//10의 자리
		int num_10 = num/10;
		//1의 자리
		int num_1 = num%10;
				
		if (num_10 == num_1) {
			System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
		}
		else
			System.out.println("No! 10의 자리와 1의 자리가 다릅니다.");
	
		scan.close();
	}

}
