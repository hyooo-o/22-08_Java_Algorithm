import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 2023 신기한 소수
 * 
 * @author multicampus
 *
 */
public class Main_2023_김정효 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] f_arr = {2, 3, 5, 7};
		for(int i=0; i<f_arr.length; i++) {
			for(int j=0; j<10; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(f_arr[i]).append(j);
			}
		}
		
		// 찾은 소수로 
	}
}
