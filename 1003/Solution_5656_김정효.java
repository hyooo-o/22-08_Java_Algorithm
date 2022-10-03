import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5656_김정효 {
	static int n, w, h, totalCnt, _min, map[][], list[];
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			list = new int[4];
			visit = new boolean[w];
			_min = Integer.MAX_VALUE;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) totalCnt++;
				}
			}
			// 구슬을 떨어뜨릴 n개의 w좌표 구하기 -> bfs 호출
			perm(0);
			sb.append("#").append(tc).append(" ").append(_min).append("\n");
		}
		System.out.print(sb);

	}

	private static void perm(int cnt) {
		if (cnt == n) {
			// 구한 w좌표에 구슬 떨어뜨리기
			for (int i : list) {
				for (int j = 0; j < h; j++) {
					if (map[i][j] != 0) {
						bfs(i, j);
						break;
					}
				}
			}
			_min = Math.min(_min, count());
			return;
		}
		
		for (int i = 0; i < w; i++) {
			if (visit[i]) continue;
			list[cnt] = i;
			visit[i] = true;
			perm(cnt+1);
			visit[i] = false;
		}
	}

	private static void bfs(int x, int y) {
		int[] dx = {-1, 0, 1, 0};		// 상, 우, 하, 좌
		int[] dy = {0, 1, 0, -1};
		
		map[x][y] = 0;
		
		for (int k = 0; k < 4; k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			// 범위 내에 존재하고 구슬이 명중한다면
			// 해당 위치는 0으로 만든 후, totalCnt--
			// 1보다 큰 수를 가진 벽돌은 저장해뒀다가 터트림.
			// nx, ny 위치를  map[x][y]-1 번 옮겨서 위와 같은 작업 반복
			for (int i = 0; i < map[x][y]-1; i++) {
				if (nx>=0 && ny>=0 && nx<h && ny<w) {
					if (map[nx][ny] != 0) {
						if (map[nx][ny] > 1) {
							bfs(nx, ny);
						}
						map[nx][ny] = 0;
					}
					nx += dx[k];
					ny += dy[k];
				}
			}
		}
		
		// 벽돌 하나에 대한 작업이 다 끝나면, 위의 벽돌을 아래로 옮김
		for (int i = 0; i < w; i++) {
			for (int j = h-1; j > 0; j--) {
				if (map[j][i] == 0 && map[j-1][i] != 0) {
					map[j][i] = map[j-1][i];
				}
			}
		}
	}

	private static int count() {
		int _cnt = 0;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] != 0) _cnt++;
			}
		}
		return _cnt;
	}
}
