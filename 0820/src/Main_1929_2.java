import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 1929 소수 구하기 - 방법2
 * 제곱근까지의 소수를 구하는 방법 사용
 * 제곱근 자체의 시간복잡도 O(루트 n) 
 * @author kjh
 *
 */
public class Main_1929_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int j = N; j <= M; j++){
            boolean check = true;
		    for (int i = 2; i <= Math.sqrt(j); i++) {
                if (j % i == 0) {
					check = false;
					break;
			    }
		    }
            if (j == 1) check = false;
            if (j == 2) check = true;
            if (check) System.out.println(j);
		}
	}
}
