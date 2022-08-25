import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * SWEA 7465. 창용 마을 무리의 개수
 * kruskal 알고리즘
 * - union, find 사용
 * - hashSet을 통해 그룹 개수 세기
 * @author kjh
 *
 */
public class Solution_7465_김정효 {
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a]  = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
		return;
	}
	
	static int N;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// 자기 자신을 가리키도록
			parents = new int[N+1];
			for (int i = 1; i < N+1; i++) {
				parents[i] = i;
			}
			// 입력 받으면서 union
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				union(from, to);
			}
			// 대표자 개수 세기
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i < N+1; i++) {
					set.add(find(i));
			}
			
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}	// end of for testCase
		System.out.println(sb);
	}

}
