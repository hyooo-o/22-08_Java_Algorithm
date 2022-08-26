import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 7576. 토마토 (다시다시다시 미완성) - AD등급에서 어려운 편
 * 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토가 들어있지 않은 칸
 * 저장될 때부터 모든 토마토가 익어있는 상태이면 0  / 토마토가 모두 익지는 못하는 상황이면 -1
 * @author kjh
 *
 */
public class Main_7576_김정효 {
	
	static class Map{
		int x;
		int y;
		
		public Map(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, m, cnt;
	static int[][] arr;
	static Queue<Map> q = new LinkedList<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());	// n x m
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {	//	익은 토마토 큐에 넣어주기
					q.add(new Map(i, j));
				}
			}
		}
		search(0, 0);
	}

	static boolean check = false;
	private static void search(int x, int y) {
		if(!q.isEmpty()) {
			Map map = q.poll();
			for (int i = 0; i <4; i++) {	// 상하좌우 탐색
				x = map.x + dx[i];
				y = map.y + dy[i];
				if (x>=0 && y>=0 && x<n && y<m) {
//					System.out.println(x+" "+y);
					if(arr[x][y] == -1) continue;
					else if(arr[x][y] == 0) {
						check = true;
						q.add(new Map(x, y));
						arr[x][y] = arr[map.x][map.y]+1;
//						for (int k = 0; k < n; k++) {
//							for (int j = 0; j < m; j++) {
//								System.out.print(arr[k][j]+" ");
//							}
//							System.out.println();
//						}
//						System.out.println("---------");
					}
				}
			}
			search(x, y);
			return;
		}
		if(check) {
			for (int k = 0; k < n; k++) {
				for (int j = 0; j < m; j++) {
					if(arr[k][j] == 0) {
						System.out.println("-1");
						return;
					}
				}
			}
			System.out.println(arr[x][y]);
		}
		else System.out.println("0");
	
	}

}
