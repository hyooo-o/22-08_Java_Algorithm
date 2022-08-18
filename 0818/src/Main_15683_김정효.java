import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15683_김정효 {
	static int N, M, val, result, cnt, _max, arr[][];
	static int[] dx = {-1, 1, 0, 0};	// 상, 하, 좌, 우
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		_max = Integer.MIN_VALUE;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cctv();
		isValue();
		System.out.println(result);
		
	}
	
	private static void isValue() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					result++;
				}
			}
		}
	}
	
	private static void cctv() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				switch(arr[i][j]) {
				case (1):
					d1(i, j);
					break;
				case (2):
					d2(i, j);
					break;
				case (3):
					d3(i, j);
					break;
				case (4):
					d4(i, j);
					break;
//				case (5):
//					d5(i, j);
//					break;
				}
			}
		}
	}
	
	private static void d1(int i, int j) {
		for (int k = 0; k < 4; k++) {
			cnt = 0;
			int x = i+dx[k];
			int y = j+dy[k];
			while(x>=0 && x<N && y>=0 && y<M) {
				if (arr[x][y] == 6) {
					break;
				}
				cnt++;
				x += dx[k];
				y += dy[k];
			}
			if(_max < cnt) {
				_max = cnt;
				val = k;
			}
		}
		
		made(i, j);
	}
	
	private static void d2(int i, int j) {
		for (int k = 0; k < 2; k++) {
			cnt = 0;
			int x = i+dx[k];
			int y = j+dy[k];
			int x2 = i+dx[k+1];
			int y2 = j+dy[k+1];
			while(x>=0 && x<N && y>=0 && y<M) {
				if (arr[x][y] == 6) {
					break;
				}
				cnt++;
				x += dx[k];
				y += dy[k];
			}
			while(x2>=0 && x2<N && y2>=0 && y2<M) {
				if (arr[x2][y2] == 6) {
					break;
				}
				cnt++;
				x2 += dx[k+1];
				y2 += dy[k+1];
			}
			
			if(_max < cnt) {
				_max = cnt;
				val = k;
			}
		}
		
		made(i, j);
	}
	
	private static void d3(int i, int j) {
		for (int k = 0; k < 2; k++) {
			cnt = 0;
			int x = i+dx[k];
			int y = j+dy[k];
			int x2 = i+dx[k+2];
			int y2 = j+dy[k+2];
			while(x>=0 && x<N && y>=0 && y<M) {
				if (arr[x][y] == 6) {
					break;
				}
				cnt++;
				x += dx[k];
				y += dy[k];
			}
			while(x2>=0 && x2<N && y2>=0 && y2<M) {
				if (arr[x2][y2] == 6) {
					break;
				}
				cnt++;
				x2 += dx[k+2];
				y2 += dy[k+2];
			}
			
			if(_max < cnt) {
				_max = cnt;
				val = k;
			}
		}
		
		made(i, j);
	}
	
	private static void d4(int i, int j) {
		for (int k = 0; k < 2; k++) {
			cnt = 0;
			int x = i+dx[k];
			int y = j+dy[k];
			int x2 = i+dx[(k+1)%4];
			int y2 = j+dy[(k+1)%4];
			int x3 = i+dx[(k+2)%4];
			int y3 = j+dy[(k+2)%4];
			while(x>=0 && x<N && y>=0 && y<M) {
				if (arr[x][y] == 6) {
					break;
				}
				cnt++;
				x += dx[k];
				y += dy[k];
			}
			while(x2>=0 && x2<N && y2>=0 && y2<M) {
				if (arr[x2][y2] == 6) {
					break;
				}
				cnt++;
				x2 += dx[(k+1)%4];
				y2 += dy[(k+1)%4];
			}
			
			while(x3>=0 && x3<N && y3>=0 && y3<M) {
				if (arr[x3][y3] == 6) {
					break;
				}
				cnt++;
				x3 += dx[(k+2)%4];
				y3 += dy[(k+2)%4];
			}
			
			if(_max < cnt) {
				_max = cnt;
				val = k;
			}
		}
		
		made(i, j);
	}
	private static void made(int i, int j) {
		int x = i+dx[val];
		int y = j+dy[val];
		while(x>=0 && x<N && y>=0 && y<M && arr[x][y] != 6) {
			arr[x][y] = 1;
			x += dx[val];
			y += dy[val];
		}
		
	}
}
