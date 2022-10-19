import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2579 계단 오르기 (DP)
 * 한 번에 1 또는 2, 연속 세 개X, 마지막은 반드시O
 * (출력) 최댓값
 * 
 * 	<----	<----
 * n-4	n-3		n-2		n-1		n
 * ?	O		X		O		O	arr[n-1] + recur[n-3]
 * ?	X		O		X		O	recur[n-2] + 
 * X	O		O		X		O 	
 * 
 * @author kjh
 *
 */
public class Main_2759_김정효 {
	static int dp[], arr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		
		if (n > 1) {
			dp[2] = dp[1] + arr[2];
		}
		
		for (int i = 3; i <= n; i++) {
			dp[n] = Math.max(dp[n-2], dp[n-3] + arr[n-1]) + arr[n];
		}
		
		System.out.println(dp[n]);
		
	}
}
