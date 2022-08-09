import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * BOJ 11656 접미사 배열
 * 문자열 자르기: substring
 * 문자열 정렬: Arrays.sort()
 * @author multicampus
 *
 */
public class Main_11656_김정효 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String[] arr = new String[str.length()];
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.substring(i);
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
