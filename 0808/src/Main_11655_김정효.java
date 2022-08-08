import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11655_김정효 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		for(int i=0; i<arr.length; i++) {
			if (arr[i]>=65 && arr[i]<=90) {
				char c = (char)(arr[i]+13);
				if((int) c > 90) {
					System.out.print((char) (c-91+65));
					continue;
				}
				System.out.print((char)(arr[i]+13));
			}else if (arr[i]>=97 && arr[i]<=122) {
				char c = (char)(arr[i]+13);
				if((int) c > 122) {
					System.out.print((char) (c-123+97));
					continue;
				}
				System.out.print((char)(arr[i]+13));
			}else {
				System.out.print(arr[i]);
			}
		}

	}

}
