import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_김정효 {
	static int N, d, k, c, res, cnt, arr[], eat[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 접시
		d = Integer.parseInt(st.nextToken());	// 종류
		k = Integer.parseInt(st.nextToken());	// 연속 몇 개
		c = Integer.parseInt(st.nextToken());	// 보너스
		arr = new int[N];
		eat = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k; i++) {
			if (eat[arr[i]] == 0) {	// 처음 먹으면 개수+1
				res++;
			}
			eat[arr[i]]++;
		}
		// 보너스가 새로운 종류이면 개수+1
		cnt = res;
		res = (eat[c]==0)? cnt+1: cnt;
		go();
	}

	private static void go() {
		int start = k;
		
		while(true) {
			// 전에 먹었으면 뱉음
			eat[arr[(start-k) % N]]--;
			// 뱉었는데 먹은적 없으면 개수-1
			if (eat[arr[(start-k) % N]] == 0) cnt--;
			// 다음 초밥이 먹은적 없는 거면 먹음
			if (eat[arr[start % N]] == 0) {
				cnt++;
			}
			eat[arr[start % N]]++;
			// 보너스가 안 먹어본 종류면 +1
			res = Math.max(res, (eat[c] == 0)? cnt+1: cnt);
			// 다음 먹기
			start++;
			if (start == (N-1) + k) break;
		}
	}

}
