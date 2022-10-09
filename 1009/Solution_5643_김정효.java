import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * SWEA 5643 키 순서 (플로이드 워셜)
 * 1. 모든 사람과 연결되어 있는지 확인
 * 2. 연결되어 있다면 
 * @author kjh
 *
 */
public class Solution_5643_김정효 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			boolean[][] visit = new boolean[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				visit[s][e] = true;
			}
			
			for (int k = 1; k < N+1; k++) {	// 경유지
				for (int i = 1; i < N+1; i++) {	// 출발지
					if (k == i) continue;
					for (int j = 1; j < N+1; j++) {	// 목적지
						if (j==k || i==j) continue;
						// i->k->j 가 존재하거나 i->j가 존재하면  i->j = true
						visit[i][j] = (visit[i][k] && visit[k][j]) || visit[i][j];
					}
				}
			}
			
			// 모든 사람과 연결되어 있는지 확인
			int result = 0;
			for (int i = 1; i < N+1; i++) {
				int cnt = 0;
				for (int j = 1; j < N+1; j++) {
					if (i==j) continue;
					if (!visit[i][j] && !visit[j][i]) break;
					cnt++;	// i가 j 랑 연결되어 있다면
				}
				// i가 1~N+1 (자신 제외 총 N-1명) 모두랑 연결되어 있다면 결과값 +1
				if (cnt == N-1) result++;
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
