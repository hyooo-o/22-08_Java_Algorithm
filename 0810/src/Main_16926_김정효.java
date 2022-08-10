import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16926_김정효 {
	static int[][] arr, TF;
	static int n, m, r;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i=0; i<n; i++) {	
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}// --------입력 완료 -----------
		}
		while(r > 0) {
			TF = new int[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					recursive(i, j);
				}
			}
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<m; j++) {
//					System.out.print(arr[i][j]+" ");
//				}System.out.println();
//			}System.out.println();
			r--;
			arr = TF.clone();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(TF[i][j]).append(" ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void recursive(int i, int j) {
		// 밖
		if(i==0 && j>0 && TF[i][j-1] == 0) {			// 좌
			TF[i][j-1] = arr[i][j];
		}else if(j==0 && i<n-1 && TF[i+1][j] == 0) {	// 하
			TF[i+1][j] = arr[i][j];
		}else if(i==n-1 && j<m-1 && TF[i][j+1] == 0) {	// 우
			TF[i][j+1] = arr[i][j];
		}else if(j==m-1 && i>0 && TF[i-1][j] == 0) {	// 상
			TF[i-1][j] = arr[i][j];
		}
		// 안
		if(i>0 && j>0 && i<n-1 && j<m-1) {
			if(TF[i-1][j] != 0 && TF[i][j-1] == 0) {		// 좌
				TF[i][j-1] = arr[i][j];
			}else if(TF[i][j-1] != 0 && TF[i+1][j] == 0 && i<n-2 && j<m-2) {	// 하
				TF[i+1][j] = arr[i][j];
			}else if(TF[i][j+1] == 0 && j<m-2) {	// 우
				TF[i][j+1] = arr[i][j];
			}else if(TF[i-1][j] == 0) {	// 상
				TF[i-1][j] = arr[i][j];
			}
		}
//		for(int k=0; k<n; k++) {
//			for(int l=0; l<m; l++) {
//				System.out.print(TF[k][l]+" ");
//			}System.out.println();
//		}System.out.println();
	}
}
