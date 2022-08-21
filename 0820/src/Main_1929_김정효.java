import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1929 소수 구하기 - 방법1
 * 시간복잡도에 의해 '에라토스테네스의 체' 사용
 * @author kjh
 *
 */
public class Main_1929_김정효 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] check = new boolean[M+1];	// 소수는 true
		for (int i = 2; i < M+1; i++) {	// 탐색 전, 2~M까지 true 값 넣기 
			check[i] = true;
		}
		
		for (int i = 2; i*i <= M; i++) {
			if (!check[i]) continue;	// false 이면 탐색 안함
			for (int j = i*i; j <= M; j+=i) {	// 소수의 배수 지우기
				check[j] = false;
			}
		}
		// Output
		for (int i = N; i <= M; i++) {
			if (check[i]) System.out.println(i);
		}
	}
}
