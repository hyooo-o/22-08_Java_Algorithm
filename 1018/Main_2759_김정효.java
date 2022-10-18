import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2579 계단 오르기 (DP)
 * 한 번에 1 또는 2, 연속 세 개X, 마지막은 반드시O
 * (출력) 최댓값
 * 
 * 	<----	<----
 * n-4	n-3		n-2	n-1	n
 * ?	O		X	O	O	recur[n-1]
 * ?	X		O	X	O	dp[] + 
 * X	O		O	X	O 	dp[] + 
 * 
 * X	X		O	X	O 	arr[3]
 * O	O		X	X	O	dp[2]
 * X	O		X	O	O 	arr[2] + arr[4]
 * 
 * @author kjh
 *
 */
public class Main_2759_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		dp[2] = dp[1] + arr[2];
		
		for (int i = 1; i < n; i++) {
			
		}
		
	}

}
