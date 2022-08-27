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
 * SWEA 1238. [S/W 문제해결 기본] 10일차 - Contact D4   (미완성 - 답이 틀림)
 * 출력: 가장 나중 번호가 가장 큰 사람
 * 유향, 가중치 X, 동시에 연락, 이미 연락을 받은 상태 -> 다시 연락하지 않는다
 * @author kjh
 *
 */
public class Solution_1238_김정효 {
	static List<Integer>[] adjList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[101];
			for (int i = 0; i < 101; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size/2; j++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
			}//--------입력 완료---------
			
			sb.append("#").append(tc).append(" ").append(bfs(start)).append("\n");
		}
		System.out.println(sb);

	}

	private static int bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] visit = new int[101];
		q.offer(start);
		
		int depth = 1;
		visit[start] = depth;
		
		while(!q.isEmpty()) {
			start = q.poll();	// 원소 꺼내서 확인하기
			for (int i: adjList[start]) {	// 존재하는 원소이며,
				if (visit[i] == 0) {	// 방문하지 않았다면
					q.offer(i);	// 인접 원소 넣어주기
					visit[i] = visit[start] + 1;	// 방문한 원소의 depth 길이 +1 해주기
				}
			}
			depth = Math.max(depth, visit[start]);
//			if (depth <= visit[start]) {
//				depth = visit[start];
//				result = start;
//			}
		}
		
		for (int i = 100; i >= 0; i--) {
			if (depth == visit[i]) return visit[i];
		}
		return -1;
	}

}

