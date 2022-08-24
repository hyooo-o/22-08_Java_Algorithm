import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 2819. 격자판의 숫자 이어 붙이기
 * dfs
 * @author kjh
 *
 */
public class Solution_2819_김정효 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] data;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[][] arr = new int[4][4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			move(0, 0, 0);
			sb.append("#").append(tc).append(" ").append().append("\n");
		}
		System.out.println(sb);
	}

	private static void move(int x, int y, int cnt) {
		if(cnt == 7) {
			
			return;
		}
		if(x<0 && y<0 && x>4 && y>4) return;
		data[cnt] = arr[x][y];
		move(x+dx[0], y+dy[0], cnt+1);
		move(x+dx[1], y+dy[1], cnt+1);
		move(x+dx[2], y+dy[2], cnt+1);
		move(x+dx[3], y+dy[3], cnt+1);
	}

}
