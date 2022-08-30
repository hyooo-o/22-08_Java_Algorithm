import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * BOJ 17406. 배열돌리기4 (미완성)
 * @author kjh
 *
 */
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
		N = Integer.parseInt(st.nextToken());	// n x m
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
		}	// 배열 입력 완료
		temp = arr.clone();
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			for (int j = r-s; j <= r+s; j++) {
				for (int k = c-s; k <= c+s; k++) {
					if(j>c) {	// 아래
						temp[j][k-1] = arr[j][k];	// <-
					}
					else if(j<c) {	// 위
						if(k == r-s) {
							temp[j][k+1] = arr[j][k];
							continue;
						}
						temp[j][k+1] = arr[j][k];	// ->
					}
					else if(k>r) {
						temp[j+1][k] = arr[j][k];
					}
					else if(k<r) {
						temp[j-1][k] = arr[j][k];
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				total += temp[i][j];
			}
			_min = Math.min(_min, total);
		}
		System.out.println(_min);
	}
}
