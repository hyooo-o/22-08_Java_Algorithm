import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * SWEA 8382 방향 전환 
 * 아이디어가 중요!!
 * 다른 풀이1. 완전탐색으로도 가능
 * @author kjh
 *
 */
public class Solution_8382_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int dx = Math.abs(x1-x2);
				int dy = Math.abs(y1-y2);
				int min = Math.min(dx, dy);
				int max = Math.max(dx, dy);
				int result = 2*min + (max-min)*2 - ((max-min)%2 == 0? 0: 1);
				
				sb.append("#").append(tc).append(" ").append(0).append("\n");
			}	// end of for testCase
			System.out.print(sb.toString());
		}	// end of main
	}	// end of class

}
