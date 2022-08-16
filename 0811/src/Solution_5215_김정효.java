import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_5215_김정효 {
	static int N, L;
	static int score, kcal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int i=1; i<=t; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			HashMap<Integer, Integer> map = new HashMap<>();
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				score = Integer.parseInt(st.nextToken());
				kcal = Integer.parseInt(st.nextToken());
				map.put(score, kcal);
			}
			Collections.sort(map, new Comparator<Integer, Integer>() {
			
			});
			
			
		}
	}
	


}
