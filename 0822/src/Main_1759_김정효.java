import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * BOJ 1759. 암호만들기
 * 1. 알파벳이 증가하는 순서
 * 2. 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
 * 조합
 * @author kjh
 *
 */
public class Main_1759_김정효 {
	static int L, C;
	static StringBuilder sb = new StringBuilder();
	static String[] str, arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[L];
		str = br.readLine().split(" ");
		Arrays.sort(str);
		check(0, 0, 0, 0);
	}

	private static void check(int start, int cnt, int cnt1, int cnt2) {
		if(cnt == L) {
			if(cnt1 >=1 && cnt2 >=2) {
				for (String a: arr) {
					System.out.print(a);
				}
				System.out.println();
				return;
			}
			return;
		}
		for (int i = start; i < C; i++) {
			if (str[i].equals("a") || str[i].equals("e") || str[i].equals("i") || str[i].equals("o") || str[i].equals("u")) {
				arr[cnt] = str[i];
				check(i+1, cnt+1, cnt1+1, cnt2);
				continue;
			}
			arr[cnt] = str[i];
			check(i+1, cnt+1, cnt1, cnt2+1);
		}
		return;
	}

}
