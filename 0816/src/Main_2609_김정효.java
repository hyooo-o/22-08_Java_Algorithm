import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2609 최대공약수와 최소공배수
 * 유클리드 호제법
 * - 최대공약수 => 두 수의 나머지를 이용
 * - 최소공배수 = 두 수의 곱 / 최대공약수
 * @author kjh
 *
 */
public class Main_2609_김정효 {
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		gcd(x, y);
		System.out.println(result);
		System.out.println(x*y/result);
	}
	
	private static void gcd(int x, int y) {
		if (x%y == 0) {
			result = y;
		}else {
			gcd(y, x%y);
		}
	}

}
