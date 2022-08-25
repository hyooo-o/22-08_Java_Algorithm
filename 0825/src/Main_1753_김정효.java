import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1753_김정효 {
	
	static class Node {
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		Node[] adjList = new Node[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 유향 그래프
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		int[] D = new int[V+1];
		boolean[] visit = new boolean[V+1];
		
		Arrays.fill(D, Integer.MAX_VALUE);
		
		int min = 0;
		int minVertex;
		for (int j = 1; j < V+1; j++) {
			min = Integer.MAX_VALUE;
			minVertex = -1;
			for (int i = 1; i < V+1; i++) {
				if(!visit[i] && min>D[i]) {
					min = D[i];
					minVertex = i;
				}
			}
			visit[minVertex] = true;
			if(minVertex == j) break;
			
			for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if(!visit[temp.vertex] && D[temp.vertex]>temp.weight) {
					D[temp.vertex] = temp.weight;
				}
			}
		}
		System.out.println(min);

	}

}
