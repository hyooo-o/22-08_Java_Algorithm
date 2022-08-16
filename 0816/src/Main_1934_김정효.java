import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1934 최소공배수
 * 1. gcd로 최대공약수 구하기
 * 2. 두 수의 곱 / 최대공약수 => 최소공배수 
 * @author kjh
 *
 */
public class Main_1934_김정효 {
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			gcd(a, b);
			System.out.println(a*b/result);
		}
	}

	private static void gcd(int a, int b) {
		if (a % b == 0) {
			result = b;
		}else {
			gcd(b, a%b);
		}
		
	}
	
	

}
