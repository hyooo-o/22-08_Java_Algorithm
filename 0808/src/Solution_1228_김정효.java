import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * SWEA 1228 암호문1
 * @author kjh
 *
 */
public class Solution_1228_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1; i<=10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			LinkedList<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<d; j++) {
				char c = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for(int k=0; k<y; k++) {
					list.add(x+ k, Integer.parseInt(st.nextToken()));
				}
				
			}
			StringBuilder sb = new StringBuilder("#"+i+" ");
			for(int j=0; j<10; j++) {
				sb.append(list.get(j)+" ");
			}
			System.out.println(sb);
		}
		

	}

}
