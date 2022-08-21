import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * nCr 구현 복습
 * @author kjh
 *
 */
public class Combination {
	static int N, R, result;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		
		arr = new int[R];
		comb(0, 0);
		System.out.println(result);
	}
	
	private static void comb(int start, int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(arr));
			result++;
			return;
		}
		
		for (int i = start; i < N; i++) {
			arr[cnt] = i;
			comb(i+1, cnt+1);
		}
	}

}
