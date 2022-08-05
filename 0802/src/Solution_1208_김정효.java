import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_김정효 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=10; i++) {
			int cnt = sc.nextInt();		// 덤프 횟수
			int[] arr = new int[100];
			for(int j=0; j<100; j++) {
				arr[j] = sc.nextInt();
			}
			for(int j=0; j<cnt; j++) {
				Arrays.sort(arr);
				arr[99] -= 1;
				arr[0] += 1;
			}
			Arrays.sort(arr);
			int result = arr[99]-arr[0];
			System.out.printf("#%d %d%n", i, result);
		}
	}

}
