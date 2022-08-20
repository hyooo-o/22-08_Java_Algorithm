import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1929 소수 구하기
 * 목표 수 -> 시작수
 * bfs 사용
 * @author kjh
 *
 */
public class Main_1929_김정효 {
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		find(N);
	}

	private static void find(int n) {
		boolean check = false;
		if(n+1 == M) return;
	
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				break;
			}check = true;
		}
		if (check) System.out.println(n);
		find(n+1);
		return;
	}
	
	

}
