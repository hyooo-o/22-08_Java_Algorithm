import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 13023. ABCDE
 * ��������Ʈ ���
 * ����) dfs ���� �� for������ ó���ؼ� 1~N ���� ���� ���������� ���� �ֵ��� ó��
 * @author kjh
 *
 */
public class Main_13023_����ȿ {
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
		 int N = Integer.parseInt(st.nextToken());	// ��� ��: ������
		 int m = Integer.parseInt(st.nextToken());	// ���� ��: ���� ��

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
