import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_5658_김정효 {
	static Set<String> set;
	static int N, K, len;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			len = N / 4;
			set = new TreeSet<>();
			
			String str = br.readLine();
			recursive(str, 0);
			
			List<String> list = new ArrayList<String>(set);
			Collections.sort(list, Collections.reverseOrder());
			sb.append("#").append(i).append(" ").append(Integer.parseInt(list.get(K-1), 16)).append("\n");
		}
		System.out.println(sb);
	}

	private static void recursive(String str, int cnt) {
		if (cnt == len) {
			return;
		}
		
		set.add(str.substring(0, len));
		set.add(str.substring(len, len*2));
		set.add(str.substring(len*2, len*3));
		set.add(str.substring(len*3, len*4));

		// 한 칸씩 회전해서 넘기기
		String str1 = str.charAt(N-1) + str.substring(0, N-1);
		
		recursive(str1, cnt+1);
	}

}
