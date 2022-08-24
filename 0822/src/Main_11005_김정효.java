import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
/**
 * BOJ 11005. 진법 변환2
 * 시간 제한으로 인해 메소드 사용X => 단순 구현
 * 10진수 -> n진수: Integer.toString(10진수, n);  => 안됨
 * @author kjh
 *
 */
public class Main_11005_김정효 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		while(N > 0) {
			if (N % B > 9) {	// 9보다 크면 A부터 시작
				sb.append((char) (N % B + 'A' - 10));
			}else {	// 9이하는 그냥 붙임
				sb.append(N % B);
			}
			N /= B;
		}
		System.out.println(sb.reverse());	// 거꾸로 출력
	}

}
