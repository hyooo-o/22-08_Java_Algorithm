import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * SWEA 2819. 격자판의 숫자 이어 붙이기 (완성)
 * dfs 사용
 * 오류)
 * 1. set 초기화을 static으로 설정해 놔서 다음 tc 돌릴 때, set이 초기화 안된 상태로 진행되었음
 * 2. r, c 변수를 설정안하고 x, y 그대로 사용해서 제대로 조건 확인이 안됨
 * @author kjh
 *
 */
public class Solution_2819_김정효 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] arr;
	static Set<String> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			arr = new int[4][4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}	// end of input
			
			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					move(i, j, 0, ""+arr[i][j]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}
		System.out.println(sb);
	}

	private static void move(int x, int y, int cnt, String str) {
		if(cnt == 6) {
			set.add(str);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int r = x+dx[i];
			int c = y+dy[i];
			if(r>=0 && c>=0 && r<4 && c<4) {
				move(r, c, cnt+1, str+arr[r][c]);
				
			}
		}
	}

}
