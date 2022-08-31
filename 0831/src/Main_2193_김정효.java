import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * BOJ 2193 이친수
 * dp 문제
 * (실수) 1<=N<=90이므로 N=47이상이면 int 범위를 초과한다
 * => long으로 바꿔줌
 * @author kjh
 *
 */
public class Main_2193_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < n+1; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]);
	}

}
