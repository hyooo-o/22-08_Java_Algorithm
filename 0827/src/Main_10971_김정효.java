import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 10971. 외판원 순회2 - (완료)
 * 최소비용, 행렬, 유향, 비용: 양의 정수
 * dfs 사용
 * (실수)
 * - 갈 수 없는 경우는 0이 주어진다 => 조건을 고려안함 (Line 43)
 * @author kjh
 *
 */
public class Main_10971_김정효 {
	static int n;
	static int[][] arr;
	static int _min;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}//---------입력 완료--------
		
		_min = Integer.MAX_VALUE;
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {	// 시작 도시 0 ~ n-1 각각 해보기 
			visit[i] = true;
			dfs(i, i, 0, 1);
			visit[i] = false;
		}
		System.out.println(_min);
	}

	private static void dfs(int start, int num, int w, int cnt) {		
		if(cnt == n) {
			if(arr[num][start] != 0) {		// 이 조건 작성 안해서 오답 나옴 ㅠ (0이면 이동 불가능)
				w += arr[num][start];
				_min = Math.min(_min, w);
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(arr[num][i] == 0 || visit[i]) continue;
			visit[num] = true;
			dfs(start, i, w+arr[num][i], cnt+1);
			visit[num] = false;
		}
	}

}
