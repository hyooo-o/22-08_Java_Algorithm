import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_김정효 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int total = 0;
			int max = 0;
			int[][] arr = new int[n][n];		// 전체 맵
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}//------입력 완료------
			for(int j=0; j<n-m+1; j++) {
				for(int k=0; k<n-m+1; k++) {
					total = 0;
					for(int l=0+j; l<m+j; l++) {
						for(int p=0+k; p<m+k; p++) {
							total += arr[l][p];
						}
					}
					max = Math.max(max, total);
				}
			}
			System.out.printf("#%d %d%n", i, max);
		}

	}

}
