import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA 1238. [S/W 문제해결 기본] 10일차 - Contact D4   (완성 - 구글링 찾아봄)
 * 출력: 가장 나중 번호가 가장 큰 사람
 * 유향, 가중치 X, 동시에 연락, 이미 연락을 받은 상태 -> 다시 연락하지 않는다
 * @author kjh
 *
 */
public class Solution_1238_김정효 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[101][101];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V/2; j++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = 1;
			}//--------입력 완료---------
			
			int result = 0;
			int[] visit = new int[101];
			Queue<Integer> q = new LinkedList<>();
			
			q.offer(start);
			int depth = 1;
			visit[start] = depth;
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int i = 1; i < 101; i++) {
					if (visit[i] == 0 && arr[cur][i] == 1) {	// 원소 존재 && 방문 안함
						q.offer(i);
						visit[i] = visit[cur]+1;	// 방문한 곳에 부모의 depth에 +1 넣어주기
					}
				}
				depth = Math.max(depth,visit[cur]);		// 최고 깊이 찾기
			}
			
			for (int i = 100; i >= 0; i--) {	// 가장 큰 수 찾아야 하니깐 뒤에서부터 최상level의 노드 찾아봄
				if (depth == visit[i]) {
					result = i;
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

}

