import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1227_김정효 {
	
//	private static boolean[][] visited;
	private static int[][] arr;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=10; i++) {
			br.readLine();		// 테케 번호는  저장 안하고 버림
			arr = new int[100][100];	// 미로
//			visited = new boolean[100][100];	// 방문체크
			int sr = -1, sc = -1;
			for(int j=0; j<100; j++) {
				String str = br.readLine();
				for(int k=0; k<100; k++) {
					arr[j][k] = str.charAt(k);	// -'0' 안해도 처리가능
					if(arr[j][k] == '2') { // 시작점인지 확인
						sr = i; sc = j;
					}
				}
			}
			int result = dfs(sr, sc);
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}// end of for testcase
		System.out.println(sb.toString());
	}// end of main
	
	private static int[] dr = {-1, 1, 0, 0};	// 상, 하, 좌, 우
	private static int[] dc = {0, 0, -1, 1};	// 상, 하, 좌, 우
	
	/** '3'에 도착하면 1을 리턴, 0을 리턴 */
	public static int dfs(int r, int c) {
		if(arr[r][c] == '1' /*|| visited[r][c]*/) return 0;		// 벽이면 되돌아가라 또는 방문했다면 (true면) 리턴
		if(arr[r][c] == '3') return 1;	// 목적지 도착했으면 리턴 1

//		visited[r][c] = true;	// 지나간 길이니깐 true 체크
		arr[r][c] = '1';
		int result = 0;
		for (int i = 0; i < dc.length && result == 0; i++) {
			result = dfs(r+dr[i], c+dc[i]);
		}
		return result;
	}

}
