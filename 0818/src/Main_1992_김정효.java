import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_김정효 {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}	// end of input
		tree(N, 0, 0);
		System.out.println(sb);
	}
	
	
	private static void tree(int size, int x, int y) {
		if(isAvailable(size, x, y)) {
			sb.append(arr[x][y]);
			return;
		}
		
		int mid = size/2;
		sb.append('(');
		
		tree(mid, x, y);	// 왼위
		tree(mid, x, y+mid);	// 오위
		tree(mid, x+mid, y);	// 왼아래
		tree(mid, x+mid, y+mid);	// 오아래
		
		sb.append(')');
	}
	
	// 압축 가능한지 체크
	private static boolean isAvailable(int size, int x, int y) {
		int num = arr[x][y];
		
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(num != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
