import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA - D5. 1247. [S/W 문제해결 응용] 3일차 - 최적 경로
 * (미완성-다시)
 * @author multicampus
 *
 */
public class Solution_1247_김정효 {
	static int[][] arr;
	static boolean[] visit;
	static int N, _min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[N+2][2];
			visit = new boolean[N+2];
			
			for (int j = 0; j < N+2; j++) {
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}// end of input
			_min = Integer.MAX_VALUE;
//			int[] start = {arr[0][0], arr[0][1]};
			int[] end = {arr[1][0], arr[1][1]};
			res(arr[0][0], arr[0][1], 0, 0);
			sb.append("#").append(i).append(" ").append(_min).append("\n");
		}
		System.out.print(sb);
		
	}

	
	private static void res(int x, int y, int cnt, int sum) {
		if (cnt == N-2) {
			sum += Math.abs(arr[1][0]-x) + Math.abs(arr[1][1]-y);
			_min = Math.min(_min, sum);
		}
		
		for (int i = 2; i < N+2; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			System.out.println(x+" "+y);
			res(arr[i][0], arr[i][1], cnt+1, sum + Math.abs(arr[i][0]-x) + Math.abs(arr[i][1]-y));
			visit[i] = false;
		}
	}
}
