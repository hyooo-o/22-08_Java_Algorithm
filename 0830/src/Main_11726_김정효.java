import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 11726. 2xn 타일링 (구글링을 통한 완료)
 * n개 중에 0~2/n개 고르는 조합 으로 풀려고 했으나~~ 안됨
 * DP문제였고, 그려보면 점화식이라는 것을 알 수 있음
 * (실수)
 * - line 19 : 배열 크기 (런타임에러)
 * @author kjh
 *
 */
public class Main_11726_김정효 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];	
		// 배열 크기를 n+1로 하고, dp[2]=2까지 작성하면 런타임 에러 발생. n=1일 때, 배열 크기는 2인데 dp[2]=2에 접근하려고 하기 떄문.
		// 배열 크기를 1001로 해주던가 dp[2]=2 대신 dp[0]=1를 작성
		
		dp[0] = 1;	
		dp[1] = 1;
//		dp[2] = 2;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1]+dp[i-2]) % 10007;	// 마지막 답에서 나머지를 구하려고 하면 overflow가 발생하므로 매 계산마다 나머지를 구해줌
		}
		
		System.out.println(dp[n]);
	}
}
