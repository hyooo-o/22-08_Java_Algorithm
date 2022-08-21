import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2023. 신기한 소수 (백트래킹, 소수 판별)
 * 1. 숫자 한자리 수 부터 ~N자리 수까지 백트래킹으로 확인하기
 * - 첫째 자리 {2, 3, 5, 7} 만 가능
 * - 그 이후 자릿 수에는 {1, 3, 7, 9}만 가능
 * 2. 소수구하기 (제곱근 또는 에라토스테네스의 체)
 * @author kjh
 *
 */
public class Main_2023_김정효 {
	static int N;
	static int[] arr = {2, 3, 5, 7};
	static int[] arr2 = {1, 3, 7, 9};	
	static boolean[] visit = new boolean[4];	// false (소수)
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			back(arr[i], 1);
		}
		System.out.println(sb);
	}
	
	private static void back(int num, int cnt) {
		if (cnt == N) {		// 숫자 하나 완성
			sb.append(num).append("\n");
			return;
		}
		
		for (int j = 0; j < arr2.length; j++) {
			int a = num*10 + arr2[j];
			boolean is = false;
			if (visit[j]) return;
			visit[j] = true;
			// 소수 판별
			for (int k = 2; k <= (int)Math.sqrt(a); k++) {
				if (a % k == 0) {	// a 가 소수가 아니라면 종료
					is = true;
					break;
				}
			}
			visit[j] = false;
			if (!is) {	// 소수이면 다음 자릿수 탐색
				back(a, cnt+1);
			}
		}
		return;
	}

}
