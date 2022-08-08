import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * SWEA 9229 한빈이와 Spot Mart
 * 조합 문제 nC2
 * @author kjh
 *
 */
public class Solution_9229_김정효 {
	static int _max, total, m;
	static List<Integer> arr;
	static int[] number;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int j=1; j<=tc; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new ArrayList<>();
			number = new int[2];

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			_max = Integer.MIN_VALUE;
			comb(0, 0);
			_max = _max<0? -1: _max;
			sb.append("#").append(j).append(" ").append(_max).append("\n");
		}
		System.out.println(sb);

	}
	
	
	private static void comb(int cnt, int start) {
		if(cnt == 2) {
			total = 0;
			for(int i=0; i<2; i++) {
				total += number[i];
			}
			if(total <= m && total > _max) {
				_max = total;
			}
			return;
		}
		for(int i=start; i<arr.size(); i++) {
			number[cnt] = arr.get(i);
			comb(cnt+1, i+1);
		}
		
	}

}
