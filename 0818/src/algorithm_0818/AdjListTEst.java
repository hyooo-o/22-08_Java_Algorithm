package algorithm_0818;

import java.util.Scanner;
// 인접리스트 탐색 DFS - 다시 해보기!!
public class AdjListTEst {

	static class Node{
		int to;
		Node next;
		
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}
	
	static Node[] adjList;
	static int N;
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();		// 정점 수
		int E = sc.nextInt();	// 간선 수
		
		adjList = new Node[N];
		visited = new boolean[N];
		
		for (int i = 0; i < E; i++) {	// 간선 정보에 해당하는 부분만 덮어씀
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		dfs(0);
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.print((char)(cur+'A'));
		
		// 현 정점의 인접정점들을 큐에 넣어 차후 탐색하도록 만들기
		for (Node temp = adjList[cur]; temp!= null; temp = temp.next) {
			if(!visited[temp.to]) {	// 방문 X
				dfs(temp.to);
			}
		}
		
	}

}
