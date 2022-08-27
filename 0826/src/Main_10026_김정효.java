import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * BOJ 10026. 적록색맹 - (완성)
 * R, G, B  //  (R, G), B
 * DFS 사용
 * (실수)
 * Line 75. return: 함수 끝내기, continue: 다음 루프 실행
 * 
 * @author kjh
 *
 */
public class Main_10026_김정효 {
	static char[][] arr;
	static int n;
	static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}//-----------입력 완료-------------
		
		// 일반인
		visit = new boolean[n][n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					dfs(i, j);
					cnt++;	// 영역이 바뀌면 +1
				}
			}
		}
		// R == G로 변경
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 'G') arr[i][j] = 'R';
			}
		}
		// 적록색맹
		visit = new boolean[n][n];
		int cnt2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					dfs(i, j);
					cnt2++;	// 영역이 바뀌면 +1
				}
			}
		}
		System.out.println(cnt+" "+cnt2);
	}

	private static void dfs(int x, int y) {
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		visit[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int r = x+dx[d];
			int c = y+dy[d];
			if(r>=0 && c>=0 && r<n && c<n) {
				if (visit[r][c]) continue;	// 이미 방문했다면 continue!!!!! (실수) return 써서 계속 오류남ㅠ
				if (arr[x][y] == arr[r][c]) {	// 같은 색상이면 dfs 호출
					dfs(r, c);
				}
			}
		}
	}

}
