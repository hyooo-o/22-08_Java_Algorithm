import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 1978 소수 찾기
 * 1. 소수는 1과 자기자신만 갖는 수이므로 다른 수로 나누어 떨어지면 안됨
 * @author kjh
 *
 */
public class Main_1978_김정효 {
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			check(num);
		}
		System.out.println(cnt);
	}

	private static void check(int a) {
		boolean isAvailable = true;
		if (a > 1) {
			for (int i = 2; i < a ; i++) {
				if (a % i == 0) {
					isAvailable = false;
					break;
				}
			}
			if(isAvailable) cnt++;
		}
	}

}