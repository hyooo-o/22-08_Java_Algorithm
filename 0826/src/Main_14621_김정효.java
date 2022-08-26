import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * BOJ 14621. 나만 안되는 연애 - (미완성)
 * 
 * @author kjh
 *
 */
public class Main_14621_김정효 {

	static class Node {	// 인접리스트
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex {	// 인접리스트
		int no, weight;
		String school;
		
		public Vertex(int no, int weight, String school) {
			super();
			this.no = no;
			this.weight = weight;
			this.school = school;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 정점 개수
		int m = Integer.parseInt(st.nextToken());	// 간선 개수
		String[] school = br.readLine().split(" ");	// 학교 성별
		
		Node[] adjList = new Node[n+1];	// 인접리스트 생성
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 무방향 그래프
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		boolean[] visit = new boolean[n+1];
		int[] d = new int[n+1];		// 최단 거리 저장
		
		Arrays.fill(d, Integer.MAX_VALUE);	// 초기화
		
		d[1] = 0;	// 시작 정점
		int result = 0;	// 누적 비용
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
		pQueue.offer(new Vertex(1, d[1], school[0]));
		
		while(!pQueue.isEmpty()) {
			Vertex minV = pQueue.poll();
			String s = minV.school;
			
			if(visit[minV.no]) continue;
			visit[minV.no] = true;
			result += minV.weight;
			
			for (Node temp = adjList[minV.no]; temp != null; temp = temp.next) {
				if(!visit[temp.vertex] && d[temp.vertex]>temp.weight && !s.equals(school[temp.vertex-1])) {
					d[temp.vertex] = temp.weight;
					pQueue.offer(new Vertex(temp.vertex, d[temp.vertex], school[temp.vertex-1]));
				}
			}
		}
		System.out.println(result);
	}

}
