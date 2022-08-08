import java.util.Scanner;
/**
 * SWEA 1954
 * 22/8/2 
 * @author kjh
 *
 */
public class Solution_1954_김정효 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];			
			//우, 하, 좌, 상 반복
			int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
			int x=0;
			int y=0;
			int dx=0;
			int dy=0;
			int a=0;
			arr[x][y] = 1;
			for(int j=2; j<=n*n; j++) {
				dx = x+d[a][0];
				dy = y+d[a][1];
				if(dx>=0 && dy>=0 && dx<n && dy<n && arr[dx][dy] == 0) {
					arr[dx][dy] = j;
					x=dx;
					y=dy;
				}else {
					a += 1;
					j -= 1;
					if(a % 4 == 0) {
						a %= 4;
					}
				}
			}
			System.out.printf("#%d%n", i);
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					System.out.print(arr[j][k]+" ");
				}
				System.out.println();
			}
			
		}
		
	}

}
