import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_김정효 {
	static int N, M, K;
	static int[][] arr, temp;
	static boolean[][] check;
	// 우, 하, 좌, 상
	final static int[] dx = {0, 1, 0, -1};		
	final static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		temp = new int[N][M];
		int total = 0;
		int _min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			rotate(r-1, c-1, s);
			arr = temp.clone();
			for(int[] a:temp) {
				for(int el: a ) {
					sb.append(el+" ");
				}
				sb.append("\n");
			}sb.append("\n");
		}
		System.out.println(sb);
		
		for(int[] a:arr) {
			for(int el: a ) {
				total += el;
			}
			_min = Math.min(total, _min);
		}
		System.out.println(_min);
	}
	
	private static void rotate(int r, int c, int s) {	// (r-s, c-s), (r+s, c+s)
		check = new boolean[N][M];
		int nr;
		int nc;
		int x = r-s;
		int y = c-s;
		
		int dir=0;
		
		while(true) {
			nr = x+dx[dir];	// 옮길 위치
			nc = y+dy[dir];
			
			if(nr<r-s || nr>r+s || nc<c-s || nc>c+s || check[nr][nc]) {
				dir = ++dir%4;
			}
			else {
				temp[nr][nc] = arr[x][y];
				check[nr][nc] = true;
				x += dx[dir]; 
				y += dy[dir];
			}
			
			if (x == r+s && y == c+s) break;
		}
	}
}
