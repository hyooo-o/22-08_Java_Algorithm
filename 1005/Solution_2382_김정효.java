import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1시간마다 이동방향에 있는 다음 셀로 이동
 * 품이 칠해진 셀에 도착하면 군집 내 미생물의 절반이 죽고, 이동방향이 반대
 * 두 개 이상의 군집이 한 셀에 모이는 경우, 합침  => 미생물 수가 가장 많은 군집의 이동방향, 미생물 수 합침
 * M시간 후 남아 있는 미생물 수의 총합
 * @author kjh
 *
 */
public class Solution_2382_김정효 {
	static int N, M, K, map[][][], arr[][][];
	static boolean visit[][];
	static Queue<int[]> q = new ArrayDeque<>();
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	
//	public void c(int x, int y, int count, int d, boolean visit) {
//		this.x = x;
//		
//	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N][2];

			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				q.offer(new int[] {x, y, cnt, dir});
				map[x][y][0] = cnt;
				map[x][y][1] = dir;
			}
			
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					System.out.print(map[x][y][0]+" ");
				}
				System.out.println();
			}
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
			
			for (int i = 0; i < M; i++) {
				arr = new int[N][N][2];
				bfs2();
				
//				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
//				for (int x = 0; x < N; x++) {
//					for (int y = 0; y < N; y++) {
//						System.out.print(map[x][y][0]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
				
			}
			
			sb.append("#").append(tc).append(" ").append(total()).append("\n");
		}
		
		System.out.print(sb.toString());
	}

	private static int total() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j][0] > 0) {
					cnt += arr[i][j][0];
				}
			}
		}
		return cnt;
	}
	
	private static void bfs2() {
		int size = q.size();
		while(--size > 0) {
//			int[] cur = q.poll();
//			int i = cur[0];
//			int j = cur[1];
			
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// map[i][j]에서의 상하좌우 탐색
				List<int[]> list = new ArrayList<>();
				for (int k = 1; k < 5; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					int d = k;
					
					if (d % 2 == 0) d -= 1;
					else d += 1;
					
					if (nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny][1]==d) {
						list.add(new int[] {map[nx][ny][0], map[nx][ny][1]});
					}
				}// 탐색 끝
				
				int index = 0;
				// 미생물 중복 처리
				if (list.size() > 1) {
					// 미생물 수가 가장 많은 인덱스 찾기
					for (int c = 1; c < list.size(); c++) {
						if (list.get(index)[0] < list.get(c)[0]) {
							index = c;
						}
					}
					// 찾은 인덱스로 방향 바꾸기
					arr[i][j][1] = list.get(index)[1];
					// 미생물 수 합쳐주기
					for (int c = 0; c < list.size(); c++) {
						arr[i][j][0] +=  list.get(c)[0];
					}
					q.offer(new int[] {i, j, arr[i][j][0], arr[i][j][1]});
				}
				// 미생물 중복 없을 때
				else if (list.size() == 1) {
					// 약품 범위라면
					if (i==0 || j==0 || i==N-1 || j==N-1) {
						list.get(0)[0] /= 2;
						if (list.get(0)[1] % 2 == 0) list.get(0)[1] -= 1;
						else list.get(0)[1] += 1;
					}
					arr[i][j][0] = list.get(0)[0];
					arr[i][j][1] = list.get(0)[1];
					q.offer(new int[] {i, j, arr[i][j][0], arr[i][j][1]});
				}
//				view();
			}
				
			}
		}
		copy();
	}
	
	private static void view() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j][0]+" ");
			}
			System.out.println();
		}
		System.out.println("=====================");
	}

	private static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j][0] = arr[i][j][0];
				map[i][j][1] = arr[i][j][1];
			}
		}
	}
	
}