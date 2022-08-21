import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * nPr 구현 복습
 * @author kjh
 *
 */
public class Permutation {
	static int N, R, result;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		
		arr = new int[R];
		visit = new boolean[N+1];
		perm(0);
		System.out.println(result);
	}
	
	private static void perm(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(arr));
			result++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			arr[cnt] = i;
			perm(cnt+1);
			visit[i] = false;
		}
	}

}
