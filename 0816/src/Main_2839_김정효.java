import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while(true) {
			if(n % 5 == 0) {		// 공배수 포함 5의 배수일 때
				cnt += n / 5;
				break;
			}else {
				n -= 3;
				cnt++;
			}
			if(n < 0) {
				cnt = -1;
				break;
			}
		}
		System.out.println(cnt);
	}
}
