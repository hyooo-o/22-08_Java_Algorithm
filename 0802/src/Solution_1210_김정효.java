import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int i=1; i<=10; i++) {
			int t = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			for(int j=0; j<100; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<100; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			//-----배열 입력 완료--------
			int index = 0;
			for(int j=0; j<100; j++) {
				if(arr[99][j] == 2) {
					index = j;
					break;
				}
			}
			int n = 99;
			while(n > 0) {	
				int left = index-1;
				int right = index+1;
				if(left >= 0 && arr[n][left] == 1) {
					int m = left;
					while(n >= 1 && arr[n-1][m] != 1) {
						m -= 1;
//						System.out.print("left: "+(n)+","+m+") ");
					}
					index = m;
				}else if(right <= n && arr[n][right] == 1) {
					int m = right;
					while(n >= 1 && arr[n-1][m] != 1) {
						m += 1;
//						System.out.print("r: "+(n)+","+m+") ");
					}
					index = m;
				}
				n -= 1;
				
			}
			System.out.printf("#%d %d%n", i, index);
		}
	}

}
