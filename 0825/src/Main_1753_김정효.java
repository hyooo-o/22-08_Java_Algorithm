import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * BOJ 1753. 최단경로
 * 방향그래프, 가중치 10이하의 자연수, 최단경로 => 다익스트라 사용
 * <오류>
 * 1. 인접리스트 초기화 안함
 * 2. sb 붙여주는 과정을 for문 따로 빼줘서 돌리기 
 * => 시작 정점과 연결되지 않은 정점은 INF가 출력되지 않는 문제 해결
 * @author kjh
 *
 */
public class Main_1753_김정효 {
	
	static class Node implements Comparable<Node>{
		int vertex, weight;
		
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());	// 정점 개수
		int E = Integer.parseInt(st.nextToken());	// 간선 개수
		int K = Integer.parseInt(br.readLine());	// 시작 정점
		
		ArrayList<Node>[] adjList = new ArrayList[V+1];	// 인접리스트
		for(int i = 1; i < V+1; i++) {	// 인접리스트 초기화
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// 유향 그래프
			adjList[from].add(new Node(to, weight));
		}	//---------입력 끝------------
		
		int[] D = new int[V+1];	// 각 정점별 최단거리 저장
		boolean[] visit = new boolean[V+1];	// 방문 확인
		
		Arrays.fill(D, Integer.MAX_VALUE);	// 최대값으로 초기화
		
		// 다익스트라 수행
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.weight-o2.weight);
		q.add(new Node(K, 0));		// 시작 정점 초기화
		D[K] = 0;
		
		while (!q.isEmpty()) {
			Node now = q.poll();
			if(!visit[now.vertex]) {
				visit[now.vertex] = true;
			}
			
			for (Node temp: adjList[now.vertex]) {
				if(!visit[temp.vertex] && D[temp.vertex]>temp.weight+now.weight) {
					D[temp.vertex] = temp.weight+now.weight;
					q.add(new Node(temp.vertex, D[temp.vertex]));
				}
				
			}
			
		}
		// 최단경로 찾아서 sb에 붙여주기
		for (int i = 1; i < visit.length; i++) {
			sb.append(D[i] != Integer.MAX_VALUE? D[i]: "INF").append("\n");
		}
		
		System.out.println(sb);
	}

}
