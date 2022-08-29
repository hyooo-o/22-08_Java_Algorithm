import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main_11653_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		
		if (n == 1) return;
		for (int i = 2; i <= n; i++) {
			while(n != 1) {
//				if (n % i == 0 && check(i)) {	// 소수이면서 n의 약수이면
				if (n % i == 0) {
					n /= i;
					list.add(i);
					continue;
				}
				break;
			}
		}
		Collections.sort(list);
		for (int l : list) {
			System.out.println(l);
		}
	}

//	private static boolean check(int i) {
//		for (int j = 2; j < i; j++) {
//			if (i % j == 0) return false;
//		}
//		return true;
//	}

}
