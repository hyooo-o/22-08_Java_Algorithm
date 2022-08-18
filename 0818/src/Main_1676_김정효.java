import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * BOJ 1676 팩토리얼 0의 개수
 * 문제 이해 잘 못함 ㅎ
 * 마지막 0의 개수 = (2x5)^n에서 n의 개수
 * @author kjh
 *
 */
public class Main_1676_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int n1 = 0, n2 = 0;
		
		for (int i = N; i > 0; i--) {
			int temp = i;
			while(true) {
				if(temp % 2 == 0) {
					temp /= 2;
					n1++;
				}
				if(temp % 5 == 0) {
					temp /= 5;
					n2++;
				}
				if(temp % 2 != 0 && temp % 5 != 0) break;
			}
		}
		System.out.println(Math.min(n1, n2));
	}

}
