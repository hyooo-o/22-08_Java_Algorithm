package algorithm_0801;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇기? ");
		int no = sc.nextInt();
		System.out.println("=> ssafy "+no+"기");
		
		System.out.print("슬로건? ");
		String msg = sc.next();
//		String msg = sc.nextLine();
		System.out.println("=> 슬로건: "+msg);

	}

}
