import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 13023. ABCDE
 * 인접리스트 사용
 * 오류) dfs 돌릴 때 for문으로 처리해서 1~N 까지 각자 시작점에서 돌수 있도록 처리
 * @author kjh
 *
 */
public class Main_13023_김정효 {
	static class Node{
		int to;
		Node next;
		
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
	}
	
	static int result;
	static Node[] adjList;
	static boolean visit[];
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int N = Integer.parseInt(st.nextToken());	// 사람 수: 정점수
		 int m = Integer.parseInt(st.nextToken());	// 관계 수: 간선 수

		 adjList = new Node[N];
		 visit = new boolean[N];
		 
		 for (int i = 0; i < m; i++) {
			 st = new StringTokenizer(br.readLine());
			 int from = Integer.parseInt(st.nextToken());
			 int to = Integer.parseInt(st.nextToken());
			
			 adjList[from] = new Node(to, adjList[from]);
			 adjList[to] = new Node(from, adjList[to]);
		}
		 for (int i = 0; i < N; i++) {
			 dfs(i, 1);
		}
		 System.out.println(result);
	}

	private static void dfs(int cur, int cnt) {
		if(cnt == 5) {
			result = 1;
			return;
		}
		
		for (Node temp = adjList[cur]; temp != null; temp=temp.next) {
			if(!visit[temp.to]) {
				visit[cur] = true;
				dfs(temp.to, cnt+1);
				if(result == 1) break;
				visit[cur] = false;
			}
		}
	}

}
