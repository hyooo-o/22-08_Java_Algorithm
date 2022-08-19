import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * SWEA - D4. 3234 ��ȯ���� ��������
 * �ð��ʰ� ���� (static ���� ���� �ð� �ʰ� �߻�) => �Լ��� �Ķ���ͷ� �־��ֱ� 
 * @author multicampus
 *
 */
public class Solution_3234_����ȿ {
	static int result;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			result = 0;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			isSelected = new boolean[N];
			
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			pick(0, 0, 0, N, arr, isSelected);
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}

	private static void pick(int l, int r, int cnt, int N, int[] arr, boolean[] is) {
		if(cnt == N && l >= r) {
			result++;
			return;
		}
		if(l < r) return;
		
		for (int i = 0; i < N; i++) {
			if(!is[i]) {
				is[i] = true;
				pick(l+arr[i], r, cnt+1, N, arr, is);	// ��
				pick(l, r+arr[i], cnt+1, N, arr, is);	// ��
				is[i] = false;
			}
		}
		
	}
}
