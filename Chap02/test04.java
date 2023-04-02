import java.util.Scanner;
public class test04 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수 3개를 입력하시오>>");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		
		int sum = num1 + num2 + num3;
		int max = num1>num2?num1:num2;
		max = max>num3?max:num3;
		
		int min = num1<num2?num1:num2;
		min = min<num3?min:num3;
		
		int mid = sum - max - min;
		
		System.out.println("중간 값은 "+mid);
		
		scan.close();
	}

}
