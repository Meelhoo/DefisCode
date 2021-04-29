package défis.essais._2_1;
import java.util.Scanner;

public class PermuteInt {

	public static void permute(int a, int b) {

		a = a^b	;
		b = a^b	;
		a = a^b	;		
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		permute(a,b);
		sc.close();
		
	}

}
