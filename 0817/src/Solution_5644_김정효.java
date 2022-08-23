import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 미완성
 * @author kjh
 *
 */
public class Solution_5644_김정효 {
	// 상우하좌
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] arr;
	static int[] p1, p2;
	static int m;
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int T = Integer.parseInt(br.readLine());
		 
		 for (int i = 1; i <= T; i++) {
			 arr = new int[10][10];
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 m = Integer.parseInt(st.nextToken());
			 int a = Integer.parseInt(st.nextToken());
			 StringTokenizer st1 = new StringTokenizer(br.readLine());
			 StringTokenizer st2 = new StringTokenizer(br.readLine());
			 p1 = new int[m];
			 p2 = new int[m];
			 for (int j = 0; j < m; j++) {	// 사용자 정보 받기
				p1[j] = Integer.parseInt(st1.nextToken());
				p2[j] = Integer.parseInt(st2.nextToken());
			}
			 for (int j = 0; j < a; j++) {	// 좌표에 충전 정보 입력
				st = new StringTokenizer(br.readLine());
				ap(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1,
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			 for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < arr[j].length; j2++) {
					System.out.print(arr[j][j2]);
					System.out.print("\t");
				}System.out.println();
			 }
		}

	}
	
	private static void ap(int x, int y, int charge, int per) {
		for(int i=0; i<=charge; i++) {
			for (int k = 0; k <= charge-i; k++) {
				if (x-i>=0 && y-k>=0 && x-i<10 && y-k<10) arr[x-i][y-k] = per;
				if (x-i>=0 && y+k>=0 && x-i<10 && y+k<10) arr[x-i][y+k] = per;
				if (x+i>=0 && y-k>=0 && x+i<10 && y-k<10) arr[x+i][y-k] = per;
				if (x+i>=0 && y+k>=0 && x+i<10 && y+k<10) arr[x+i][y+k] = per;
			}
		}
	}
	
	private static void move(int[] a1, int[] a2) {
		int a1_nx = 0, a1_ny = 0, a1_x = 0, a1_y = 0;
		int a2_nx = 9, a2_ny = 9;
		for (int i = 0; i < m; i++) {
			if(a1[i] == 1) {
				a1_x = a1_nx + dx[0];
				a1_y = a1_ny + dy[0];
				if (a1_x>=0 && a1_y>=0 && a1_x<10 && a1_y<10) {
					a1_nx = a1_x;
					a1_ny = a1_y;
				}
			}
		}
	}

}
