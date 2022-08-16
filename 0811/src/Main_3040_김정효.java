import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040_김정효 {
	static boolean[] visited;
	static int[] arr, result;
	static int _sum, cnt;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		visited = new boolean[9];
		result = new int[7];
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		test(0, 0);
		System.out.println(sb);
	}	
	
	private static void test(int start, int _sum) {
		if(start == 7) {
			if(_sum == 100) {
				sb = new StringBuilder();
				for(int a: result) {
					sb.append(a).append("\n");
				}
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[start] = arr[i];
				test(start+1, _sum+arr[i]);
				visited[i] = false;
			}
		}
	}
}
