import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_김정효 {
	static int N, M, R;
	static int[][] arr, temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		temp = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int j=0; j<R; j++) {
			int t = Integer.parseInt(st.nextToken());
			
			switch(t) {
				case (1):{	// 상하 반전
					one();
					break;
				}case (2):{	// 좌우 반전
					two();
					break;
				}case (3):{	// 오른쪽 90도 회전
					three();
	//				for(int i=0; i<arr.length; i++) {
	//					for(int k=0; k<arr[i].length; k++) {
	//						System.out.print(arr[i][k]+" ");
	//					}System.out.println();
	//				}
					break;
				}case (4):{	// 왼쪽 90도 회전
					four();
					break;
				}case (5):{
					five();
					break;
				}case (6):{
					six();
					break;
				}
			}
		}
		print();
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<temp[i].length; j++) {
				sb.append(temp[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void one() {
		temp = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				temp[N-1-i][j] = arr[i][j];
			}
		}arr = temp.clone();
	}

	public static void two() {
		temp = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				temp[i][M-1-j] = arr[i][j];
			}
		}arr = temp.clone();
	}
	
	public static void three() {
		if(arr.length != N) {
			int empty = N;
			N = M;
			M = empty;
		}
		temp = new int[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				temp[i][N-1-j] = arr[j][i];
			}
		}arr = temp.clone();
	}
	
	public static void four() {
		if(arr.length != N) {
			int empty = N;
			N = M;
			M = empty;
		}
		temp = new int[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				temp[M-1-i][j] = arr[j][i];
			}
		}arr = temp.clone();
	}
	
	public static void five() {
		if(arr.length != N) {
			int empty = N;
			N = M;
			M = empty;
		}
		temp = new int[N][M];
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				temp[i][j+M/2] = arr[i][j];		// 1 -> 2
			}
			for(int j=M/2; j<M; j++) {
				temp[i+N/2][j] = arr[i][j];		// 2 -> 3
			}
		}
		for(int i=N/2; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				temp[i-N/2][j] = arr[i][j];		// 4 -> 1
			}
			for(int j=M/2; j<M; j++) {
				temp[i][j-M/2] = arr[i][j];		// 3 -> 4
			}
		}arr = temp.clone();
	}
	
	public static void six() {
		if(arr.length != N) {
			int empty = N;
			N = M;
			M = empty;
		}
		temp = new int[N][M];
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				temp[i+N/2][j] = arr[i][j];		// 1 -> 4
			}
			for(int j=M/2; j<M; j++) {
				temp[i][j-M/2] = arr[i][j];		// 2 -> 1
			}
		}
		for(int i=N/2; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				temp[i][j+M/2] = arr[i][j];		// 4 -> 3
			}
			for(int j=M/2; j<M; j++) {
				temp[i-N/2][j] = arr[i][j];		// 3 -> 2
			}
		}arr = temp.clone();
	}
}
