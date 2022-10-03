import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];	// 입력 값
		int[][] dp = new int[N][3];		// 최소 비용 저장 배열
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];	// 집1의 R 값
		dp[0][1] = map[0][1];	// 집1의 G 값
		dp[0][2] = map[0][2];	// 집1의 B 값

		for (int i = 1; i < N; i++) {	// 집 1~i의 최솟값 구하기
			dp[i][0] = map[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);	// 집i의 R 값 + 집 1~i-1 의 최솟값
			dp[i][1] = map[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);	// 집i의 G 값 + 집 1~i-1 의 최솟값
			dp[i][2] = map[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);	// 집i의 B 값 + 집 1~i-1 의 최솟값
		}
		
		// 마지막 집의 R, G, B 값 중 최소가 집 1~i까지의 최소 비용이 된다.
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
	}

}