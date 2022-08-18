import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * BOJ 1987 알파벳
 * dfs를 이용한 방문체크 해주기
 * @author kjh
 *
 */
public class Main_1987_김정효 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] arr;
	static boolean[] visit;
	static int R, C, _max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		visit = new boolean[26];
		_max = 0;
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j)-'A';
			}
		}
		dfs(0, 0, 0);
		System.out.println(_max);
	}

	private static void dfs(int i, int j, int cnt) {
		if (visit[arr[i][j]]) {
			_max = Math.max(_max, cnt);
			return;
		}else {
			visit[arr[i][j]] = true;
			for (int k = 0; k < 4; k++) {
				int x = i+dx[k];
				int y = j+dy[k];
				if(x>=0 && y>=0 && x<R && y<C) {
					dfs(x, y, cnt+1);
				}
			}
			visit[arr[i][j]] = false;
		}
	}

}
