import java.util.Scanner;

public class Solution_2805_김정효 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for(int j=0; j<n; j++) {
				String temp=sc.next();
				for(int k=0; k<n; k++) {
					arr[j][k] = temp.charAt(k)-'0';
				}
			}
			//----------입력완료---------
			int line = (int) Math.floor(n/2);		// line=2
			int total = 0;
			for(int j=0; j<=line; j++) {	// 행: 0~중간
				for(int k=line-j; k<=line+j; k++) {
					total += arr[j][k];
				}
			}
			int m = 0;
			for(int j=n-1; j>line; j--) {	// 열: 중간~마지막
				for(int k=line-m; k<=line+m; k++) {
					total += arr[j][k];
				}
				m += 1;
			}
			System.out.printf("#%d %d%n", i, total);
		}

	}

}
