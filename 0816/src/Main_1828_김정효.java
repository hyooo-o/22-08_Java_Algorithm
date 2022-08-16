import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 정올 - 1828. 냉장고
 * 탐욕 (greedy), 회의실 문제
 * @author kjh
 *
 */
public class Main_1828_김정효 {

	static class Refrigerator implements Comparable<Refrigerator> {
		int x, y;
		
		public Refrigerator(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Refrigerator o) {
			return this.y != o.y? this.y-o.y: this.x-o.x;
		}

	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Refrigerator[] ref = new Refrigerator[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ref[i] = new Refrigerator(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		List<Refrigerator> result = temperature(ref);
		System.out.println(result.size());
	}
	
	
	private static List<Refrigerator> temperature(Refrigerator[] ref) {
		List<Refrigerator> result = new ArrayList<>();
		Arrays.sort(ref);
		result.add(ref[0]);
		
		for (int i = 0; i < ref.length; i++) {
			if(result.get(result.size()-1).y < ref[i].x) {
				result.add(ref[i]);
			}
		}
		return result;
	}

}
