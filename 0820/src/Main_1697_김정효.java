import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 1697 숨바꼭질
 * 목표 수 -> 시작수
 * bfs 사용
 * @author kjh
 *
 */
public class Main_1697_김정효 {
	static int N, _min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		_min = Integer.MAX_VALUE;
		bfs(K, 0);
		System.out.println(_min);
	}

	private static void bfs(int k, int cnt) {
		if(N == k) {
			_min = Math.min(_min, cnt);
			return;
		}
		
		if (Math.abs(N-k) == 1) {
			bfs(N, cnt+1);
			return;
		}else if(k % 2 == 0) {
			if(Math.abs(N-(k/2))+1 >= Math.abs(k-N)) {
				bfs(N, cnt + Math.abs(k-N));
				return;
			}
			bfs(k/2, cnt+1);
		}else if(k % 2 != 0) {
			bfs(k-1, cnt+1);
			bfs(k+1, cnt+1);
		}
		return;		
	}

}
