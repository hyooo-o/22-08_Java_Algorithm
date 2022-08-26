import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_No3_김정효 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T  = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int N  = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] card = new int[N];
			for (int j = 0; j < N; j++) {
				card[j] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			
			
			
			sb.append("#").append(i).append(" ").append(0).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int j) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
