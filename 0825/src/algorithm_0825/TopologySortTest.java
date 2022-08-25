package algorithm_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 위상정렬 - BFS
 * @author kjh
 *
 */
public class TopologySortTest {

	static class Node{
		int vertex;	// 연결된 정점, 가중치
		Node next;	// 연결리스트 연결하기 위한 next 링크
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static int V, E;
	static Node[] adjList;
	static int[] inDegree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new Node[V+1];	// 각 정점별 인접리스트
		inDegree = new int[V+1];	// 정점별 진입차수
		
		for (int i = 0; i < E; i++) {	// 간선 수만큼 돌아야 함
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			// 유향 처리
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}
		ArrayList<Integer> list = topologySort();
		if(list.size() == V) {	// 위상정렬 완성
			for (Integer i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
		}else {
			System.out.println("cycle 발생");
		}
	}
	
	private static ArrayList<Integer> topologySort(){
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		// 진입차수가 0인 정점 큐에 넣기
		for (int i = 1; i <= V; i++) {
			if(inDegree[i] == 0) queue.offer(i);
		}
		
		//BFS
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			list.add(cur);
			
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if(--inDegree[temp.vertex] == 0) queue.offer(temp.vertex);
			}
		}
		return list;
	}

}
